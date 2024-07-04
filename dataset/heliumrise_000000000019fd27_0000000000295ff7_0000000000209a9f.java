import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    	in.nextLine();
        for (int i = 1; i <= t; ++i) {
        	String s = in.nextLine();
        	StringBuilder sb = new StringBuilder();
        	for(int j = 0; j < s.charAt(0) - '0'; j++) {
        		sb.append("(");
        	}
        	for(int j = 0; j < s.length()-1; j++) {
        		int L = s.charAt(j) - '0';
        		int R = s.charAt(j+1) - '0';
        		int diff = Math.abs(R-L);
        		sb.append(s.charAt(j));
        		if(L < R) {
        			for(int k = 0; k < diff; k++) {
                		sb.append("(");
                	}
        		} else {
        			for(int k = 0; k < diff; k++) {
                		sb.append(")");
                	}
        		}
        		
        	}
        	sb.append(s.charAt(s.length()-1));
            for(int j = 0; j < s.charAt(s.length() - 1) - '0'; j++) {
            	sb.append(")");
            }
            System.out.println("Case #" + i + ": " + sb.toString());
        }
        
    }
}