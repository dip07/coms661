/**
 * 
 */
package com.models;

/**
 * @author dipanjankarmakar
 *
 */
public class LoginForm {
	
	private String netId;
	private String password;
	public String getNetId() {
		return netId;
	}
	public void setNetId(String netId) {
		this.netId = netId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginForm [netId=" + netId + ", password=" + password + "]";
	}

}
