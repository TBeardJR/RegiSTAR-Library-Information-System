package com.smd.registar;

public class Item {
	String title;
	String description;
	String author;
	String review;
	double price;
	String genre;
	boolean physical;
	boolean status;

	public Item(String ktitle, String kdescription, String kauthor, String kreview, double kprice, String kgenre,
			boolean kphysical, boolean kstatus) {

		title = ktitle;
		description = kdescription;
		author = kauthor;
		review = kreview;
		price = kprice;
		genre = kgenre;
		physical = kphysical;
		status = kstatus;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isPhysical() {
		return physical;
	}

	public void setPhysical(boolean physical) {
		this.physical = physical;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
}
