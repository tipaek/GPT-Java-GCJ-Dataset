import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	
	static String print(int a, int n) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < a; i++) {
			s.append("(");
		}
		for (int i = 0; i < n; i++) {
			s.append(a);
		}
		for (int i = 0; i < a; i++) {
			s.append(")");
		}
		return s.toString();
	}
	
	static String solveAllCases(String s) {
		StringBuilder solu = new StringBuilder();
		int n = 1;
		int lastInt =Integer.parseInt(s.charAt(0)+"");
		
		for (int i = 1; i < s.length(); i++) {
			if (Integer.parseInt(s.charAt(i)+"") != lastInt) {
				solu.append(print(lastInt, n));
				lastInt = Integer.parseInt(s.charAt(i)+"");
				n = 1;
			} else {
				n++;
			}
		}
		solu.append(print(lastInt, n));
		
		return solu.toString();
	}
	
	
	
	static String Proceed(String s) {
		StringBuilder solution = new StringBuilder();
		solution.append(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i-1) == ')' && s.charAt(i) == '(')  {
				if(solution.length() != 0) solution.deleteCharAt(solution.length()-1);
			} else {
				solution.append(s.charAt(i));
			}
		}
		
		return solution.toString();
	}
	

	static String solveIt(String s) {
		StringBuilder solu = new StringBuilder();
		StringBuilder ones = new StringBuilder();
		int j = 0;

		// 0111000
		// j=1

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				if (i - j <= 0) {
					
					solu.append("0");
				} else {
					solu.append("(");
					solu.append(ones);
					ones = new StringBuilder();
					solu.append(")");
					solu.append("0");
					j = i;
				}
				j++;
			} else {
				ones.append("1");
			}

		}
		if (ones.length() != 0) {
			solu.append("(" + ones + ")");

		}

		return solu.toString();
	}

	public static void main(String[] args) {
		int T = Integer.parseInt(in.nextLine());
		String solution;
		String s;
		for (int i = 1; i <= T; i++) {
			s = in.nextLine().trim();
			//solution = solveIt(s);
			solution = solveAllCases(s);
			//System.out.println(solution);
			//Proceed(solution);
			System.out.println("Case #" + i + ": " + Proceed(solution));

		}

	}

}
