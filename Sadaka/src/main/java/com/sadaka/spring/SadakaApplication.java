package com.sadaka.spring;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.jboss.jandex.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SadakaApplication {   
		
	public static void main(String[] args) {
	   Logger logger = Logger.getLogger(Main.class.getName());
	 ApplicationContext ctx = SpringApplication.run(SadakaApplication.class, args);
	 String[] beanNames = ctx.getBeanDefinitionNames();
	 Arrays.sort(beanNames);
	 Arrays.asList(beanNames).forEach(logger::info);
	}
}
