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
				out.println("Case #" + testCase + ": " + solve(in.nextInt(), in.nextInt(), in.next()));
			}
		}
	}

	private static String solve(int x, int y, String s) {
		final int n = s.length();
		for (int i = 0; i < n; i++) {
			switch (s.charAt(i)) {
			case 'E':
				x++;
				break;

			case 'N':
				y++;
				break;

			case 'W':
				x--;
				break;

			case 'S':
				y--;
				break;
			}
			if (Math.abs(x) + Math.abs(y) <= i + 1) {
				return Integer.toString(i + 1);
			}
		}
		return "IMPOSSIBLE";
	}

}
