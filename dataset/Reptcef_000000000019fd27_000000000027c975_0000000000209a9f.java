import java.util.*;
import java.io.*;

class Solution {
	
	static PrintWriter out;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		out = new PrintWriter(System.out, true);
	    
		int t = in.nextInt();
	    for (int i = 0; i < t; i++) {
	    	String s = in.next();
	    	solveCase(i, s);
	    }
	    
	    out.close();
	    System.exit(0);
	}
	
	static void solveCase(int i, String s) {
		StringBuilder sb = new StringBuilder();
		int preD = 0;
		for (int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			int d = Integer.parseInt(String.valueOf(c));
			appendParenthesisInBetween(sb, preD, d);
			sb.append(d);
			preD = d;
		}
		appendParenthesisInBetween(sb, preD, 0);
		out.println(String.format("Case #%d: %s", i + 1, sb.toString()));
	}
	
	static void appendParenthesisInBetween(StringBuilder sb, int preD, int d) {
		if (preD == d) {
			return;
		}
		int diff = Math.abs(preD - d);
		for (int i = 0; i < diff; i++) {
			sb.append(preD > d ? ')' : '(');
		}
		return;
	}

}
