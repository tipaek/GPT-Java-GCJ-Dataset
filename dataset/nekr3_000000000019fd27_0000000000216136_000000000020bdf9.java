import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int x = 1; x <= t; x++) {
			int n = in.nextInt();
			int[][] activities = new int[2*n][2];
			for (int i = 0; i < n; i++) {
				activities[2*i][0] = in.nextInt();
				activities[2*i][1] = 0;
				activities[2*i+1][0] = in.nextInt();
				activities[2*i+1][1] = 1;
			}
			sort(activities, 2*n);
			int counter = 0;
			String output = "";
			for (int i = 0; i < 2*n; i++) {
				if (activities[i][1] == 0) {
					counter++;
					if (counter > 2) {
						output = "IMPOSSIBLE";
						break;
					}
					if (counter == 1) output = output + "C";
					else output = output + "J";
				}
				else counter--;
			}
			System.out.println("Case #" + x + ": " + output);
		}
	}
	static void sort(int[][] a, int n) {
		if (n <= 1) return;
		int mid = n/2;
		int[][] l = new int[mid][2];
		int[][] r = new int[n - mid][2];
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