package com.javacodegeeks.advanced.construction.patterns;

public class EagerSingleton {

	/**
	 * At least one problem with NaiveSingleton class is that it may create many instances of the class if called concurrently by multiple threads. One of the ways to design singleton properly (but in non-lazy fashion) is using the static final property of the class.

	 */
	private static final EagerSingleton instance = new EagerSingleton();
	
	private EagerSingleton() {
		//
	}
	
	public static EagerSingleton getInstance(){
		return instance;
	}

}
