package ie.dq.web.service;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Use;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import ie.dq.web.service.model.UserAdminRequest;
import ie.dq.web.service.model.UserAdminResponse;
import ie.dq.web.service.model.UserRequest;
import ie.dq.web.service.model.UserDetailsResponse;
import ie.dq.web.service.model.UsersResponse;

@WebService(name="userService")
@SOAPBinding(style=Style.RPC, use=Use.LITERAL)
public interface DQUserService {
	
	@WebMethod(operationName="getUserDetails")
	@RequestWrapper(targetNamespace="http://web.dq.ie/types", className="java.lang.String")
	@ResponseWrapper(targetNamespace="http://web.dq.ie/types", className="ie.dq.web.service.model.UserDetailsResponse")
	@WebResult(targetNamespace="http://web.dq.ie/types", name="userDetails")
	public UserDetailsResponse getUserDetails(@WebParam(targetNamespace="http://web.dq.ie/types", name="username") 
		String username);
	
	@WebMethod(operationName="getUsers")
	@RequestWrapper(targetNamespace="http://web.dq.ie/types", className="ie.dq.web.service.model.UserRequest")
	@ResponseWrapper(targetNamespace="http://web.dq.ie/types", className="ie.dq.web.service.model.UsersResponse")
	@WebResult(targetNamespace="http://web.dq.ie/types", name="users")
	public UsersResponse getUsers(@WebParam(targetNamespace="http://web.dq.ie/types", name="usersRequest") 
		UserRequest userRequest);
	
	@WebMethod(operationName="addUser")
	@RequestWrapper(targetNamespace="http://web.dq.ie/types", className="ie.dq.web.service.model.UserAdminRequest")
	@ResponseWrapper(targetNamespace="http://web.dq.ie/types", className="ie.dq.web.service.model.UserAdminResponse")
	@WebResult(targetNamespace="http://web.dq.ie/types", name="userAdminResponse")
	public UserAdminResponse addUser(@WebParam(targetNamespace="http://web.dq.ie/types", name="addUserRequest") 
		UserAdminRequest userAdminRequest);
	
}