package com.assignment.model;

import java.io.Serializable;


public class CompositeKeyClass implements Serializable{
	
	private Integer Year;
	private String country;
	
	public CompositeKeyClass() {
		 
	}
 
	public CompositeKeyClass(Integer year, String country) {
		this.Year = year;
		this.country = country;
	}

	public Integer getYear() {
		return Year;
	}

	public void setYear(Integer year) {
		Year = year;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((country == null) ? 0 : country.hashCode());
		result = prime * result + Year;
		return result;
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeKeyClass other = (CompositeKeyClass) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (Year != other.Year)
			return false;
		return true;
	}
	

}
