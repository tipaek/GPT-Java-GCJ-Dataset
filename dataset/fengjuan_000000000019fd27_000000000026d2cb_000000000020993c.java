import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] M = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					M[j][k] = in.nextInt();
				}
			}
			int K = 0, r = 0, c = 0;
			for (int j = 0; j < n; j++) {
				K += M[j][j];
				HashSet<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
				for (int k = 0; k < n; k++) {
					s1.add(M[j][k]);
					s2.add(M[k][j]);
				}
				r += s1.size() == n ? 0 : 1;
				c += s2.size() == n ? 0 : 1;
			}
			System.out.println("Case #" + i + ": " + K + " " + r + " " + c);

		}
	}
}