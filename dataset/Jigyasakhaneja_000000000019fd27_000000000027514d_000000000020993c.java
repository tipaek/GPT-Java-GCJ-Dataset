

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int[][] ans = new int[t][3];
		for (int i = 0; i < t; i++) {
			int n = s.nextInt();
			int[][] arr = new int[n][n];
			int sum = 0;
			int c = 0;
			int r = 0;
			for (int j = 0; j < n; j++) {

				for (int k = 0; k < n; k++) {
					arr[j][k] = s.nextInt();
					if (j == k)
						sum += arr[j][k];
				}
			}
			for (int j = 0; j < n; j++) {
				HashSet<Integer> set = new HashSet<>();

				for (int k = 0; k < n; k++) {

					if (set.contains(arr[j][k]))
						{
						r++;
						break;
						}
					else
						set.add(arr[j][k]);

				}
			}

			for (int j = 0; j < n; j++) {
				HashSet<Integer> set = new HashSet<>();
				for (int k = 0; k < n; k++) {
					if (set.contains(arr[k][j]))
						{c++;
						break;
						}
					else
						set.add(arr[k][j]);
				}
			}
			
			ans[i][0] = sum;
			ans[i][1] = r;
			ans[i][2] = c;

		}

		for (int i = 0; i < t; i++) {
			System.out.println("Case #" + (i + 1) + ": " + ans[i][0] + " " + ans[i][1] + " " + ans[i][2]);
		}

	}
}
