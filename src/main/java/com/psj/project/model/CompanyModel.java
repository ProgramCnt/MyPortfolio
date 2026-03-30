package com.psj.project.model;

public class CompanyModel {
	int seq;
	String companyName;
	String belonging;
	String position;
	String workStartDate; 
	String workEndDate;
	
	/**
	 * @return the seq
	 */
	public int getSeq() {
		return seq;
	}
	
	/**
	 * @param seq the seq to set
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * @return the belonging
	 */
	public String getBelonging() {
		return belonging;
	}
	
	/**
	 * @param belonging the belonging to set
	 */
	public void setBelonging(String belonging) {
		this.belonging = belonging;
	}
	
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * @return the workStartDate
	 */
	public String getWorkStartDate() {
		return workStartDate;
	}
	
	/**
	 * @param workStartDate the workStartDate to set
	 */
	public void setWorkStartDate(String workStartDate) {
		this.workStartDate = workStartDate;
	}
	
	/**
	 * @return the workEndDate
	 */
	public String getWorkEndDate() {
		return workEndDate;
	}
	
	/**
	 * @param workEndDate the workEndDate to set
	 */
	public void setWorkEndDate(String workEndDate) {
		this.workEndDate = workEndDate;
	}
}
