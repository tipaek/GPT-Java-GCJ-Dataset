import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numc = input.nextInt();
		for (int i = 0; i < numc; i++) {
			int n = input.nextInt();
			int tasks[][] = new int[n][4];
			for (int a = 0; a < n; a++) {
				tasks[a][0] = input.nextInt();
				tasks[a][1] = input.nextInt();
				tasks[a][2] = a;
				tasks[a][3] = -2;
			}
			java.util.Arrays.sort(tasks, new java.util.Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return Integer.compare(a[0], b[0]);
				}
			});

			int C = 0;
			int J = 0;
			for (int x = 0; x < n; x++) {
				if (tasks[x][0] >= C) {
					C = tasks[x][1];
					tasks[x][3] = 1;
				} else if (tasks[x][0] >= J) {
					J = tasks[x][1];
					tasks[x][3] = 0;
				} else {
					tasks[x][3] = -1;
				}
			}
			java.util.Arrays.sort(tasks, new java.util.Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return Integer.compare(a[2], b[2]);
				}
			});
			String ans = "";
			for (int l = 0; l < n; l++) {
				if (tasks[l][3] == -1) {
					ans = "IMPOSSIBLE";
					break;
				} else if (tasks[l][3] == 1) {
					ans += "C";
				} else if (tasks[l][3] == 0) {
					ans += "J";
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + ans);
		}

	}
}
