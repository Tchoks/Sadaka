package com.javacodegeeks.advanced.construction.patterns;

public class Book {

	/**
	 * Factory pattern is proven to be extremely useful technique in the hands of software developers. As such, it has several flavors in Java, ranging from factory method to abstract factory. The simplest example of factory pattern is a static method which returns new instance of a particular class (factory method). For example:
	 */
	public Book() {
	}
	
	private String title;
	
	private Book(final String title){
		this.title = title;
	}
	
	public static Book newBook(final String title){
		return new Book(title);
	}
	
	public final String getTitle(){
		return title;
	}

}
