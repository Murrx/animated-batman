package com.gsos.dimiter_robin;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gsos.dimiter_robin.ibanInterface.Authentication;
import com.gsos.dimiter_robin.ibanInterface.Bankcode;
import com.gsos.dimiter_robin.ibanInterface.Fault_Exception;
import com.gsos.dimiter_robin.ibanInterface.Ibanrequest;

public class ToIbanTest {

	private static IbanServiceImplementation service;
	private static Ibanrequest request;
	private static Authentication auth;
	
	@BeforeClass
	public static void init(){
		service = new IbanServiceImplementation();
		request = new Ibanrequest();
		
		auth = new Authentication() ;
		auth.setBedrijfsnaam("test");
		auth.setHuisnummer("74");
		auth.setPostcode("8200AA");

	}	
	
	//normaal rek nr
	@Test
	public void shouldReturnIban() throws Fault_Exception {
		request.setBankcode(Bankcode.INGB);
		request.setRekeningnummer(new BigInteger("8829939"));
		service.toIban(auth, request);
	}
	
	//ing rek nr
	@Test
	public void shouldAlsoReturnIban() throws Fault_Exception {
		request.setBankcode(Bankcode.ABNA);
		request.setRekeningnummer(new BigInteger("417164300"));
		service.toIban(auth, request);
	}
		
	//8 cijfers
	@Test(expected=Fault_Exception.class)
	public void shouldThrowExceptionBecauseInvalidNumber() throws Fault_Exception {
		request.setBankcode(Bankcode.ABNA);
		request.setRekeningnummer(new BigInteger("41716430"));
		service.toIban(auth, request);
	}
	
	//ongeldige bankcode
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionBecauseInvalidBankCode() throws Fault_Exception {
		request.setBankcode(Bankcode.fromValue("ABCD"));
		request.setRekeningnummer(new BigInteger("417164300"));
		service.toIban(auth, request);
	}
	
	//bankcode kleine letters
	/*@Test
	public void shouldNotThrowExceptionBecauseOfLowerCase() throws Fault_Exception {
		request.setBankcode(Bankcode.fromValue("abna"));
		request.setRekeningnummer(new BigInteger("417164300"));
		service.toIban(auth, request);
	}*/
}

