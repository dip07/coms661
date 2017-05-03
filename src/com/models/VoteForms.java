/**
 * 
 */
package com.models;

import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="VoteForms")
public class VoteForms {
	
	@XmlElement(name = "VoteForm", type = VoteForm.class)
	private ArrayList<VoteForm> voteFormList= new ArrayList<VoteForm>();
	

	public ArrayList<VoteForm> getVoteFormList() {
		return voteFormList;
	}


	public void setVoteFormList(ArrayList<VoteForm> voteFormList) {
		this.voteFormList = voteFormList;
	}


	public static class VoteForm
	{
		String adminName;
		String adminNO;
		String AdminEmail;
		
		String Topic;
		
		ArrayList<String> voteOptions;
		String [] voteOption;
		String participants;
		String voteID;
		
		public String getVoteID() {
			return voteID;
		}

		public void setVoteID(String voteID) {
			this.voteID = voteID;
		}

		public String getParticipants() {
			return participants;
		}

		public void setParticipants(String participants) {
			this.participants = participants;
		}

		public String[] getVoteOption() {
			return voteOption;
		}

		public void setVoteOption(String[] voteOption) {
			this.voteOption = voteOption;
		}

		public String getAdminName() {
			return adminName;
		}

		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}

		public String getAdminNO() {
			return adminNO;
		}

		public void setAdminNO(String adminNO) {
			this.adminNO = adminNO;
		}

		public String getAdminEmail() {
			return AdminEmail;
		}

		public void setAdminEmail(String adminEmail) {
			AdminEmail = adminEmail;
		}

		public String getTopic() {
			return Topic;
		}

		public void setTopic(String topic) {
			Topic = topic;
		}

		public ArrayList<String> getVoteOptions() {
			return voteOptions;
		}

		public void setVoteOptions(ArrayList<String> voteOptions) {
			this.voteOptions = voteOptions;
		}

		@Override
		public String toString() {
			return "VoteForm [adminName=" + adminName + ", adminNO=" + adminNO + ", AdminEmail=" + AdminEmail
					+ ", Topic=" + Topic + ", voteOptions=" + voteOptions + ", voteOption="
					+ Arrays.toString(voteOption) + ", participants=" + participants + ", voteID=" + voteID + "]";
		}

	
		
	}

}
