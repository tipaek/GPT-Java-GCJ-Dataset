import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	public static void main(String args[]){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	     int t = in.nextInt(); 
	     for (int i = 1; i <= t; ++i) {
	          String input = in.next();
	          StringBuilder output = new StringBuilder();
	          char[] inputArr = input.toCharArray();
	          int currentOpen = 0;
	          for(int j=0; j < inputArr.length; j++){
	        	  int digit = Character.getNumericValue(inputArr[j]);
	        	  addCharcters(output, digit-currentOpen, '(');
	        	  currentOpen = digit;
	        	  output.append(digit);
	        	  
	        	  if(j < inputArr.length -1){
	        		  int nextDigit = Character.getNumericValue(inputArr[j+1]);
	        		  addCharcters(output, currentOpen - nextDigit, ')');
	        	  }else{
	        		  addCharcters(output, digit, ')');
	        	  }
	          }
	         
	          System.out.println("Case #" + i + ": " + output.toString());
	       }
	     in.close();
	}
	
	static void addCharcters(StringBuilder sb,int times,char k){
		while(0 < times--){
			sb.append(k);
		}
	}
}