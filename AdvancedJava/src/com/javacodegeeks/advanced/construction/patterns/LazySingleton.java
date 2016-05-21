package com.javacodegeeks.advanced.construction.patterns;

public class LazySingleton {
/**
 * If you do not want to waste your resources and would like your singletons to be lazily created when they are really needed, the explicit synchronization is required, potentially leading to lower concurrency in a multithreaded environments (more details about concurrency in Java will be discussing in part 9 of the tutorial, Concurrency best practices).
 */
	
	private static LazySingleton instance;
	private LazySingleton() {
	}
	
	public static synchronized LazySingleton getInstance(){
		if(instance == null)
			instance = new LazySingleton();
		return instance;
	}
	
	/**
	 * Nowadays, singletons are not considered to be a good choice in most cases, primarily because they are making a code very hard to test. The domination of dependency injection pattern (please see the Dependency Injection section below) also makes singletons unnecessary.
	 */

}
