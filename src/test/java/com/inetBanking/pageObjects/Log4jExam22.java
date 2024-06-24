package com.inetBanking.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jExam22 {
	
	private static Logger logger=LogManager.getLogger(Log4jExam22.class.getName());

	public static void main(String[] args) {
		
		System.out.println("Hello world");
		
		logger.info("info message....");
		logger.error("error mesage....");
		logger.warn("warn message.....");
		logger.fatal("fatal message....");
		
		System.out.println("completed");
		
		
		
		
		
		

	}

}
