package ie.dq.web.model;

import java.util.List;

public class UserFormErrors {

	private List<String> exceptionMsgs;
	
	public UserFormErrors(List<String> exceptionMsgs){
		this.exceptionMsgs = exceptionMsgs;
	}
	
	public List<String> getExceptionMsgs() {
		return exceptionMsgs;
	}

	public void setExceptionMsgs(List<String> exceptionMsgs) {
		this.exceptionMsgs = exceptionMsgs;
	}
}
