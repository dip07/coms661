/**
 * 
 */
package com.models;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.models.Roles.Role;

/**
 * @author dipanjankarmakar
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="users")
public class Users {
	
	@XmlElement(name = "user", type = User.class)
	private ArrayList<User> userList= new ArrayList<User>();
	
	
	
	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public static class User
	{
		private String netId;
		private String name;
		private String emailId;
		private String password;
		private Role role;
		public String getNetId() {
			return netId;
		}
		public void setNetId(String netId) {
			this.netId = netId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		@Override
		public String toString() {
			return "User [netId=" + netId + ", name=" + name + ", emailId="
					+ emailId + ", password=" + password + ", role=" + role
					+ "]";
		}
		
	}
	
	public static void main(String args[])
	{
		Users users= new Users();
		
		User user= new User();
		user.setEmailId("dipanjan@iastate.edu");
		user.setNetId("dipanjan");
		user.setPassword("pass1");
		Role role= new Role();
		role.setRoleName("student");
		user.setRole(role);
		
		users.setUserList(new ArrayList<Users.User>());
		users.getUserList().add(user);
		
		user= new User();
		user.setEmailId("gaurav@iastate.edu");
		user.setNetId("gau");
		user.setPassword("pass2");
		role= new Role();
		role.setRoleName("instructor");
		user.setRole(role);
		users.getUserList().add(user);
		
		
		

		try {

			String fileLocation="/Users/dipanjankarmakar/Documents/Isu Google Drive/Isu Studies Google Drive/4th Sem/661/";
			File file = new File(fileLocation+"users.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(users, file);
			jaxbMarshaller.marshal(users, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
