package com.smd.registar;

import java.io.File;

public class Form {
	static String password;
	   static String address;
	   static String paymentInfo;
	   static boolean confirm;
	   
	   static String getMemberPassword() {
	      return password;
	   }
	   
	   static String getMemberAddress() {
	      return address;
	   }
	   
	   static String getMemberPaymentInfo() {
	      return paymentInfo;
	   }  
	      
	   static boolean getConfirm() {
	      return confirm;
	   }
	   
	   void processFormType() {
	      
	   }
	   
	   void authenticatePassword() {
	      File filename = new File("database.txt");
	      Authenticator a = new Authenticator(filename,password);
	      boolean valid = a.verifyPassword();
	      if(!valid) {
	         System.out.println("Your password is incorrect.");
	      }
	   }
	   
	   void returnResults() {
	   
	   }
}
