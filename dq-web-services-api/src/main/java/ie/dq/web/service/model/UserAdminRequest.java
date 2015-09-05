package ie.dq.web.service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import ie.dq.web.common.model.UserUI;

@XmlAccessorType(XmlAccessType.FIELD)
public class UserAdminRequest {
	
	@XmlElement(required=true)
	private UserUI user;
	
	public UserUI getUser() {
		return user;
	}
	public void setUser(UserUI user) {
		this.user = user;
	}
}
