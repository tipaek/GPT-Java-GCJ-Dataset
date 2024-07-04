import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		ArrayList<int[][]> list = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int a[][] = new int[N][2];
			for (int j = 0; j < a.length; j++) {
				for (int k = 0; k < 2; k++) {
					a[j][k] = sc.nextInt();
				}
			}
			list.add(a);
		}
		int index = 1;
		for (int[][] a : list) {
			String output = getScheduledActivities(a);
			System.out.println("Case #" + index + ": " + output);
			index++;
		}
	}

	public static String getScheduledActivities(int[][] a) {
		StringBuilder sb = new StringBuilder();
		int C[] = new int[1441];
		int J[] = new int[1441];
		boolean assigned;
		for (int j = 0; j < a.length; j++) {
			assigned = false;
			if (C[a[j][0]] == 0 && C[a[j][1]] == 0) {
				for (int k = a[j][0]; k < a[j][1]; k++) {
					C[k] = 1;
				}
				assigned = true;
				sb.append("C");
			}
			if (!assigned && J[a[j][0]] == 0 && J[a[j][1]] == 0) {
				for (int k = a[j][0]; k < a[j][1]; k++) {
					J[k] = 1;
				}
				assigned = true;
				sb.append("J");
			}
			if (!assigned) {
				return "IMPOSSIBLE";
			}
		}
		return sb.toString();
	}
}
