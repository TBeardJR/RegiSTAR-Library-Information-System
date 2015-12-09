package com.smd.registar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Authenticator extends Form {
	private boolean isVerified = false;
	   private String password;
	   private Authenticator uniqueInstance;
	   private ArrayList<ArrayList<String>> Database = new ArrayList<ArrayList<String>>();

	   public Authenticator(File filename, String kpassword){
	      password = kpassword;
	      
	      try{
	      
	         Scanner s = new Scanner(filename);
	        
	         String item = null;
	         ArrayList<String> inventory = new ArrayList<String>();
	         StringBuilder sb = new StringBuilder();
	         
	         while(s.hasNextLine()){
	            String line = s.nextLine();
	            for(int i = 0; i < line.length(); i++){
	               char a = line.charAt(i);
	               if(a != ','){
	                  sb.append(a);
	               }
	               if(a == ','){
	                  item = sb.toString();
	                  inventory.add(item);
	                  sb = new StringBuilder();
	               }
	            }
	            item = sb.toString();
	            inventory.add(item);
	            sb = new StringBuilder();
	            if(inventory.size() == 11) {  
	               Book b = new Book(inventory.get(0),inventory.get(1),inventory.get(2),
	                  inventory.get(3),Double.parseDouble(inventory.get(4)),inventory.get(5),Boolean.parseBoolean(inventory.get(6)),
	                  Boolean.parseBoolean(inventory.get(7)),Integer.parseInt(inventory.get(8)),inventory.get(9),
	                  inventory.get(10));
	               System.out.println(b.review);
	            }
	            //System.out.println("\nJust added to the database: " + inventory + "\n");
	            Database.add(inventory); 
	            inventory = new ArrayList<String>();        
	         }
	        
	           
	      }
	      catch(IOException e){
	         System.out.println("Error reading file.");
	         return;
	      }  
	      
	   
	   }

	   public boolean verifyPassword(){
	   
	      password = Form.getMemberPassword();
	   
	      if(Database.contains(password)){
	         isVerified = true;
	         return isVerified;
	      }
	      else{
	         return isVerified;
	      }
	   }
	       
	   public Authenticator instance(){
	           
	      return this;
	   }
}
