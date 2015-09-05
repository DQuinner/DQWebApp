/**
 * 
 */
package ie.dq.web.common.model;

import java.io.Serializable;

/**
 * @author Donal
 *
 * System user information
 */
public class UserUI implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String email;
	private String forename;
	private String surname;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
}
