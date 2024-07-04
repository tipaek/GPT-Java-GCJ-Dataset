import java.util.*;
import java.io.*;
public class Solution {
 public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int l = 1; l <= t; l++) {
			int n = in.nextInt();
			int[][] arr = new int[107][107];
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					arr[i][j] = in.nextInt();
					if (i == j) {
						sum += arr[i][j];
					}
				}
			}
			int r = 0;
			int c = 0;
			for (int i = 1; i <= n; i++) {
				int[] vis = new int[107];
				for (int k = 1; k <= n + 1; k++)
					vis[k] = 0;
				for (int j = 1; j <= n; j++) {
					if (vis[arr[i][j]] == 0) {
						vis[arr[i][j]] = 1;
					} else {
						r++;
						break;
					}
				}
			}
			for (int i = 1; i <= n; i++) {
				int[] vis2 = new int[107];
				for (int k = 1; k <= n + 1; k++)
					vis2[k] = 0;
				for (int j = 1; j <= n; j++) {
					if (vis2[arr[j][i]] == 0)
						vis2[arr[j][i]] = 1;
					else {
						c++;
						break;
					}
				}
			}
			System.out.println("Case #" + l + ": " + sum + " " + r + " " + c);
		}
	}

}