package com.travelsolution.core.signin;

import com.travelsolution.core.main.Framework;

public class SignIn extends Framework{
	private String login = "travelTest";
	private String pass = "TravelTest123";
	
	public static String enterLink = "//a[contains(@class,'enter')]";
	public static String loginInput= "//input[@name='login']";
	public static String passwordInput = "//input[@name='password']";
	public static String enterButton= "//input[contains(@class,'button') and contains(@class,'enter')]";
	public static String userAvaImage= "//span[contains(@class,'ava')]";

	
	public void signIn(){
		System.out.println("Sign in as User with email: " + login+ " and password: " + pass);
		click(enterLink);
		waitForElement(loginInput);
		type(loginInput, login);
		type(passwordInput, pass);
		click(enterButton);
		waitForElement(userAvaImage);
		System.out.println("User is signed in -> OK");
	}
}
