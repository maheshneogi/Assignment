package com.assignment.utility;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

public class UtilityClass {

	
	/**
	 * Gives the required content which contains the stats
	 * 
	 * @return string which contains stats
	 */
	public static String getRequiredContent(String input) {
		if (input != null) {
			String[] paragraphs = input.split("(?m:^$)");
			if (paragraphs.length > 1)
				return paragraphs[1].replaceFirst("\\n", "");

		}
		return null;

	}

	
	/**
	 * creates json objects from the string which can be inserted into data base 
	
	 * @return returns json array of json objects where each object can be inserted into database
	 * as a row
	 */
	public static JSONArray createPojoObjects(String input) {
		JSONArray jArray = new JSONArray();

		try {
			if (input != null) {
				BufferedReader br = new BufferedReader(new StringReader(input));
				
				String[] colNames = br.readLine().split("\\s+");				
				String[] data = null;
				String line = null;
				JSONObject tempObject = null;
				while ((line = br.readLine()) != null) {
					data = line.split("\\s{1,8}");
					tempObject = new JSONObject();
					for (int i = 0; i < data.length; i++) {
						tempObject.put(colNames[i], data[i].matches("^[-+]?\\d+(\\.\\d+)?$") ? data[i] : null);

					}
					jArray.put(tempObject);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		

		return jArray;

	}
	
	public static List<?> getDataForIn(String colValue, String coldataType) {
		List<?> dataList = null;
		if (colValue != null)
			try {
				String[] datArr = colValue.split(",");
				if (coldataType.equals("Integer")) {
					List<Integer> data = new ArrayList<Integer>();
					for (String colval : datArr) {
						if (!colval.isEmpty())
							data.add(Integer.parseInt(colval));
					}
					dataList = data;				
				} else
					dataList = Arrays.asList(datArr);
			} catch (Exception e) {
				e.printStackTrace();
			}		
		return dataList;
	}
	
	public static Object getClassObject(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		Gson gson = new Gson();
		String clsName = AppProperties.getInstance().getPojoPackage() + "." + className;
		return Class.forName(clsName).newInstance();
	}
	

}
