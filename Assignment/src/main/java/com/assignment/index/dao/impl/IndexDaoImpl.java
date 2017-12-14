package com.assignment.index.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.assignment.index.dao.IndexDao;
import com.assignment.utility.AppProperties;
import com.assignment.utility.GetSessionDao;
import com.assignment.utility.UtilityClass;
import com.google.gson.Gson;

@Repository
public class IndexDaoImpl extends GetSessionDao implements IndexDao {
	 private static Gson gson = new Gson();
	@Override
	public boolean saveObjects(String entityName, String country, JSONArray data) {
		boolean res = false;

		try {
			if (data != null && data.length() > 0) {
				JSONObject tempObject = null;
				Session session = getSession();
				Object classObj = UtilityClass.getClassObject(entityName);
				int batchSize = Integer.parseInt(AppProperties.getInstance().getHibernateBatchSize());

				for (int i = 0; i < data.length(); i++) {
					tempObject = data.getJSONObject(i);
					tempObject.put("country", country);					
					classObj = gson.fromJson(tempObject.toString(), classObj.getClass());
					session.saveOrUpdate(classObj);
					
					//Insert into database in batches
					
					if(i % batchSize==0)
					{
						session.flush();
						session.clear();
					}
				}
				
				res= true;
			} else {
				System.out.println("no data to save");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public Map<String, Object> viewStats(String country, String entityClass, JSONArray statsFilter) {
		Map<String, Object> res = new HashMap<>();
		try {
			Conjunction conjunction = Restrictions.conjunction();			
			Object classObj = UtilityClass.getClassObject(entityClass);
			Criteria criteria = getSession().createCriteria(classObj.getClass());
			conjunction.add(Restrictions.eq("country", country));
			for(int i=0; i<statsFilter.length(); i++)
			{
				
				JSONObject filterObject = statsFilter.getJSONObject(i);
				
				if(filterObject.getString("colName").equalsIgnoreCase("Year"))
				{
					
					Object o = (Object) filterObject.get("colValue");
					
					conjunction.add(Restrictions.sqlRestriction("Year in (" +o.toString().replaceAll("\\[", "").replaceAll("\\]","") +")" ));
				}
			}
			
			List<Object>list  = criteria.add(conjunction).list();
			res.put("tableContent", list);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<Object> getFilterData(String country, String entityClass) {
		List<Object> filterDataList = new ArrayList<>();
		try {
			Conjunction conjunction = Restrictions.conjunction();
			conjunction.add(Restrictions.eq("country", country));
			 filterDataList = (List<Object>)getSession().createCriteria(UtilityClass.getClassObject(entityClass).getClass()).add(conjunction).setProjection(Projections.sqlProjection("distinct(Year)", new String[] {"year"}, new Type[] {StandardBasicTypes.STRING})).list();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return filterDataList;
	}

}
