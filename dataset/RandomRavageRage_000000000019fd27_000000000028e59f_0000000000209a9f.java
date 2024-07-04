import java.util.*;
import java.io.*;
public class Solution {
	public static BufferedReader br;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t; i++){
        	//each case
        	testCase(i);
        }
        br.close();
    }
    
    public static void testCase(int x) throws NumberFormatException, IOException{
    	String s = br.readLine();
    	int[] integers = new int[s.length()];
    	int max = 0;
    	for(int i = 0; i < s.length(); i++){
    		integers[i] = Integer.parseInt(s.substring(i, i + 1));
    		max = Math.max(max, integers[i]);
    	}
    	
    	//initialize parentheses array
    	String[] parentheses = new String[s.length() + 1];
    	for(int i = 0; i < s.length() + 1; i++){
    		parentheses[i] = "";
    	}
    	
    	for(int j = 1; j <= max; j++){
    		for(int i = 0; i < integers.length; i++){
        		if(integers[i] >= j){
        			if(i == 0 || integers[i - 1] < j){
        				parentheses[i] = parentheses[i] + "(";
        			}
        			if(i == integers.length - 1 || integers[i + 1] < j){
        				parentheses[i + 1] = ")" + parentheses[i + 1]; 
        			}
        		}
        	}
    	}
    	
    	//build final string
    	String ret = "";
    	for(int i = 0; i < integers.length; i++){
    		ret += parentheses[i] + integers[i];
    	}
    	ret += parentheses[s.length()];
        
        System.out.println("Case #" + x + ": " + ret);
    }
}