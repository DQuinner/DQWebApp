package ie.dq.web.exception;

import java.util.List;

public class UserFormException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private List<String> errorMsgs;
	
	public UserFormException(List<String> errorMsgs) {
		this.errorMsgs = errorMsgs;
	}
	
	public List<String> getErrorMsgs() {
		return errorMsgs;
	}

	public void setErrorMsgs(List<String> errorMsgs) {
		this.errorMsgs = errorMsgs;
	}
	
}
