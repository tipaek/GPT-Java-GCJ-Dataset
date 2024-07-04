package com.code;

import java.io.*;
import java.util.Scanner;

public class Solution {
    
	public static void main(String[] args) {
		Scanner std = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = std.nextInt();
	    for (int caseNumber = 1; caseNumber <=t; caseNumber++){
	        String str = std.next();
	        StringBuilder result = new StringBuilder(str);
	     
	        int offset = 0;
	        for (int i =0;i<str.length()-1;i++){
	            int a=0, b=0, c=0;
	            a = Integer.parseInt(String.valueOf(result.charAt(offset+i)));
	            b = Integer.parseInt(String.valueOf(result.charAt(offset+i+1)));
	            
	            c=a-b;
	            if(c>0){
	                for(int j =0;j<c;j++){
	                    result.insert(offset+i+1,")");
	                    offset++;
	                }
	            }
	            else if(c<0){
	                for(int j =0;j<(c*-1);j++){
	                    result.insert(offset+i+1,"(");
	                    offset++;
	                }
	            }
	        }
	        
	        int size = result.length();
	        for (int j=0;j<Integer.parseInt(String.valueOf(result.charAt(size-1)));j++){
	           result.insert(size,")");
	        }
	        int start=Integer.parseInt(String.valueOf(result.charAt(0)));
	        for (int j=0;j<start;j++){
	           result.insert(0,"(");
	        }
	        
	     System.out.println("Case #" + caseNumber + ": " +result);   
	    }
	}
}