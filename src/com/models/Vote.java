/**
 * 
 */
package com.models;

/*
 * @author Gaurav Bhatt
 *
 */
public class Vote {
	
	private String voterID;
	private String email;
	private int timeout;
	private String instructor;
	private String isConfidential;
	private String comments;
	private boolean sendRemainder;
	private boolean isArchived;
	private boolean isLatest;
	private Boolean voteDone;
	
	public boolean getVote() {
		return voteDone;
	}
	
	public String getVoterId() {
		return voterID;
	}
	public void setVoterId(String ID) {
		this.voterID = ID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public boolean isArchived() {
		return isArchived;
	}
	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}
	public boolean isLatest() {
		return isLatest;
	}
	public void setLatest(boolean isLatest) {
		this.isLatest = isLatest;
	}
	@Override
	public String toString() {
		return comments;	
	}
	
	

}
