import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int N = in.nextInt();
			int k = 0;
			int[][] arr = new int[N][];
			for (int r=0; r < N; r++) {
				arr[r] = new int[N];
				for (int c=0; c < N; c++) {
					arr[r][c] = in.nextInt();
					if (r == c) {
						k = k + arr[r][c];
					}
				}
			}

			int rCount = 0;
			int cCount = 0;
			
			for (int r=0; r < N; r++) {
				boolean[] isRepeat = new boolean[N+1];
				for (int c=0; c < N; c++) {
					if (isRepeat[arr[r][c]]) {
						rCount++;
						break;
					} else {
						isRepeat[arr[r][c]] = true;
					}
				}
				isRepeat = new boolean[N+1];
				for (int c=0; c < N; c++) {
					if (isRepeat[arr[c][r]]) {
						cCount++;
						break;
					} else {
						isRepeat[arr[c][r]] = true;
					}
				}
			}
			System.out.println("Case #" + i + ": " + k + " " + rCount + " " + cCount);
		}
	}
}