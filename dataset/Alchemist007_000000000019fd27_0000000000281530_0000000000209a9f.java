import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		int t = 0;
		while(++t <= T) {
			String s = scn.next();
			System.out.println("Case #" + t + ": " +addParenthesis(s, 0));
		}
	}
	
	public static String addParenthesis(String s, int bc) {
		if(s.length() == 0)
			return "";
		int min = getMin(s);
		String rv = "";
		int start = 0;
		for(int i = 0; i<s.length(); i++) {
			int digit = Integer.parseInt(s.substring(i, i+1));
			if(digit == min) {
				rv += addParenthesis(s.substring(start,i), bc+min) + s.charAt(i);
				start = i+1;
			}
		}
		rv += addParenthesis(s.substring(start), bc+min);
		for(int i = bc; i<min; i++)
			rv = "(" + rv;
		for(int i = bc; i<min; i++)
			rv = rv + ")";
		return rv;
	}
	
	public static int getMin(String s) {
		int minVal = Integer.parseInt(s.substring(0, 1));
		for(int i = 1; i<s.length(); i++) {
			int digit = Integer.parseInt(s.substring(i, i+1));
			if(digit < minVal)
				minVal = digit;
		}
		return minVal;
	}

}