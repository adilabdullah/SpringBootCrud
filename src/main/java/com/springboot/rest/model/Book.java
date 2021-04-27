package com.springboot.rest.model;

public class Book {
int id;
String author,title;
double price;


@Override
public String toString() {
	return "Book [id=" + id + ", author=" + author + ", title=" + title + ", price=" + price + "]";
}
public Book(int id, String author, String title, double price) {
	super();
	this.id = id;
	this.author = author;
	this.title = title;
	this.price = price;
}
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

}
