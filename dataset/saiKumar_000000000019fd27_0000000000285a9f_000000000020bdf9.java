import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = Integer.parseInt(s.nextLine());
		for (int i = 0; i < t; i++) {
			int cte = 0, jte = 0, cts = 0, jts = 0;
			int n = Integer.parseInt(s.nextLine());
			int mat[][] = new int[n][2];
			for (int j = 0; j < n; j++) {
				String rowStr = s.nextLine();
				String[] rowArr = rowStr.split(" ");
				mat[j][0] = Integer.parseInt(rowArr[0]);
				mat[j][1] = Integer.parseInt(rowArr[1]);
			}
			String schedule = "C";
			cts = mat[0][0];
			cte = mat[0][1];
			for (int j = 1; j < n; j++) {
				if (mat[j][0] >= cte) {
					cts = mat[j][0];
					cte = mat[j][1];
					schedule += "C";
				} else if (mat[j][0] < cts && mat[j][1] <= cts) {
					schedule += "C";
				} else if (mat[j][0] >= jte) {
					jts = mat[j][0];
					jte = mat[j][1];
					schedule += "J";
				} else if (mat[j][0] < jts && mat[j][1] <= jts) {
					schedule += "J";
				} else {
					schedule = "IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + schedule);
		}
		s.close();
	}

}
