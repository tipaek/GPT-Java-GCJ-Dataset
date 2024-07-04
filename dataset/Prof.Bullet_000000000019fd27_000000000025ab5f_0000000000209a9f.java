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
        		for (int i = 0; i < row.length(); i++) {
        			arr[i] = Character.digit(row.charAt(i), 10);
        		}
        		Arrays.sort(arr);
        		reverse(arr);
            	for (int i = 0; i < arr.length; i++) {
        			if (i == 0 || arr[i] != arr[i-1]) {
                		for (int r = arr[i]; r > 0; r--) {
                			result += '(';
                		}
        			}
        			if (arr[i] != 0) {
                		result += arr[i];
        			}
            	}
            	for (int i = 0; i < arr.length; i++) {
        			if (i == 0 || arr[i] != arr[i-1]) {
                		for (int r = arr[i]; r > 0; r--) {
                			result += ')';
                		}
        			}
            	}
            	for (int i = 0; i < arr.length; i++) {
            		if (arr[i] == 0) {
            			result += '0';
            		}
            	}
            	System.out.println(result);
	        }
	        in.close();
	}
	
	private static void reverse(int[] arr) {
		for(int i = 0; i < arr.length / 2; i++){
		    int temp = arr[i];
		    arr[i] = arr[arr.length - i - 1];
		    arr[arr.length - i - 1] = temp;
		}
	}

}
