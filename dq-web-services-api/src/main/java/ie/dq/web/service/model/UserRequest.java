package ie.dq.web.service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="UserRequest", propOrder = {"allUsers", "username", "email", "firstname","lastname"})
@XmlAccessorType(XmlAccessType.FIELD)
public class UserRequest {
	
	@XmlElement
	private boolean allUsers;
	@XmlElement
	private String username;
	@XmlElement
	private String email;
	@XmlElement
	private String firstname;
	@XmlElement
	private String lastname;
	
	public boolean isAllUsers() {
		return allUsers;
	}
	public void setAllUsers(boolean allUsers) {
		this.allUsers = allUsers;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
