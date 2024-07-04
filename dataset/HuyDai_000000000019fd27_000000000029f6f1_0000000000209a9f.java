
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
  public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.valueOf(in.readLine().trim()); 
    for (int i = 1; i <= t; i++) {
    	//start of test case
    	String[] input = in.readLine().trim().split("");
    	String output = "";
    	
    	for(int j=0;j<input.length;) {
    		if(input[j].equals("0")) {
    			output = output + "0";
    			j++;
    		}
    		else if(j==input.length-1) {
    			output = output + "(1)";
    			j++;
    		} else {
    		for(int k=j+1;k<input.length;k++) {
    			if(input[k].equals("0")) { //stop condition 
    				int num_ones = k-j; //number of ones
    				String construct = "(";
    				//construct string
    				for(int l=0;l<num_ones;l++) {
    						construct += "1";
    				}
    				construct += ")";
    				output += construct;
    				j = k;
    				break;
    			}
    		}
    		}
    		//end of each place
    	}
    	System.out.println("Case #"+i+": "+output);
    	//end of test case
    }
  }
    
}
  
 
