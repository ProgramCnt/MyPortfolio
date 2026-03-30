package com.psj.project.model;

public class ActivitiesModel {
	String title;
	String activityStartDate; 
	String activityEndDate;
	String description;
	
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
	 * @return the activityStartDate
	 */
	public String getActivityStartDate() {
		return activityStartDate;
	}
	
	/**
	 * @param activityStartDate the activityStartDate to set
	 */
	public void setActivityStartDate(String activityStartDate) {
		this.activityStartDate = activityStartDate;
	}
	
	/**
	 * @return the activityEndDate
	 */
	public String getActivityEndDate() {
		return activityEndDate;
	}
	
	/**
	 * @param activityEndDate the activityEndDate to set
	 */
	public void setActivityEndDate(String activityEndDate) {
		this.activityEndDate = activityEndDate;
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
}
