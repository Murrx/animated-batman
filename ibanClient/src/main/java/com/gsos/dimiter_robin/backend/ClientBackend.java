package com.gsos.dimiter_robin.backend;

import java.math.BigInteger;

import com.gsos.dimiter_robin.ibanInterface.Authentication;
import com.gsos.dimiter_robin.ibanInterface.Bankcode;
import com.gsos.dimiter_robin.ibanInterface.Fault_Exception;
import com.gsos.dimiter_robin.ibanInterface.IbanService;
import com.gsos.dimiter_robin.ibanInterface.IbanServiceInterface;
import com.gsos.dimiter_robin.ibanInterface.Ibanrequest;
import com.gsos.dimiter_robin.ibanInterface.Validationrequest;

public class ClientBackend {
	
		private static IbanServiceInterface serviceInterface;
		private static Authentication auth;
		
		public ClientBackend() {
			serviceInterface = new IbanService().getWSPort();
			auth = new Authentication();
			setAuth("test", "0000AA", "1");
		}
		
		
		public static void setAuth (String name, String postalCode, String number) {
			auth.setBedrijfsnaam(name);
			auth.setPostcode(postalCode);
			auth.setHuisnummer(number);
		}
		
		public static String toIban (String bankcode, String accountNumber) throws Fault_Exception {
			Ibanrequest ibanRequest = new Ibanrequest();
			ibanRequest.setBankcode(Bankcode.valueOf(bankcode.toUpperCase()));
			ibanRequest.setRekeningnummer(new BigInteger(accountNumber));
			return serviceInterface.toIban(auth, ibanRequest).getIban();
		}
		
		public static boolean validateIban (String iban) throws Fault_Exception {
			Validationrequest validationRequest = new Validationrequest();
			validationRequest.setIban(iban);
			return serviceInterface.validateIban(auth, validationRequest).isResult();
		}
		
		
	
}
