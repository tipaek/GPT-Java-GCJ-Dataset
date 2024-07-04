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
	          char prev = '0';
	          
	          for(int j=0; j < inputArr.length; j++){
	        	  if(prev == '0' && inputArr[j] == '1'){
	        		  output.append("(").append(inputArr[j]);
	        	  }else if(prev == '1' && inputArr[j] == '0'){
	        		  output.append(")").append(inputArr[j]);
	        	  }else{
	        		  output.append(inputArr[j]);
	        	  }
	        	  prev=inputArr[j];
	          }
	          if(prev == '1')
	        	  output.append(")");
	          System.out.println("Case #" + i + ": " + output.toString());
	       }
	     in.close();
	}
}