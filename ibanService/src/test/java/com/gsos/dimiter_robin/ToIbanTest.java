package com.gsos.dimiter_robin;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gsos.dimiter_robin.ibanInterface.Bankcode;
import com.gsos.dimiter_robin.ibanInterface.Ibanrequest;

public class ToIbanTest {

	private static IbanServiceImplementation service;
	private static Ibanrequest request;
	
	@BeforeClass
	public static void init(){
		service = new IbanServiceImplementation();
		request = new Ibanrequest();
		request.setBankcode(Bankcode.INGB);
		request.setRekeningnummer(new BigInteger("8370674"));
	}	
	
	//normaal rek nr
	@Test
	public void shouldReturnIban() {
		fail("Not yet implemented");
	}
	
	//ing rek nr
	@Test
	public void shouldAlsoReturnIban() {
	}
		
	//8 cijfers
	@Test
	public void shouldThrowExceptionBecauseInvallidNumber() {
	}
	
	//ongeldige bankcode
	@Test
	public void shouldThrowExceptionBecauseInvallidBankCode() {
	}
	
	//bankcode kleine letters
	@Test
	public void shouldNotThrowExceptionBecauseOfLowerCase() {
	}
}

