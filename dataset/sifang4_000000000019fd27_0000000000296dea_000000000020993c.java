import java.util.*;
import java.io.*;

class Q1vestigium {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int ii = 1; ii <= t; ++ii) {
			int n = in.nextInt();
			int[][] A = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					A[i][j] = in.nextInt();
				}
			}

			int k = 0;
			for (int i = 0; i < n; i++) {
				k += A[i][i];
			}
			int r = 0;
			for (int i = 0; i < n; i++) {
				Set<Integer> set = new HashSet<>();
				for (int j = 0; j < n; j++) {
					if (!set.add(A[i][j])) {
						r++;
						break;
					}
				}
			}

			int c = 0;
			for (int j = 0; j < n; j++) {
				Set<Integer> set = new HashSet<>();
				for (int i = 0; i < n; i++) {
					if (!set.add(A[i][i])) {
						c++;
						break;
					}
				}
			}
			System.out.print("Case #" + ii + ": " + k + " " + r + " " + c);
		}

	}

}