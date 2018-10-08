package com.xinling.test.mathsGame;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.xinling.test.lib.POIExcel;
import com.xinling.test.lib.commonFunc;

import java.util.ArrayList;
import java.util.List;

public class FunGameTest extends BaseTest{
	
	private FunGame funGameTest = new FunGame(); 
	private List<POIExcel> list= new ArrayList<POIExcel>();
	private commonFunc pwe = new commonFunc();	
	
  /* 
   * 1. verify output data correction with 1-100 data 
   */
  @Test
  public void funGame_FizzBuzz_InScope(){
	  logger.info("Inscope(1~100) test data verification!");
	  //Get expected result list
	  list = pwe.read();
	  //Get real result list
	  ArrayList<String> realResultList= funGameTest.gameHundred();
	  
	  //compare 
	  logger.info("Compare the result list --- Start:");
	  for(int i=0; i<realResultList.size(); i++){
		  String realResult=realResultList.get(i);
		  //Get Expected Result 
		  String expectedResult=list.get(i).getResult();
		  
		  logger.info("The "+(i+1)+" line comparison: "+expectedResult.equals(realResult));
		  Assert.assertEquals(realResult, expectedResult,"Real result is not same with expected result!");
	  }
	  logger.info("Compare the result list --- End!");
	  logger.info("verification done!\t Passed!");
  }
  
  /*
   * 2. verify output msg correction with reversed data scope.
   */
  @Test
  public void funGame_FizzBuzz_StartEndReverse(){
	  logger.info("Reverse Scope of start ~ end data verfication!");
	  ArrayList<String> realResultList= new ArrayList<String>();
	  realResultList = funGameTest.gameResult("100","1");
	  String expectedResult = "please ensure startNumber should be smaller than endNumber.";
	  
	  Assert.assertEquals(realResultList.get(0), expectedResult,"Real result is not same with expected result!");  
	  logger.info("verification done!\t Passed!");
  }
  
  /*
   * 3. verify output msg correction with invalid data scope.
   */
  @Test
  public void funGame_FizzBuzz_StartEndScopeNull(){
	  logger.info("Null Scope of start ~ end data verfication!");
	  ArrayList<String> realResultList= new ArrayList<String>();
	  realResultList = funGameTest.gameResult("1","1");
	  String expectedResult = "please ensure startNumber should be smaller than endNumber.";
	  
	  Assert.assertEquals(realResultList.get(0), expectedResult,"Real result is not same with expected result!");  
	  logger.info("verification done!\t Passed!");
  }
  
  /*
   * 4. verify output msg correction with special char.
   */
  @Test(enabled=true)
  public void funGame_FizzBuzz_SpecialCharacter(){
	  logger.info("Special character data verification!");
	  ArrayList<String> realResultList= new ArrayList<String>();
	  realResultList = funGameTest.gameResult("a","c");
	  String expectedResult = "please ensure your input is valid.";
	  
	  Assert.assertEquals(realResultList.get(0), expectedResult,"Real result is not same with expected result!");
	  logger.info("verification done!\t Passed!");
  }
  

}
