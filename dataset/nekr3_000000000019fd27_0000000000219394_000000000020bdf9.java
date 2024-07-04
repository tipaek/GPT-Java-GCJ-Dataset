import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int x = 1; x <= t; x++) {
			int n = in.nextInt();
			int[][] activities = new int[2*n][3];
			for (int i = 0; i < n; i++) {
				activities[2*i][0] = in.nextInt();
				activities[2*i][1] = 0;
				activities[2*i][2] = i;
				activities[2*i+1][0] = in.nextInt();
				activities[2*i+1][1] = 1;
				activities[2*i+1][2] = i;
			}
			sort(activities, 2*n);
			boolean works = true;
			char[] output = new char[n];
			int c = 0;
			int cval = -1;
			int j = 0;
			int jval = -1;
			for (int i = 0; i < 2*n; i++) {
				if (activities[i][1] == 0) {
					if (c == 0) {
						c = 1;
						cval = activities[i][2];
						output[cval] = 'C';
					}
					else if (j == 0) {
						j = 1;
						jval = activities[i][2];
						output[jval] = 'J';
					}
					else {
						works = false;
						break;
					}
				}
				else {
					if (cval == activities[i][2]) c--;
					else j--;
				}
			}
			System.out.print("Case #" + x + ": ");
			if (works) for (int i = 0; i < n; i++) System.out.print(output[i]);
			else System.out.print("IMPOSSIBLE");
			System.out.println();
		}
	}
	static void sort(int[][] a, int n) {
		if (n <= 1) return;
		int mid = n/2;
		int[][] l = new int[mid][3];
		int[][] r = new int[n - mid][3];
		for (int i = 0; i < mid; i++) l[i] = a[i];
		for (int i = mid; i < n; i++) r[i - mid] = a[i];
		sort(l, mid);
		sort(r, n - mid);
		int i = 0, j = 0, k = 0;
		while (i < l.length && j < r.length) {
			if (l[i][0] <= r[j][0]) a[k++] = l[i++];
			else a[k++] = r[j++];
		}
		while (i < l.length) a[k++] = l[i++];
		while (j < r.length) a[k++] = r[j++];
	}
}
