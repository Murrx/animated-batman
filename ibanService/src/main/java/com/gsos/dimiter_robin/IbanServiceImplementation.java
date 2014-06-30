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
	public IbanResponse toIban(@WebParam(name="authentication")Authentication auth,@WebParam(name = "ibanrequest") Ibanrequest request) 
			throws Fault_Exception{
		validateAuthentication(auth);
		final String countryCode = "NL";
		final String bankCode = request.getBankcode().value();
		final BigInteger accountNumber = request.getRekeningnummer();
		System.out.println("New request with bank code " + bankCode + " and bank account number " + accountNumber);
		
		/*
		System.out.println("Value of bank code "+bankCode+": " + valueFromLetters(bankCode));
		System.out.println("Bank account number with leading zeroes: " + addZeroes(accountNumber));
		System.out.println("Value of country code "+countryCode+": " + valueFromLetters(countryCode));
		*/
		
		String ibanCode = valueFromLetters(bankCode) + addZeroes(accountNumber) + valueFromLetters(countryCode) + "00";
		//System.out.println("Numerical iban code: " + ibanCode);
		
		int controleGetal = 98 - (new BigInteger(ibanCode).mod(new BigInteger("97")).intValue());
		//System.out.println("Controlegetal: " + controleGetal);

		
		IbanResponse response = new IbanResponse();
		response.setIban(countryCode + String.format("%02d", controleGetal) + bankCode + addZeroes(accountNumber) );
		System.out.println("--> Generated IBAN: " + response.getIban() + "\n");
		return response;
	}
	
	private String addZeroes (BigInteger nummer) {
		String stringNummer = nummer.toString();
		while (stringNummer.length() < 10) {
			stringNummer = "0" + stringNummer; 
		}
		return stringNummer;
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
		validateAuthentication(auth);
		
		final String iban = request.getIban();
		int controleGetal = 0;
		System.out.println("Validating IBAN " + iban);
		
		if (iban.matches("^NL[0-9]{2}[A-Z]{4}0(00[0-9]{6}[1-9]|[1-9]{2}[0-9]{7})$")) {
			String tempCode = iban.substring(4) + iban.substring(0,4);
				   tempCode = valueFromLetters(tempCode.substring(0,4)) + tempCode.substring(4);
				   tempCode = tempCode.substring(0,18) + valueFromLetters(tempCode.substring(18,20)) + tempCode.substring(20,22);
				   //System.out.println("Temporary code: " + tempCode);
				   
				   controleGetal = new BigInteger(tempCode).mod(new BigInteger("97")).intValue();
				   //System.out.println("Controlegetal: " + controleGetal);
			
		} else {
			throw new Fault_Exception("The supplied iban is not formatted correctly.", null);
		}
		
		ValidationResponse response = new ValidationResponse();
		response.setResult( controleGetal == 1 ? true : false );
		System.out.println("--> IBAN Valid: " + response.isResult() + "\n");
		return response;
	}
	
	private void validateAuthentication(Authentication auth) throws Fault_Exception{
		int postcodeNumbers = Integer.parseInt(auth.getPostcode().substring(0, 4));
		if(postcodeNumbers < 8200 || postcodeNumbers > 8299) throw new Fault_Exception("Postcode not between 8200 and 8299", null);
	}
}
