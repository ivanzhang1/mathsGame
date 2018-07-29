package com.xinling.test.mathsGame;

import org.testng.annotations.BeforeTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterTest;

public class BaseTest {
	 protected Logger logger = LogManager.getLogger(this.getClass());
	 
	 @BeforeTest
	  public void beforeTest(){
		  //prepare the test data here
		 DOMConfigurator.configure("log4j.xml");
		 logger.info("Prepare to Load Test Data!");
	  }

	  @AfterTest
	  public void afterTest() {
		  //quit
		  logger.info("Execution Done, Here we quit test!");
	  }
}
