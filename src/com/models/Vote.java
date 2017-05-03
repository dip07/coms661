/**
 * 
 */
package com.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Vote")
public class Vote{

	public ArrayList<MyVoteForm> getMyVoteFormList() {
		return myVoteFormList;
	}

	public void setMyVoteFormList(ArrayList<MyVoteForm> myVoteFormList) {
		this.myVoteFormList = myVoteFormList;
	}

	@XmlElement(name = "MyVoteForm", type = MyVoteForm.class)
	private ArrayList<MyVoteForm> myVoteFormList= new ArrayList<MyVoteForm>();
	
	public static class MyVoteForm
	{
		String voteID;
		String userName;
		static String voteUserID;
		
		String voteOption;
		String comment;
		
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public static String getVoteUserID() {
			return voteUserID;
		}
		public void setVoteUserID(String voteUserID) {
			this.voteUserID = voteUserID;
		}
		public String getVoteOption() {
			return voteOption;
		}
		public void setVoteOption(String voteOption) {
			this.voteOption = voteOption;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		
		@Override
		public String toString() {
			return "MyVoteForm [userName=" + userName + ", userID=" + voteUserID + ", voteOption=" + voteOption
					+ ", comment=" + comment + "]";
		}
		
	}

}
