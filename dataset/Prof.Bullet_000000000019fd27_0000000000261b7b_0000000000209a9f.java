import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	        int numOfCases = Integer.valueOf(in.next());
	        for (int caseNum = 0; caseNum < numOfCases; caseNum++) {
	        	String result = "";
	            String row = in.next();
	        	int[] arr = new int[row.length()];
	        	int[] diffArr = new int[row.length()+1];
        		for (int i = 0; i < row.length(); i++) {
        			arr[i] = Character.digit(row.charAt(i), 10);
        		}
        		diffArr[0] = arr[0];
        		for (int i = 1; i < arr.length; i++) {
        			diffArr[i] = -(arr[i-1] - arr[i]);
        		}
        		diffArr[diffArr.length-1] = -arr[arr.length-1];
            	for (int i = 0; i < diffArr.length; i++) {
            		if (diffArr[i] > 0){
                		for (int r = diffArr[i]; r > 0; r--) {
                			result += '(';
                		}
            		}
            		if (diffArr[i] < 0){
                  		for (int r = -diffArr[i]; r > 0; r--) {
                			result += ')';
                		}
            		}
            		if (i != arr.length) {
                		result += arr[i];
            		}
            	}
            	if (caseNum != numOfCases - 1) {
            	   System.out.println(result);
            	}else {
            	   System.out.print(result);
            	}
	        }
	}
}
