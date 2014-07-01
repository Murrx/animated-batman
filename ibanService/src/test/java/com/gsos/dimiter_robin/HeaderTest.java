package com.gsos.dimiter_robin;

import java.math.BigInteger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gsos.dimiter_robin.ibanInterface.Authentication;
import com.gsos.dimiter_robin.ibanInterface.Bankcode;
import com.gsos.dimiter_robin.ibanInterface.Fault_Exception;
import com.gsos.dimiter_robin.ibanInterface.Ibanrequest;

public class HeaderTest 
{   
	private static IbanServiceImplementation service;
	private static Ibanrequest request;
	
	@BeforeClass
	public static void init(){
		service = new IbanServiceImplementation();
		request = new Ibanrequest();
		request.setBankcode(Bankcode.INGB);
		request.setRekeningnummer(new BigInteger("8370674"));
	}
	
	@Test(expected=Fault_Exception.class)
    public void shouldThrowExceptionBecauseInvalidPostCodeToLow() throws Fault_Exception
    {
		Authentication invalidAuth1 = new Authentication() ;
		invalidAuth1.setBedrijfsnaam("test");
		invalidAuth1.setHuisnummer("74");
		invalidAuth1.setPostcode("8199ZZ");
		
		service.toIban(invalidAuth1, request);
    }
    
	@Test(expected=Fault_Exception.class)
    public void shouldThrowExceptionBecauseInvalidPostCodeToHigh() throws Fault_Exception
    {
		Authentication invalidAuth2 = new Authentication() ;
		invalidAuth2.setBedrijfsnaam("test");
		invalidAuth2.setHuisnummer("74");
		invalidAuth2.setPostcode("8300AA");
		
		service.toIban(invalidAuth2, request);
    }
	
	@Test
	public void shouldNotThrowExceptionBecausePostCodeIsValidInLowRange() throws Fault_Exception
    {
		Authentication validAuth1 = new Authentication() ;
		validAuth1.setBedrijfsnaam("test");
		validAuth1.setHuisnummer("74");
		validAuth1.setPostcode("8200AA");
		
		service.toIban(validAuth1, request);
    }
	
	@Test
	public void shouldNotThrowExceptionBecausePostCodeIsValidInUpperRange() throws Fault_Exception
    {
		Authentication validAuth2 = new Authentication() ;
		validAuth2.setBedrijfsnaam("test");
		validAuth2.setHuisnummer("74");
		validAuth2.setPostcode("8299ZZ");
		
		service.toIban(validAuth2, request);
    }
}
