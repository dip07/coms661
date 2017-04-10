/**
 * 
 */
package com.models;

import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author dipanjankarmakar
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="roles")
public class Roles {

	@XmlElement(name = "role", type = Role.class)
	private ArrayList<Role> roleList= new ArrayList<Role>();
	
	public ArrayList<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(ArrayList<Role> roleList) {
		this.roleList = roleList;
	}

	public static class Role
	{
		private Integer roleId;
		private String roleName;
		public Integer getRoleId() {
			return roleId;
		}
		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}
		public String getRoleName() {
			return roleName;
		}
		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}
		@Override
		public String toString() {
			return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
		}
	}
	
	public static void main(String args[])
	{
		Roles roles= new Roles();
		Role role = new Role();
		role.setRoleId(1);
		role.setRoleName("student");
		roles.setRoleList(new ArrayList<Roles.Role>());
		roles.getRoleList().add(role);
		
		role= new Role();
		role.setRoleId(2);
		role.setRoleName("instructor");
		roles.getRoleList().add(role);
		

		try {

			//String fileLocation="/Users/dipanjankarmakar/Documents/Isu Google Drive/Isu Studies Google Drive/4th Sem/661/";
			//File file = new File(fileLocation+"role.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Roles.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			//jaxbMarshaller.marshal(roles, file);
			jaxbMarshaller.marshal(roles, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
