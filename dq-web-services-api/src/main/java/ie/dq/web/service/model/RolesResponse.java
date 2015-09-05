package ie.dq.web.service.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="UserRequest", propOrder = {"numRoles", "userRoles"})
@XmlAccessorType(XmlAccessType.FIELD)
public class RolesResponse {

	private int numRoles;
	@XmlElement(name="role")
	private List<String> userRoles;
	
	public int getNumRoles() {
		return numRoles;
	}
	public void setNumRoles(int numRoles) {
		this.numRoles = numRoles;
	}
	public List<String> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<String> userRoles) {
		this.userRoles = userRoles;
	}
}
