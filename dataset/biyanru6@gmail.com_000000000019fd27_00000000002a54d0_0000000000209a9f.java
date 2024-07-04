import java.util.*;
import java.io.*;

public class Solution {
	
  public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();
	    for (int i = 1; i <= t; ++i) {
	    	String s = in.next();
	    	StringBuffer sb = new StringBuffer();
	    	for (int j = 0; j < s.length(); j++) {
	    		char ch = s.charAt(j);
	    		int size = ch -'0';
	    		for (int k = 0; k < size; k++) {
	    			sb.append("(");
	    		}
	    		sb.append(ch);
	    		for (int k = 0; k < size; k++) {
	    			sb.append(")");
	    		}
	    	}

	    	System.out.println("Case #" + i + ": " + helper(sb));
	    }
	}
	
	private static String helper(StringBuffer sb) {
		StringBuffer sb1 = new StringBuffer();
		boolean[] append = new boolean[sb.length()];
		append[0] = true;
		for (int i = 1; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			if (Character.isDigit(ch)) {
				append[i] = true;
			} else if (ch == '(' && sb.charAt(i-1) == ')') {
				append[i] = false;
				append[i-1] = false;
			} else {
				append[i] = true;
			}
		}
		
		for (int i = 0; i < sb.length(); i++) {
			if (append[i]) {
				sb1.append(sb.charAt(i));
			}
		}
		
		return sb.length() != sb1.length() ? helper(sb1) : sb.toString();
	}

}
