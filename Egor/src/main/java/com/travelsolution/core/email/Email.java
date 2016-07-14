package com.travelsolution.core.email;

import com.travelsolution.core.main.Framework;
import com.travelsolution.core.signin.SignIn;

public class Email extends Framework{

	public static String emailLink = "//a[contains(@href,'mail')]";
	public static String mailsCount = "//div[contains(@class,'inbox')]/span[contains(@class,'info')]";
	
	public void open(){
		System.out.println("Open email");
		click(SignIn.userAvaImage);
		waitForElement(emailLink);
		click(emailLink);
		waitForElement(mailsCount);
		System.out.println("Email page opened -> OK");
	}
	
	public String getNumberOfMails(){
		if(getText(mailsCount).equals("")){
			return "0";
		}
		return getText(mailsCount); 
	}
}
