import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		    for (int i = 1; i <= t; ++i) {
		    	String dgs = in.next();
		    	String result = insertParanths(dgs);
		    	result = balanceParenthesis(result);
		      System.out.println("Case #" + i + ": "+ result );
 		    }
		    
		  }
	  static String balanceParenthesis(String result){
		  int openCount=0;
		  int closeCount=0;
		  for(int i =0;i<result.length();i++){
			  if(result.charAt(i)=='('){
				  openCount++;
			  }
			  else if(result.charAt(i)==')'){
				  closeCount++;
			  }
		  }
		  int diff = openCount - closeCount;
		  for(int j=0;j<diff;j++){
			  result =result+")";
		  }
		  return result;
	  };
	  static String insertParanths(String s){
		  String result="";
		  int currentValue ,prevValue =Character.getNumericValue(s.charAt(0));;
		  for(int i =0;i<s.length();i++){	
			  currentValue = Character.getNumericValue(s.charAt(i));
			  if(i==0){
				  for(int j=0;j<currentValue;j++){
					  
					  result+="(";
					  
				  }
				  result = result+s.charAt(i);
			  }
			  
			  else{
				  
				  if(prevValue<currentValue){
						
					  int diff = currentValue - prevValue;
                      for(int l=0;l<diff;l++){
						  
						  result+="(";
						  
					  }
                      result = result+s.charAt(i);
				  }
				
				  else if(prevValue>currentValue){
						
					  int diff = prevValue - currentValue;
					  for(int r=0;r<diff;r++){
						  
						  result+=")";
						  
					  }
					  result = result+s.charAt(i);
					 
				  }
				  
				  else{
					  result = result+s.charAt(i);
				  }
			  }
			

			  prevValue = currentValue;
			  
		  }
		// 
		  return result;
		  
		  
	  }

	

}
