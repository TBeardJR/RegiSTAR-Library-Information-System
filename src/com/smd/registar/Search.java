package com.smd.registar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Search {
	private String query;
	private String[] results;
	private boolean found;
	private ArrayList<Book> database = new ArrayList<Book>();
	
	public static void main(String[] args) {
		File file = new File("C:\\Users\\tbeardjr\\workspace\\RegiSTAR\\database.txt");
		Search search = new Search(file);
		Book book = search.searchDatabase("Twilight");
		System.out.println(book.getTitle());
	}

	public Search(File filename) {

		try {
			Scanner scanner = new Scanner(filename);
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] stringValues = line.split(",");				
				Book book = new Book(stringValues[0], stringValues[1], stringValues[2], stringValues[3],
						Double.parseDouble(stringValues[4]), stringValues[5],
						Boolean.parseBoolean(stringValues[6]), Boolean.parseBoolean(stringValues[7]),
						999999999, "Unknown", "CodeXecutors");
				
				database.add(book);
				
			}
			System.out.println(database);
			scanner.close();

		} catch (IOException e) {
			System.out.println("Error reading file.");
			return;
		}

	}

	public String getQuery() {
		return query;
	}

	public Book searchDatabase(String nameOfBook) {
		Book bookToBeReturned = null;
		for(Book book : database) {
			if(book.getTitle().equals(nameOfBook)) {
				query = nameOfBook;
				bookToBeReturned = book;
				break;
			}
		}

		return bookToBeReturned;
	}

	public void displayResults() {

		if ((found == true) && (!query.equals(""))) {
			System.out.println("\nYour item " + query + " has been located in our database.\n");
		} else {
			System.out.println("\nYour item has not been located in our database.\n");
		}
		return;
	}
}
