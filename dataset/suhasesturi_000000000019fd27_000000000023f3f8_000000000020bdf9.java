// package codejam.Y2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int x = 0; x < t; x++) {
			int n = Integer.parseInt(in.readLine());
			int[][] start = new int[n][2];
			int[][] end = new int[n][2];
			String[] s;
			for (int i = 0; i < n; i++) {
				s = in.readLine().split(" ");
				start[i][0] = Integer.parseInt(s[0]);
				start[i][1] = i;
				end[i][1] = i;
				end[i][0] = Integer.parseInt(s[1]);
			}
			Arrays.sort(start, Comparator.comparingInt(a -> a[0]));
			Arrays.sort(end, Comparator.comparingInt(a -> a[0]));
			char[] positions = new char[n];
			int[] taken = new int[2];
			boolean flag = true;
			for (int i = 0, j = 0; i < n && j < n; ) {
				if (start[i][0] < end[j][0]) {
					if (taken[0] == 0) {
						positions[start[i][1]] = 'C';
						taken[0] = 1;
					} else if (taken[1] == 0) {
						positions[start[i][1]] = 'J';
						taken[1] = 1;
					} else {
						flag = false;
						break;
					}
					i++;
				} else {
					if (positions[end[j][1]] == 'C') taken[0] = 0;
					else taken[1] = 0;
					j++;
				}
			}

			if (flag) {
				System.out.println("Case #" + (x + 1) + ": " + String.valueOf(positions));
			} else {
				System.out.println("Case #" + (x + 1) + ": IMPOSSIBLE");
			}
		}
	}
}
