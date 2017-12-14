package com.assignment.index.service;

import org.json.JSONArray;
import org.json.JSONObject;

public interface IndexService {
	
	JSONObject syncStats(String link, String country, String entityClass);
	JSONObject viewStats(String country, String entityClass, JSONArray years);
	JSONObject getFilterData(String country, String entityClass);

}
