import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws FileNotFoundException {
        //Scanner in = new Scanner(new File("testcase.txt"));
    	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(in.nextLine());
        for(int i=0; i<T; i++) {
        	String s = in.nextLine();
        	String ans = solve(s);
        	System.out.println("Case #"+(i+1)+": "+ans);
        }
        
     }
    public static String solve(String s) {
    	String answer = "";
    	for(int i=0; i<s.length(); i++) {
    		int digit = Integer.valueOf(String.valueOf(s.charAt(i)));
    		boolean insertable = false;
    		boolean noHope = false;
    		for(int j=answer.length()-1; j>=0; j--) {
    			// If can insert --> insert in between parentheses ex. 0 (( 2 ) 1 )
    			if(numSurrounding(answer, j, digit) == true && answer.substring(j+1).matches(".*\\d.*") == false) {
    				// 00000 00 length = 7 j = 5
    				answer = answer.substring(0,j) + String.valueOf(digit) + answer.substring(j);
    				insertable = true;
    				noHope = true;
    				break;
    			}
    			
    		}
    		if(insertable == false && digit > 0) {
    			for(int k = answer.length()-1; k>=0; k--) {
    				int numNeeded = digit - numRightParen(answer, k);
    				if(numNeeded<0) {
    					noHope = false;
    					break;
    				}
    				String insert = String.join("", Collections.nCopies(numNeeded, "(")) + digit + String.join("", Collections.nCopies(numNeeded, ")"));
    				if(numSurrounding(answer.substring(0,k)+insert+answer.substring(k), k, digit) == true && answer.substring(k).matches(".*\\d.*") == false) {
    					answer = answer.substring(0,k)+insert+answer.substring(k);
    					noHope = true;
    					break;
    				}
    			}
    		}
    		if(noHope == false) {
    			// If can't insert --> insert after ex. 0 (( 2 ) 1 ) (((3)))
        		answer += addParentheses(digit);
    		}
    	}
    	return answer;
    }
    public static String addParentheses(int digit) {
    	String answer = "";
    	answer += String.join("", Collections.nCopies(digit, "("));
    	answer += String.valueOf(digit);
    	answer += String.join("", Collections.nCopies(digit, ")"));
    	return answer;
    }
   
    public static int numRightParen(String s, int index) {
    	int rightcount = 0;
    	for(int i=index; i<s.length(); i++) {
    		if(s.charAt(i) == ')') {
    			rightcount += 1;
    		}
    	}
    	return rightcount;
    }
    
    public static boolean numSurrounding(String s, int index, int digit) {
    	int leftcount = 0;
    	int rightcount = 0;
    	for(int i=0; i<index; i++) {
    		if(s.charAt(i) == '(') {
    			leftcount += 1;
    		}
    	}
    	for(int i=index; i<s.length(); i++) {
    		if(s.charAt(i) == ')') {
    			rightcount += 1;
    		}
    	}
    	int[] arr = new int[2];
    	arr[0] = leftcount;
    	arr[1] = rightcount;
    	boolean answer = false;
    	if(rightcount == digit && leftcount >= digit) {
    		answer = true;
    	}
    	else {
    		answer = false;
    	}
    	return answer;
    }
}