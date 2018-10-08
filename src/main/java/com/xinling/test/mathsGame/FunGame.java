package com.xinling.test.mathsGame;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class FunGame 
{
	protected Logger logger = LogManager.getLogger(this.getClass());
	
    public static void main( String[] args )
    {
        FunGame funGame= new FunGame();
        ArrayList<String> hundredResult=funGame.gameHundred();
        funGame.listShow(hundredResult);
        if(isInteger("1a")){
        	 System.out.println("hahahaha");
    	}
        
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
    	return gameResult("1","100");
    }
    
    
    
    //Game function to return result in (start ~ end)
    public ArrayList<String> gameResult(String start, String end){
    	logger.info("Start is "+start+", end is "+end+".");
    	ArrayList<String> resultList = new ArrayList<String>();
    	int begin, ended;
    	if(!isInteger(start) || !isInteger(end)){
    		resultList.add("please ensure your input is valid.");
    		return resultList;
    	}else{
    		begin= Integer.parseInt(start);
    		ended= Integer.parseInt(end);
    	}
    	
    	//Data scope should be valid
    	if(Integer.parseInt(start) >= Integer.parseInt(end)){
    		resultList.add("please ensure startNumber should be smaller than endNumber.");
    	}else{
    		//
    		for (int i =begin; i<=ended; i++)
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
    
    /* 
     * 判断是否为整数  
     * @param str 传入的字符串  
     * @return 是整数返回true,否则返回false  
   */  
    public static boolean isInteger(String str) {    
       Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");    
       return pattern.matcher(str).matches();    
     }  
    
}
