import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
  public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.valueOf(in.readLine().trim()); 
    for (int i = 1; i <= t; i++) {
    	//start of test case
    	String[] input = in.readLine().trim().split("");
    	String output = "";
    	
    	for(int j=0;j<input.length;) {
    		//System.out.println("jout:"+j);
    		
    		//System.out.println(input[j]);
    		if(input[j].equals("0")) {
    		
    			output = output + "0";
    			j++;
    		} else if(j==input.length-1) {
    			output+="(1)"; 
    			j++;
    		} else {
    			for(int k=j+1;k<input.length;k++) {
    				if(input[k].equals("0")) { //stop condition 
    					int num_ones = k-j; //number of ones
    	   				//System.out.println(num_ones);
    					String construct = "(";
        				//construct string
        				for(int l=0;l<num_ones;l++) {
        						construct += "1";
        				}
        				construct += ")";
        				output += construct;
        				//System.out.println("j:"+j);
        				//System.out.println("k:"+k);
        				j=k;
        				k =input.length;
    				}
    			}
    			//System.out.println(output);
    		}
    		
    		//end of each place
    	}
    	System.out.println("Case #"+i+": "+output);
    	//end of test case
    }
  }
    
}
  /*	
    		else if(j==input.length-1) {
    			output = output + "(1)";
    			j++;
    		} else {	
    		
    		
    		
    		if(j==input.length-1) output+="(1)"; 
    		for(int k=j+1;k<input.length;k++) {
    			Boolean stop = false;
    			if(input[k].equals("0")|| k == input.length-1) { //stop condition 
    				int num_ones = k-j; //number of ones
    				if(input[k].equals("1")) num_ones++;
    				String construct = "(";
    				//construct string
    				for(int l=0;l<num_ones;l++) {
    						construct += "1";
    				}
    				construct += ")";
    				output += construct;
    				j = k;
    				stop = true;
    			}
    			if(stop) break;
    			System.out.println(output);
    		}
   */
 
