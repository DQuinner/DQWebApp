package ie.dq.web.service;

import ie.dq.web.service.model.RolesResponse;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name="securityService")
@SOAPBinding(style=Style.RPC, use=Use.LITERAL)
public interface DQSecurityService {
	
	@WebMethod(operationName="getUserPassword")
	@RequestWrapper(targetNamespace="http://web.dq.ie/types", className="java.lang.String")
	@ResponseWrapper(targetNamespace="http://web.dq.ie/types", className="java.lang.String")
	@WebResult(targetNamespace="http://web.dq.ie/types", name="userPassword")
	public String getUserPassword(@WebParam(targetNamespace="http://web.dq.ie/types", name="username") String username);
	
	@WebMethod(operationName="getUserAuthorities")
	@RequestWrapper(targetNamespace="http://web.dq.ie/types", className="java.lang.String")
	@ResponseWrapper(targetNamespace="http://web.dq.ie/types", className="ie.dq.web.service.model.RolesResponse")
	@WebResult(targetNamespace="http://web.dq.ie/types", name="userRoles")
	public RolesResponse getUserAuthorities(@WebParam(targetNamespace="http://web.dq.ie/types", name="username") String username);
	
}
