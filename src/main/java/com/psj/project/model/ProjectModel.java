package com.psj.project.model;

public class ProjectModel {
	int seq; 
	String title; 
	String projectStartDate; 
	String projectEndDate; 
	String description; 
	int companySeq;
	
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the projectStartDate
	 */
	public String getProjectStartDate() {
		return projectStartDate;
	}
	
	/**
	 * @param projectStartDate the projectStartDate to set
	 */
	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	
	/**
	 * @return the projectEndDate
	 */
	public String getProjectEndDate() {
		return projectEndDate;
	}
	
	/**
	 * @param projectEndDate the projectEndDate to set
	 */
	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the companySeq
	 */
	public int getCompanySeq() {
		return companySeq;
	}
	
	/**
	 * @param companySeq the companySeq to set
	 */
	public void setCompanySeq(int companySeq) {
		this.companySeq = companySeq;
	}
}
