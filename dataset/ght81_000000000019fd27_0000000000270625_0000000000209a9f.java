import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
			for (int testCases = in.nextInt(), testCase = 1; testCase <= testCases; testCase++) {
				out.println("Case #" + testCase + ": " + solve(in.next()));
			}
		}
	}

	private static String solve(String s) {
		StringBuilder ans = new StringBuilder();
		final int n = s.length();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Character.getNumericValue(s.charAt(i));
		}
		for (int j = 0; j < a[0]; j++) {
			ans.append("(");
		}
		ans.append(s.charAt(0));
		for (int i = 1; i < n; i++) {
			if (a[i] > a[i - 1]) {
				for (int j = 0; j < a[i] - a[i - 1]; j++) {
					ans.append("(");
				}
			}
			if (a[i] < a[i - 1]) {
				for (int j = 0; j < a[i - 1] - a[i]; j++) {
					ans.append(")");
				}
			}
			ans.append(s.charAt(i));
		}
		for (int j = 0; j < a[n - 1]; j++) {
			ans.append(")");
		}
		return ans.toString();
	}

}
