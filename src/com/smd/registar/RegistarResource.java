package com.smd.registar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/registar")
public class RegistarResource {
	
	@POST
	@Path("/addAccountToDatabase")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addAccountToDatabase(Account account) throws IOException {
		File outputFile = new File ("C:\\Users\\tbeardjr\\workspace\\RegiSTAR\\Account_Database.txt");
	    FileWriter fileWriter = new FileWriter (outputFile, true);
	    PrintWriter printWriter = new PrintWriter (fileWriter);	  
	    account.setBalance(100.0);
		printWriter.println(account.getName() + "," + account.getAddress() + "," + account.getPaymentInfo() + ","
				+ account.getIsMembershipActive() + "," + account.getIsAdministrator() + "," + account.getBalance() + 
				"," + account.getPassword());		
		printWriter.close();		
	}	
	
	@GET
	@Path("/checkDatabaseForAccount/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LoginInformation checkDatabaseForAccount(@QueryParam("name") String name, @QueryParam("password") String password) throws FileNotFoundException {
		String doesAccountExist = new String("false");
		Account account = new Account();
		File inputFile = new File("C:\\Users\\tbeardjr\\workspace\\RegiSTAR\\Account_Database.txt");
		Scanner scanner = new Scanner(inputFile);
		String line = "";
		while(scanner.hasNextLine()) {
			line = scanner.nextLine();
			String[] stringValues = line.split(",");
			if(stringValues[0].equals(name) && stringValues[stringValues.length - 1].equals(password))
			{
				account.setName(name);
				account.setAddress(stringValues[1]);
				account.setPaymentInfo(stringValues[2]);
				account.setIsMembershipActive(Boolean.valueOf(stringValues[3]));
				account.setIsAdministrator(Boolean.valueOf(stringValues[4]));
				account.setBalance(Double.parseDouble(stringValues[5]));
				account.setPassword(stringValues[6]);
				doesAccountExist = "true";
				break;
			}
		}
		scanner.close();
		LoginInformation loginInformation = new LoginInformation();
		loginInformation.setDoesAccountExist(doesAccountExist);
		loginInformation.setAccount(account);
		
		return loginInformation;
	}
	
	@POST
	@Path("/updateAccountInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateAccountInfo(@QueryParam("newName") String newName, @QueryParam("newAddress") String newAddress,
			@QueryParam("newPaymentInfo") String newPaymentInfo, @QueryParam("newPassword") String newPassword,
			@QueryParam("isMembershipActive") boolean isMembershipActive, @QueryParam("isAdministrator") boolean isAdministrator,
			@QueryParam("oldName") String oldName, @QueryParam("moneyToAdd") String moneyToAdd, 
			@QueryParam("oldBalance") String oldBalance) throws IOException {
		File inputFile = new File("C:\\Users\\tbeardjr\\workspace\\RegiSTAR\\Account_Database.txt");
		ArrayList<String> contents = new ArrayList<>();
		Scanner scanner = new Scanner(inputFile);
		String line = "";
		double newBalance = Double.parseDouble(moneyToAdd) + Double.parseDouble(oldBalance);
		while(scanner.hasNextLine()) {
			line = scanner.nextLine();
			String[] stringValues = line.split(",");
			if(stringValues[0].equals(oldName)) {				
				contents.add(newName + "," + newAddress + "," + newPaymentInfo + ","
						+ isMembershipActive + "," + isAdministrator + "," + newBalance + "," + newPassword);
			} else {
				contents.add(line);
			}
		}
		scanner.close();
		
		File outputFile = new File ("C:\\Users\\tbeardjr\\workspace\\RegiSTAR\\Account_Database.txt");
	    FileWriter fileWriter = new FileWriter (outputFile);
	    PrintWriter printWriter = new PrintWriter (fileWriter);	 
	    for(String data : contents) {
	    	printWriter.println(data);
	    }
				
		printWriter.close();	
	}
	
	@POST
	@Path("/deleteAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteAccount(@QueryParam("name") String name, @QueryParam("password") String password) throws IOException {
		File inputFile = new File("C:\\Users\\tbeardjr\\workspace\\RegiSTAR\\Account_Database.txt");
		ArrayList<String> contents = new ArrayList<>();
		Scanner scanner = new Scanner(inputFile);
		String line = "";
		while(scanner.hasNextLine()) {
			line = scanner.nextLine();
			String[] stringValues = line.split(",");
			if(!stringValues[0].equals(name) || !stringValues[stringValues.length - 1].equals(password)) {				
				contents.add(line);
			}
		}
		scanner.close();		
		
		File outputFile = new File ("C:\\Users\\tbeardjr\\workspace\\RegiSTAR\\Account_Database.txt");
	    FileWriter fileWriter = new FileWriter (outputFile);
	    PrintWriter printWriter = new PrintWriter (fileWriter);	 
	    for(String data : contents) {
	    	printWriter.println(data);
	    }
				
		printWriter.close();	
	}
	
	@GET
	@Path("/checkDatabaseForBook")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Book checkDatabaseForBook(@QueryParam("title") String title) throws FileNotFoundException {
		File file = new File("C:\\Users\\tbeardjr\\workspace\\RegiSTAR\\database.txt");
		Search search = new Search(file);
		Book book = search.searchDatabase(title);
		return book;
	}
	
	@GET
	@Path("/reserveBook")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Book reserveBook(@QueryParam("title") String title) throws FileNotFoundException {
		File file = new File("C:\\Users\\tbeardjr\\workspace\\RegiSTAR\\database.txt");
		Search search = new Search(file);
		Book book = search.searchDatabase(title);
		return book;
	}
	
	
	private static class LoginInformation {
		String doesAccountExist;
		private Account account;
		
		public void setDoesAccountExist(String doesAccountExist) {
			this.doesAccountExist = doesAccountExist;
		}
		
		public String getDoesAccountExist()
		{
			return doesAccountExist;
		}

		public Account getAccount() {
			return account;
		}

		public void setAccount(Account account) {
			this.account = account;
		}
	}
}
