package com.inetBanking.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jExam {
	
	static final Logger logger=LogManager.getLogger(Log4jExam.class.getName());

	public static void main(String[] args) {
		
		System.out.println("Hello world");
		
		logger.info("info message....");
		logger.error("error mesage....");
		logger.warn("warn message.....");
		logger.fatal("fatal message....");
		logger.info("info message....");
		logger.error("error mesage....");
		logger.warn("warn message.....");
		logger.fatal("fatal message....");
		logger.info("info message....");
		logger.error("error mesage....");
		logger.warn("warn message.....");
		logger.fatal("fatal message....");
		
		System.out.println("completed");
		
		
		
		
		
		

	}

}
