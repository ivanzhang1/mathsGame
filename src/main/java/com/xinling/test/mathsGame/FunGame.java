package com.xinling.test.mathsGame;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class FunGame 
{
    public static void main( String[] args )
    {
        FunGame funGame= new FunGame();
        ArrayList<String> hundredResult=funGame.gameHundred();
        funGame.listShow(hundredResult);
        
//       System.out.println("\n**************\n"+funGame.fizzBuzz(-90));
    }
    
    //show the result of ArrayList
    public void listShow(ArrayList<String> result){
    	for(String ca: result){
    		System.out.println(ca);
    	}
    }
    
    //Game function to return result within 1~100
    public ArrayList<String> gameHundred(){
    	return gameResult(1,100);
    }
    
    //Game function to return result in (start ~ end)
    public ArrayList<String> gameResult(int start, int end){
    	ArrayList<String> resultList = new ArrayList<String>();
    	
    	//Data scope should be valid
    	if(start>=end){
    		resultList.add("please ensure startNumber should be smaller than endNumber.");
    	}else{
    		//
    		for (int i =start; i<=end; i++)
        	{
        		resultList.add(fizzBuzz(i));
        	}
    	}
    	return resultList;
    }
    
    /*
	 * Here, we still need to confirm with below questions:
	 * 1. In stage 1, FizzBuzz is only displayed when num is multiples of both 3 and 5.
	 *    In stage 2, there is no requirement about the "FizzBuzz".
	 *    Does it mean just follow stage 1? Or we need to set the intersection data of stage 2 to "FizzBuzz"?
	 *    for example, if we just follow the stage 1, number 35 is "Buzz". 
	 *    If consider the intersection data of stage 2, it is Buzz and it is Fizz too. Is it "FizzBuzz"?
	 *    but there is no requirement tell us how handle these data.
	 * 2. Is the data scope still in scope of 1~100?
	 */
    public String fizzBuzz(int num){
    	//define the final result
    	String finalResult = "";
    	int numOriginal=num;
    	num=Math.abs(num);
    	
    	//Determine the number
    	//FizzBuzz number, it has 3 and it has 5, or multiple of both 3 and 5
    	if((involveNumber(num,3) && involveNumber(num,5)) || (0==num%15)){
    		finalResult="FizzBuzz";
    	}else if(involveNumber(num,3) || (0==num%3)){	
    		//Fizz number, it has 3 or multiple of 3
    		finalResult="Fizz";
    		if(involveNumber(num,5) || (0==num%5)){
    			finalResult="FizzBuzz";
    		}
    	}else if (involveNumber(num,5) || (0==num%5)){
        	//Buzz number, it has 5 or multiple of 5
    		finalResult="Buzz";
    		if(involveNumber(num,3) || (0==num%3)){
    			finalResult="FizzBuzz";
    		}
    	}else{
    		//number itself, not in above scenario
    		finalResult=String.valueOf(numOriginal);
    	}

    	return finalResult;
    }
    
    //Determine whether target contains source
    public boolean involveNumber(int target, int source){
    	//use String to do judgment.
    	String strTarget = String.valueOf(target);
    	String strSource = String.valueOf(source);
    	
    	//System.out.println(strTarget+"  "+strSource);
    	return strTarget.contains(strSource);
    }
    
//    //Get every place of a number
//    public ArrayList<String> intChangeToStringArray(int target){
//    	String strTarget = target+"";
//    	String itemOfTarget="";
//    	ArrayList<String> targetArray=new ArrayList<String>();
//    	
//    	for(int i = 1; i<=strTarget.length(); i++){
//    		itemOfTarget = strTarget.substring(i-1, i);
//    		targetArray.add(itemOfTarget);
//    	}
//    	
//    	return targetArray;
//    }
    
}
