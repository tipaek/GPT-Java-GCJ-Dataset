import java.util.*;
import java.io.*;
public class Solution {
	static boolean debug = false;

	static int maxDiff = Integer.MAX_VALUE - 1;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.valueOf(in.nextLine().trim()); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			String str = in.nextLine().trim();
			System.out.println("Case #" + i + ": " + compute(str));
		}
	}

	public static String compute(String str) {
		int n = str.length();
		StringBuilder sb = new StringBuilder();
		char[] charArray = str.toCharArray();
		int[] s = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = charArray[i] - '0';
		}
		int[] count = Arrays.copyOf(s, n);
		rc(s, count, sb);
		return sb.toString();
	}

	public static void rc(int[] s, int[] count, StringBuilder sb) {
		if (debug) {
			System.out.println(Arrays.toString(s) + " - " + Arrays.toString(count) + " -> " + sb.toString());
		}
		int min = min(count);
		if (min == 0) {	// need to split
			for (int i = 0; i < count.length; i++) {
				if (count[i] == 0) {
					sb.append(s[i]);
				} else {
					int j = i;
					while (j < count.length && count[j] != 0) {
						j++;
					}
					rc(Arrays.copyOfRange(s, i, j), Arrays.copyOfRange(count, i, j), sb);
					i = j - 1;
				}
			}
		} else {
			int tmp = min;
			while (tmp-- > 0) {
				sb.append("(");
			}
			for (int i = 0; i < count.length; i++) {
				count[i] -= min;
			}
			rc(s, count, sb);
			tmp = min;
			while (tmp-- > 0) {
				sb.append(")");
			}
		}
	}

	public static int min(int[] arr) {
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
		}
		return min;
	}
}