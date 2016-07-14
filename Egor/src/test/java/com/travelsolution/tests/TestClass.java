package com.travelsolution.tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.travelsolution.core.email.Email;
import com.travelsolution.core.main.Framework;
import com.travelsolution.core.signin.SignIn;

public class TestClass {
	
	public Framework framework;
	public Email email;
	public SignIn signIn;
	
	@BeforeClass(description="init Browser")
	@Parameters({"url"})
	public void initBrowser(String url){
		framework=new Framework();
		framework.initBrowser();
		email=new Email();
		signIn=new SignIn();
	}
	

	@Test
	@Parameters({"url"})
	public void testMethod(String url){
		framework.open(url);
		signIn.signIn();
		email.open();
		System.out.println("Emails count = " + email.getNumberOfMails());
		Assert.assertTrue(email.getNumberOfMails().equals("1"), "FAILED");
		System.out.println("Passed");
		
	}
	
	@AfterClass
	public void killDriver(){
		framework.killDriver();
	}
	
	
	
}
