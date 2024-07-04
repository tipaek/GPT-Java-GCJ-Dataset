import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			Integer[] k = new Integer[n];
			int[][] s = new int[n][2];
			for (int j = 0; j < n; j++) {
				k[j] = j;
				s[j][0] = in.nextInt();
				s[j][1] = in.nextInt();
			}
			Arrays.sort(k, (a, b) -> s[a][0] - s[b][0]);
			int a = 0, b = 0;
			boolean flag = false;
			char[] c = new char[n];
			for (int j = 0; j < n; j++) {
				if (s[k[j]][0] >= a) {
					a = s[k[j]][1];
					c[k[j]] = 'C';
				} else if (s[k[j]][0] >= b) {
					b = s[k[j]][1];
					c[k[j]] = 'J';
				} else {
					flag = true;
					break;
				}
			}
			if (flag) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + i + ": " + String.valueOf(c));
			}
		}
	}
}