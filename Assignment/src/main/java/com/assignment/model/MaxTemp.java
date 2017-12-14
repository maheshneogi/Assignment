package com.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="max_temp")
@IdClass(value=CompositeKeyClass.class)
public class MaxTemp {
	
	
	private Integer Year;	
	private String country;
	
	private String JAN;
	private String FEB;
	private String MAR;
	private String APR;
	private String MAY;
	private String JUN;
	private String JUL;
	private String AUG;
	private String SEP;
	private String OCT;
	private String NOV;
	//DEC is a key word	
	private String DEC;
	
	private String WIN;
	private String SPR;
	private String SUM;
	private String AUT;
	private String ANN;
	
	
	public MaxTemp() {
		
	}	
	
	public MaxTemp(Integer year, String country, String jAN, String fEB, String mAR, String aPR, String mAY, String jUN,
			String jUL, String aUG, String sEP, String oCT, String nOV, String dEC, String wIN, String sPR, String sUM,
			String aUT, String aNN) {
		super();
		Year = year;
		this.country = country;
		JAN = jAN;
		FEB = fEB;
		MAR = mAR;
		APR = aPR;
		MAY = mAY;
		JUN = jUN;
		JUL = jUL;
		AUG = aUG;
		SEP = sEP;
		OCT = oCT;
		NOV = nOV;
		DEC = dEC;
		WIN = wIN;
		SPR = sPR;
		SUM = sUM;
		AUT = aUT;
		ANN = aNN;
	}
	
	
	@Id
	public Integer getYear() {
		return Year;
	}
	public void setYear(Integer year) {
		Year = year;
	}
	
	@Id
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getJAN() {
		return JAN;
	}
	public void setJAN(String jAN) {
		JAN = jAN;
	}
	public String getFEB() {
		return FEB;
	}
	public void setFEB(String fEB) {
		FEB = fEB;
	}
	public String getMAR() {
		return MAR;
	}
	public void setMAR(String mAR) {
		MAR = mAR;
	}
	public String getAPR() {
		return APR;
	}
	public void setAPR(String aPR) {
		APR = aPR;
	}
	public String getMAY() {
		return MAY;
	}
	public void setMAY(String mAY) {
		MAY = mAY;
	}
	public String getJUN() {
		return JUN;
	}
	public void setJUN(String jUN) {
		JUN = jUN;
	}
	public String getJUL() {
		return JUL;
	}
	public void setJUL(String jUL) {
		JUL = jUL;
	}
	public String getAUG() {
		return AUG;
	}
	public void setAUG(String aUG) {
		AUG = aUG;
	}
	public String getSEP() {
		return SEP;
	}
	public void setSEP(String sEP) {
		SEP = sEP;
	}
	public String getOCT() {
		return OCT;
	}
	public void setOCT(String oCT) {
		OCT = oCT;
	}
	public String getNOV() {
		return NOV;
	}
	public void setNOV(String nOV) {
		NOV = nOV;
	}
	@Column(name="DECEMBER")
	public String getDEC() {
		return DEC;
	}
	public void setDEC(String dEC) {
		DEC = dEC;
	}
	public String getWIN() {
		return WIN;
	}
	public void setWIN(String wIN) {
		WIN = wIN;
	}
	public String getSPR() {
		return SPR;
	}
	public void setSPR(String sPR) {
		SPR = sPR;
	}
	public String getSUM() {
		return SUM;
	}
	public void setSUM(String sUM) {
		SUM = sUM;
	}
	public String getAUT() {
		return AUT;
	}
	public void setAUT(String aUT) {
		AUT = aUT;
	}
	public String getANN() {
		return ANN;
	}
	public void setANN(String aNN) {
		ANN = aNN;
	}
	
	
	
	

}
