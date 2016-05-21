package com.javacodegeeks.advanced.main;

import com.javacodegeeks.advanced.construction.ConstructorWithArguments;

public class Main {

	Main(){
		//private constructor 
	}

	public static void main(String[] args) {
		final ConstructorWithArguments constructor 
		= new ConstructorWithArguments("arg1","arg2");
		
		System.out.println("arg1: "+constructor.getArg1());
		System.out.println("arg2: "+constructor.getArg2());

		
		
		
	}

}
