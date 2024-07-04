import java.util.*;
import java.io.*;
import java.lang.Math;

public class Solution {
	public static void main (String[] args) {
    	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int inputLength = Integer.parseInt(in.nextLine());
    	for (int i = 0; i < inputLength; i++) {
    	    String answer = "";
    	    int length = Integer.parseInt(in.nextLine());
    	    String lastStr = in.nextLine();
	        for (int j = 1; j < length; j++) {
	            String currStr = in.nextLine();
	            if (answer.equals("*") == true) {
	                // fail
	            } else if (lastStr.length() < currStr.length()) {
	                String test = "*" + currStr.substring(currStr.length() - lastStr.length() + 1);
	                if (test.equals(lastStr)) {
	                    lastStr = currStr;
	                } else {
	                    answer = "*";
	                }
	            } else if (lastStr.length() > currStr.length()) {
	                String test = "*" + lastStr.substring(lastStr.length() - currStr.length() + 1);
	                if (test.equals(currStr) == false) {
	                    answer = "*";
	                }
	            } else {
	                if (lastStr.equals(currStr) == false) {
	                    answer = "*";
	                }
	            }
	        }
	        if (answer.equals("")) {
	            answer = lastStr.substring(1);
	        }
	        
	        System.out.println("Case #" + (i + 1) + ": " + answer);
		}
	}
}