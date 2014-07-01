package com.gsos.dimiter_robin;

import static org.junit.Assert.*;

import javax.jws.WebParam;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gsos.dimiter_robin.ibanInterface.Authentication;
import com.gsos.dimiter_robin.ibanInterface.Fault_Exception;
import com.gsos.dimiter_robin.ibanInterface.ValidationResponse;
import com.gsos.dimiter_robin.ibanInterface.Validationrequest;

public class ValidateIbanTest {

	private static Authentication validAuth;
	private static IbanServiceImplementation service;
	
	@BeforeClass
	public static void init(){
		service = new IbanServiceImplementation();
		validAuth = new Authentication() ;
		validAuth.setBedrijfsnaam("test");
		validAuth.setHuisnummer("74");
		validAuth.setPostcode("8200AA");
	}
	
	//geldige iban
	@Test
	public void shouldReturnTrue() throws Fault_Exception {
		Validationrequest request = new Validationrequest();
		request.setIban("NL14INGB0008370674");
		
		ValidationResponse response = service.validateIban(validAuth, request);
		Assert.assertTrue(response.isResult());
	}
	
	//ongeldige iban
	@Test
	public void shouldReturnFalse() throws Fault_Exception {
		Validationrequest request = new Validationrequest();
		request.setIban("NL15INGB0008370674");
		
		ValidationResponse response = service.validateIban(validAuth, request);
		Assert.assertFalse(response.isResult());
	}
	
	//iban met spaties
	@Test
	public void shouldNotThrowException() throws Fault_Exception {
		Validationrequest request = new Validationrequest();
		request.setIban("NL 14 INGB 0008 3706 74");
		
		ValidationResponse response = service.validateIban(validAuth, request);
		Assert.assertTrue(response.isResult());
	}
	
	//geen iban
	@Test(expected = Fault_Exception.class)
	public void shouldThrowExceptionBecauseIbanToShort() throws Fault_Exception {
		Validationrequest request = new Validationrequest();
		request.setIban("NL15INGB000837067");
		
		service.validateIban(validAuth, request);
	}

}
