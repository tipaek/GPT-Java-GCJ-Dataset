import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner scInputReader = new Scanner(System.in);
    	Integer iNoOfTestCases = 0;
    	String sNumber = "", output = "", output1 = "";
    	
    	//Reading No. of Test Cases and Team Size
    	iNoOfTestCases = Integer.parseInt(scInputReader.nextLine().trim());
    	
    	if((iNoOfTestCases < 1) || (iNoOfTestCases > 100)){
    		//Closing the Scanner input stream and exiting the program by throwing an Exception
    		scInputReader.close();
    		throw new Exception("Invalid Test Case Count.");
    	}
    	
    	//Executing for "No of test-cases" times
    	for(Integer iTC = 0; iTC < iNoOfTestCases; iTC++) {
    		//Reading Matrix size
	    	sNumber = scInputReader.nextLine().trim();
	    	
	    	if(Pattern.matches("\\d{1,100}", sNumber) == false) { //if input string does not contain numbers and its <1 and >100 characters
	    		//Closing the Scanner input stream and exiting the program by throwing an Exception
	    		scInputReader.close();
	    		throw new Exception("Invalid number entered. Number should be between 1 and 100");
	    	}
	    	
	    	for(int i = sNumber.length()-1; i >= 0; i--) {
	    		try {
	    			if(i == (sNumber.length()-1)) {								//it is the last number
		    			output = sNumber.substring(i, i+1);
		    			
		    			for(int brk = 1; brk <= Integer.parseInt(sNumber.substring(i, i+1)); brk++) {
		    				output = output + ")";
		    			}
		    		}
	    			
	    			if(sNumber.substring(i, i+1).equals(sNumber.substring(i+1, i+2))) {  	//if current numbers is equal to the previous number
		    			output = sNumber.substring(i, i+1) + output;
		    		}
		    		else if(Integer.parseInt(sNumber.substring(i, i+1)) > Integer.parseInt(sNumber.substring(i+1, i+2))) { 	//if current number is greater than previous number
		    			int iLoopEnd = Integer.parseInt(sNumber.substring(i, i+1)) - Integer.parseInt(sNumber.substring(i+1, i+2));
		    			
		    			for(int brk = 1; brk <= iLoopEnd; brk++) {
		    				output = ")" + output;
		    			}
		    			
		    			output = sNumber.substring(i, i+1) + output;
		    		}
		    		else if(Integer.parseInt(sNumber.substring(i, i+1)) < Integer.parseInt(sNumber.substring(i+1, i+2))) {	//if current number is greater than previous number
		    			int iLoopEnd = Integer.parseInt(sNumber.substring(i+1, i+2)) - Integer.parseInt(sNumber.substring(i, i+1));
		    			
		    			for(int brk = 1; brk <= iLoopEnd; brk++) {
		    				output = "(" + output;
		    			}
		    			
		    			output = sNumber.substring(i, i+1) + output;
		    		}
	    		}
	    		catch(Exception e) {
	    			//for catching and ignoring a possible out of index exception.
	    		}
	    		
	    		try {
	    			if(i == 0) {		//if it is the 1st number
		    			for(int brk = 1; brk <= Integer.parseInt(sNumber.substring(i, i+1)); brk++) {
		    				output = "(" + output;
		    			}
		    		}
	    		}
	    		catch(Exception e) {
	    			//for catching and ignoring a possible out of index exception.
	    		}
	    	}
	    	
	    	
	    	output1 = output1 + "Case #" + (iTC+1) + ": " + output.trim() + "\n";
    	}
    	
    	System.out.print(output1);
    	scInputReader.close();
	}
}