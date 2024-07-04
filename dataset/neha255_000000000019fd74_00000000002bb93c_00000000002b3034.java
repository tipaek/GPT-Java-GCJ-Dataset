/*
 * Copyright (c) 2020 ING Group. All rights reserved.
 * 
 * This software is the confidential and proprietary information of ING Group ("Confidential Information").
 */

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Description goes here.
 */
class Solution {
public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System. in);
        int testcases = scanner.nextInt();
        String [] output = new String[testcases];
       
 
        for (int m = 0; m < testcases; m++) {
  
        int noOfString = scanner.nextInt();
        scanner.nextLine();
        String [] input = new String[noOfString];
        for (int i = 0; i < noOfString; i++) {
        	 String inputString = scanner.nextLine();
        	input[i]=inputString;
        }
        String out = calculateString(input);
        output[m] = out;
        }
        for (int i = 0; i <  testcases; i++) {
        	if(output[i] != null)
			System.out.println("Case #"+(i+1)+": "+output[i]);
        }
        }

        
        
	
    static String calculateString(String[] input) {
    	
    	String str = new String("*");
    	int maxLength = 0;
    	boolean b2 = true;
        String longestString = null;
        for (String s : input) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                longestString = s;
            }
        }
        for (String s : input) {
           if(!longestString.substring(1).contains(s.substring(1))) {
        	   b2=false;
           }
        }
        if(b2) {
        	str =longestString.substring(1);
        }
    	return str;
	
}

}
