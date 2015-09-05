package ie.dq.web.service.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import ie.dq.web.common.model.UserUI;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDetailsResponse {

	private UserUI userUI;
	private String status;
	private String errorMsg;
	
	public UserUI getUserUI() {
		return userUI;
	}

	public void setUserUI(UserUI userUI) {
		this.userUI = userUI;
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
