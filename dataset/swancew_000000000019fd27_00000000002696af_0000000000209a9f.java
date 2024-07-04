import java.io.*;
import java.util.*;

public class Solution {
	
	public static String getParentheses(String number) {
		StringBuilder sb = new StringBuilder();
		int numParentheses = 0;
		for(char c: number.toCharArray()) {
			int val = Integer.parseInt(String.valueOf(c));
			while(numParentheses < val) {
				sb.append("(");
				numParentheses++;
			}
			while(numParentheses > val) {
				sb.append(")");
				numParentheses--;
			}
			sb.append(c);
		}
		
		while(numParentheses > 0) {
			sb.append(")");
			numParentheses--;
		}
		
		return sb.toString();
	}
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	PrintWriter out = new PrintWriter(System.out);
    	int tcs = sc.nextInt();
    	String s = sc.nextLine();
    	for (int tc = 1; tc <= tcs; tc++) {
    		s = sc.nextLine();

    		out.printf("Case #%d: %s\n", tc, getParentheses(s));
    	}
    	out.close();
    	sc.close();
	}
}