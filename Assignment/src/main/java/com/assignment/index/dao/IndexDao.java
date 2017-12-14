package com.assignment.index.dao;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;

public interface IndexDao {
	
	boolean saveObjects(String entityName, String country, JSONArray data);
	Map<String, Object> viewStats(String country, String entityClass, JSONArray statsFilter);
	List<Object> getFilterData(String country, String entityClass);
	

}
