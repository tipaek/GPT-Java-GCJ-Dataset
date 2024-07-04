import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int x = 1; x <= t; ++x) {
			int size = in.nextInt();
			long[] X = new long[size];
			long[] Y = new long[size];
			long ans = 1;
			for (int i = 0; i < size; i++) {
				X[i] = in.nextInt();
				Y[i] = in.nextInt();
			}
			for (int a = 0; a < size; a++) {
				for (int b = 1 + a; b < size; b++) {
					int[] index = new int[size];
					int[] count = new int[size];
					int n = 0;
					int m = 0;
					for (int c = 0; c < size; c++) {
						if (index[c] != 0) {
							continue;
						}
						for (int d = c; d < size; d++) {
							if ((X[c] - X[d]) * (Y[a] - Y[b]) != (X[a] - X[b]) * (Y[c] - Y[d])) {
								continue;
							}
							index[d] = 1 + c;
						}
					}
					for (int i = 0; i < size; i++) {
						count[index[i] - 1]++;
					}
					for (int i = 0; i < size; i++) {
						if (count[i] == 1) {
							m++;
						} else {
							n += count[i];
						}
					}
					if (n + Math.min(m, 2 - n % 2) > ans) {
						ans = n + Math.min(m, 2 - n % 2);
					}
				}
			}
			System.out.println("Case #" + x + ": " + ans);
		}
	}
}