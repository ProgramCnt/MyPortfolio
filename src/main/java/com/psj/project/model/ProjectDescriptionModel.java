package com.psj.project.model;

public class ProjectDescriptionModel {
	int seq; 
	String title; 
	String description; 
	int projectSeq;
	
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
	 * @return the projectSeq
	 */
	public int getProjectSeq() {
		return projectSeq;
	}
	
	/**
	 * @param projectSeq the projectSeq to set
	 */
	public void setProjectSeq(int projectSeq) {
		this.projectSeq = projectSeq;
	} 
}
