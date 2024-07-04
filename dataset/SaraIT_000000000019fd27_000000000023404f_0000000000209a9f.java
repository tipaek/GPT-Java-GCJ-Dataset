import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

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
			solution = solveIt(s);
			System.out.println("Case #" + i + ": " + solution);

		}

	}

}
