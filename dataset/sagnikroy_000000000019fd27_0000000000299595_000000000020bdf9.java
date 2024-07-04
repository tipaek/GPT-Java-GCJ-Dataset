import java.util.*;
import java.io.*;
import java.lang.Math;

class Solution {
	public static void main (String[] args) {
		boolean debug = false;
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int[][] masterSched = new int[1440][2];
			boolean impossible = false;
			
			int w = in.nextInt();
			int[][] ans = new int[w][2];
			int cnt = 0;

			int[][] A = new int[w][3];
			for (int j = 0; j < w; j++) {
				A[j][0] = in.nextInt();
				A[j][1] = in.nextInt();
				A[j][2] = cnt++;
				
				if (debug) {
					System.out.println("" + A[j][0] + " " + A[j][1]);
				}
			}
			Arrays.sort(A, new java.util.Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return Integer.compare(a[0], b[0]);
				}
			});
			for (int j = 0; j < w; j++) {
				int startTime = A[j][0];
				int endTime = A[j][1];
				int B = A[j][2];
				boolean C = true;
				boolean J = true;

				for (int k = startTime; k < endTime; k++) {
					if (masterSched[k][0] == 1) {
						C = false;
					}
				}
				if (C) {
					for (int k = startTime; k < endTime; k++) {
						masterSched[k][0] = 1;
					}

					ans[j] = new int[] {B, 1};
				} else {
					for (int k = startTime; k < endTime; k++) {
						if (masterSched[k][1] == 1) {
							J = false;
						}
					}
					if (J) {
						for (int k = startTime; k < endTime; k++) {
							masterSched[k][1] = 1;
						}
						ans[j] = new int[] {B, 2};
					} else {
						impossible = true;
					}
				}
			}
			String sol = "";
			if (impossible) {
				sol = "IMPOSSIBLE";
			} else {
				Arrays.sort(ans, new java.util.Comparator<int[]>() {
					public int compare(int[] a, int[] b) {
						return Integer.compare(a[0], b[0]);
					}
				});

				for (int j = 0; j < ans.length; j++) {
					if (ans[j][1] == 1) {
						sol += "C";
					} else if (ans[j][1] == 2) {
						sol += "J";
					}
				}
			}
			System.out.println("Case #" + i + ": " + sol);
		}
	}
}