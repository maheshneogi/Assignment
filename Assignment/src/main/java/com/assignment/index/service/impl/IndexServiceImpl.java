package com.assignment.index.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.index.dao.IndexDao;
import com.assignment.index.service.IndexService;
import com.assignment.model.MaxTemp;
import com.assignment.utility.UtilityClass;


@Service
@Transactional
public class IndexServiceImpl implements IndexService {

	@Autowired
	IndexDao indexDao;
	
	/**
	 * Reads all the content from the given link and inserts/updates the required stats into database
	 */
	@Override
	public JSONObject syncStats(String link, String country, String entityClass) {
		
		JSONObject res = new JSONObject();
		try {
		     // Create a URL for the desired page
		     URL url = new URL(link);
		     //First open the connection 
		     HttpURLConnection conn=(HttpURLConnection) url.openConnection();
		     conn.setConnectTimeout(60000); // timing out in a minute
		     BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		     StringBuilder sb= new StringBuilder();		     
		     String str;
		    while ((str = in.readLine()) != null) {
		      sb.append(str);
		      sb.append("\n");
		    }
		    
		    if(sb!=null)
		    {
		    	str = UtilityClass.getRequiredContent(sb.toString());
		    	if(str!=null)
		    	{
		    		JSONArray reqData = UtilityClass.createPojoObjects(str);
		    		if(reqData.length()>0)
		    		{
						if (indexDao.saveObjects(entityClass, country, reqData)) {
							System.out.println("successful");
							res.put("responseMsg", "Synced successfully");
						}else
				    	{
				    		System.out.println("something went wrong while saving the data");
				    		res.put("responseMsg", "Something went wrong while saving the data!!");
				    	}

		    			/*for (int j = 0; j < reqData.length(); j++) {
		    				System.out.println(reqData.get(j));
		    			}*/
		    		}
		    	}
		    	else
		    	{
		    		System.out.println("something went wrong while fetching the data");
		    		res.put("responseMsg", "Something went wrong while fetching the data!!");
		    	}
		    }
		    
		    in.close();
		} catch (Exception e) {
		   e.printStackTrace();
		} 
		return res;
	}

	@Override
	public JSONObject viewStats(String country, String entityClass, JSONArray statsFilter) {
			JSONObject res = new JSONObject();
			JSONArray mainArray = new JSONArray();
			JSONArray jArray = null;
			try {
				if(country!=null && entityClass!=null && statsFilter!=null&& statsFilter.length() >0)
				{
					Map<String, Object> resMap= indexDao.viewStats(country, entityClass, statsFilter);
					if(resMap!=null && resMap.containsKey("tableContent"))
					{
						//create content to display in nvd3 line chart
						List<Object> l = (List<Object>) resMap.get("tableContent");
						JSONObject temp =null;
						 String[] nameArray = null;
						for(Object o : l)
						{
							String year = null;
							jArray = new JSONArray();
							  Field[] fields = o.getClass().getDeclaredFields();
							  nameArray = new String[fields.length];
							    for (int i = 0; i < fields.length; i++) {
							      String name = fields[i].getName();
							      fields[i].setAccessible(true);
						          Object value = fields[i].get(o);
							      if(!name.equalsIgnoreCase("Year") && !name.equalsIgnoreCase("country"))
							      {							      	
							          temp = new JSONObject();
							          temp.put("x", i);
							          temp.put("y", value!=null?Double.valueOf(String.valueOf(value)):0.0);							         
							          nameArray[i]=name;
							          jArray.put(temp);
							      }
							      else if(!name.equalsIgnoreCase("country"))
							      {
							    	  year = String.valueOf(value);
							      }
							    }					   
							     
							    temp = new JSONObject();
							    temp.put("key", year);
							    temp.put("values", jArray);
							    mainArray.put(temp);
						}
						res.put("dataForGraph", mainArray);
						res.put("xAxisMap", nameArray);
					}
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return res;
	}

	@Override
	public JSONObject getFilterData(String country, String entityClass) {
		
		JSONObject res = new JSONObject();
		
		try {
			List<Object> filterData= indexDao.getFilterData(country, entityClass);
			if(filterData!=null && filterData.size()>0)
			{
				String[] filterDataArray = new String[filterData.size()];
			for(int i=0; i<filterData.size();i++)
			{
				filterDataArray[i] = (String)filterData.get(i);
				res.put("filterData", filterDataArray);
			}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

}
