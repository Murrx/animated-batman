package com.gsos.dimiter_robin;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
 
public class IbanServiceImplementation 
{	
	@WebService(endpointInterface = "com.gsos.dimiter_robin.ibanInterface")
	@SOAPBinding(style = SOAPBinding.Style.RPC)
	public class HelloWebService {
	    @WebMethod(operationName = "sayHello")
	    public String sayHello(@WebParam(name="guestname") String guestname){
	        if(guestname==null){
	            return "Hello";
	        }
	        return "Hello "+ guestname;
	    }
	}
}
