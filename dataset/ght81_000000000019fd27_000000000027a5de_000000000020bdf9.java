import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
			for (int testCases = in.nextInt(), testCase = 1; testCase <= testCases; testCase++) {
				final int n = in.nextInt();
				int[][] a = new int[n][3];
				for (int i = 0; i < n; i++) {
					a[i][0] = in.nextInt();
					a[i][1] = in.nextInt();
					a[i][2] = i;
				}
				out.println("Case #" + testCase + ": " + solve(a));
			}
		}
	}

	private static String solve(int[][] a) {
		final int n = a.length;
		StringBuilder ans = new StringBuilder(new String(new char[n]));
		Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));
		int c = -1, j = -1;
		for (int i = 0; i < n; i++) {
			if (c == -1 || a[c][1] <= a[i][0]) {
				c = i;
				ans.setCharAt(a[i][2], 'C');
			} else if (j == -1 || a[j][1] <= a[i][0]) {
				j = i;
				ans.setCharAt(a[i][2], 'J');
			} else {
				return "IMPOSSIBLE";
			}
		}
		return ans.toString();
	}

}
