import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int N = in.nextInt();
			String binaryString = Integer.toBinaryString(N - 30);
			System.out.println("Case #" + i + ":");
			int r = 1, k = 1, count = 0;
			if (N < 30) {
				for (int j = 0; j < N; j++) {
					System.out.println(r + " " + k);
					r++;
					k += k < 0 ? 1 : 0;
				}
			} else {
				for (int j = binaryString.length() - 1; j >= 0; j--) {
					System.out.println(r + " " + k);
					if (binaryString.charAt(j) == '1') {
						if (k == 1) {
							for (k++; k <= r; k++) {
								System.out.println(r + " " + k);
							}
						} else {
							for (k--; k > 0; k--) {
								System.out.println(r + " " + k);
							}
						}
					} else {
						count++;
					}
					r++;
					k = k == 0 ? 1 : r;
				}
				for (int j = 0; j < 30 - count; j++) {
					System.out.println(r + " " + k);
					r++;
					k = k == 1 ? 1 : r;
				}
			}
		}
	}
}