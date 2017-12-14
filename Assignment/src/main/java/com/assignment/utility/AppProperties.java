package com.assignment.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {
	
	private static Properties properties;

	private AppProperties() {

		InputStream in = this.getClass().getClassLoader().getResourceAsStream("applications.properties");
		try {
			properties = new Properties();
			properties.load(in);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static AppProperties getInstance() {

		AppProperties INSTANCE = new AppProperties();
		return INSTANCE;
	}
	
	public  String getPojoPackage() {
		return properties.getProperty("pojo.package");
	}
	
	public  String getHibernateBatchSize() {
		return properties.getProperty("hibrenate.batch.size");
	}
}
