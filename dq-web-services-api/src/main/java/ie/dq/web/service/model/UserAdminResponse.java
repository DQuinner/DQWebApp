package ie.dq.web.service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import ie.dq.web.common.model.UserUI;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAdminResponse {

	private UserUI user;
	private String status;
	private String message;
	
	public UserUI getUser() {
		return user;
	}
	public void setUser(UserUI user) {
		this.user = user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
