package com.gsos.dimiter_robin;

import java.math.BigInteger;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.gsos.dimiter_robin.ibanInterface.Authentication;
import com.gsos.dimiter_robin.ibanInterface.Fault;
import com.gsos.dimiter_robin.ibanInterface.Fault_Exception;
import com.gsos.dimiter_robin.ibanInterface.IbanResponse;
import com.gsos.dimiter_robin.ibanInterface.IbanServiceInterface;
import com.gsos.dimiter_robin.ibanInterface.Ibanrequest;
import com.gsos.dimiter_robin.ibanInterface.ValidationResponse;
import com.gsos.dimiter_robin.ibanInterface.Validationrequest;

@WebService(endpointInterface = "com.gsos.dimiter_robin.ibanInterface.IbanServiceInterface")
public class IbanServiceImplementation implements IbanServiceInterface {
	@WebMethod(operationName = "toIban")
	@Override
	public IbanResponse toIban(@WebParam(name="authentication")Authentication auth,@WebParam(name = "ibanrequest") Ibanrequest request) {
		String bankcode = request.getBankcode().value();
		BigInteger rekeningnummer = request.getRekeningnummer();
		System.out.println("New request with bankcode "+bankcode+" and number "+rekeningnummer);
		
		String partialCode = valueFromLetters(bankcode) + addZeroes(rekeningnummer) + valueFromLetters("NL");
		
		IbanResponse response = new IbanResponse();
		response.setIban("NL48INGB008829939");
		return response;
	}
	
	private String addZeroes (BigInteger nummer) {
		String stringNummer = nummer.toString();
		while (stringNummer.length() < 10) {
			stringNummer = "0" + stringNummer; 
		}
		return new String();
	}
	
	private String valueFromLetters (String letters) {
		String value = "";
		for (Character letter : letters.toCharArray()) {
			value += Integer.toString(letter - 'A' + 10);
		}
		return value;
		
	}

	@WebMethod(operationName = "validateIban")
	@Override
	public ValidationResponse validateIban(@WebParam(name="authentication")Authentication auth,@WebParam(name = "validationrequest") Validationrequest request)
			throws Fault_Exception {
		ValidationResponse response = new ValidationResponse();
		response.setResult(true);
		return response;
	}
}
