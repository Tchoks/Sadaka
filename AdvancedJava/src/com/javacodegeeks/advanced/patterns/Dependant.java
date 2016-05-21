package com.javacodegeeks.advanced.patterns;

import java.text.DateFormat;
import java.util.Date;

public class Dependant {

	/**
	 * Dependency injection (also known as inversion of control) is considered as a good practice for class designers: if some class instance depends on the other class instances, those dependencies should be provided (injected) to it by means of constructors (or setters, strategies, etc.) but not created by the instance itself. Let us consider the following example:
	 */
	
	private Dependant() {
	}
	
	private final DateFormat format = DateFormat.getDateInstance();
	
	public String format(final Date date){
		return format.format(date);
	}
	
	/**
	 * The class Dependant needs an instance of DateFormat and it just creates one by calling DateFormat.getDateInstance() at construction time. The better design would be to use constructor argument to do the same thing:
	 * 
	 * private final DateFormat format;
	 * 
	 * public Dependant(final DateFormat){
	 *    this.format = format;
	 * }
	 * 
	 * public String format(final Date date){
	 * 		return format.format(date);
	 * }
	 * 
	 */
	
	   
	
	
	

}
