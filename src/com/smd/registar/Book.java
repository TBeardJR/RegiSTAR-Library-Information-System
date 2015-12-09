package com.smd.registar;

public class Book extends Item {
	int ISBN;
	String publicationDate;
	String publisher;

	public Book(String title, String description, String author, String review, double price, String genre,
			boolean physical, boolean status, int kISBN, String kpubDate, String kpublisher) {

		super(title, description, author, review, price, genre, physical, status);
		ISBN = kISBN;
		publicationDate = kpubDate;
		publisher = kpublisher;

	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	
}
