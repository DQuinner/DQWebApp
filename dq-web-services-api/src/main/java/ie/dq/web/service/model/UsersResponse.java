package ie.dq.web.service.model;

import ie.dq.web.common.model.UserUI;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersResponse {
	
	@XmlElement(name="user")
	private List<UserUI> users;
	private int usersCount;
	private String status;
	private String errorMsg;
	
	public List<UserUI> getUsers() {
		return users;
	}
	public void setUsers(List<UserUI> users) {
		this.users = users;
	}
	public int getUsersCount() {
		return usersCount;
	}
	public void setUsersCount(int usersCount) {
		this.usersCount = usersCount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
