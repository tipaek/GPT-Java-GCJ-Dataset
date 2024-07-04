import java.io.*;
import java.util.Scanner;

public class Solution {
    
	public static void main(String[] args) {
		String number;
		Scanner std = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = std.nextInt();
	    for (int caseNumber = 1; caseNumber <=t; caseNumber++){
	        	    String str = std.next();
		StringBuilder result = new StringBuilder(str);
	     
	    for (int i =0,j=0 ; i<str.length(); i++){
	        if(Integer.parseInt(String.valueOf(result.charAt(i+j)))==1){
	            
	            result.insert(i+j,"(");
	            j++;
	            for (int k=i+j+1;k<str.length()+j;k++){
	                if(Integer.parseInt(String.valueOf(result.charAt(k)))==0){
	                    result.insert(k,")");
	                    j++;
	                    
	                    break;
	                }
	                if(k==str.length()+j-1){
	                        i=str.length();
	                    }
	                    i++;
	            }
	        }
	    }
	    if(Integer.parseInt(String.valueOf(result.charAt(result.length()-1)))==1){
	        result.insert(result.length(),")");
	        } 
	     System.out.println("Case #" + caseNumber + ": " + result);   
	    }
	}
}