package com.gsos.dimiter_robin;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.gsos.dimiter_robin.ibanInterface.IbanResponse;
import com.gsos.dimiter_robin.ibanInterface.IbanServiceInterface;
import com.gsos.dimiter_robin.ibanInterface.Ibanrequest;

@WebService(endpointInterface = "com.gsos.dimiter_robin.ibanInterface.IbanServiceInterface")
public class IbanServiceImplementation implements IbanServiceInterface {
	@WebMethod(operationName = "toIban")
	@Override
	public IbanResponse toIban(@WebParam(name = "ibanrequest") Ibanrequest request) {
		IbanResponse response = new IbanResponse();
		response.setIban("NL48INGB008829939");
		return response;
	}

}
