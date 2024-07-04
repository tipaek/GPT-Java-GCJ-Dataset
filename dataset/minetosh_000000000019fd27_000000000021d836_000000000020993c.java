import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map.Entry;

public class Solution {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			System.out.println("Case #" + i + ": " + resolv(sc));
		}
	}

	private static String resolv(Scanner sc) {
		int N = sc.nextInt();
		int n;
		int s;
		int S = 0;
		int[][] M = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				M[i][j] = sc.nextInt();
				if (i == j)
					S += M[i][j];
			}
		}

		int rowMax = 0;
		for (int i = 0; i < N; i++) {
			int pre = M[i][0];
			int rep = 0;
			for (int j = 1; j < N; j++) {
				if (pre == M[i][j])
					rep++;
				else
					rep = 0;
				pre = M[i][j];
			}
			rowMax = Math.max(rowMax, rep);
		}
		if (rowMax > 0)
			rowMax++;

		int colMax = 0;
		for (int j = 0; j < N; j++) {
			int pre = M[0][j];
			int rep = 0;
			for (int i = 1; i < N; i++) {
				if (pre == M[i][j])
					rep++;
				else
					rep = 0;
				pre = M[i][j];
			}
			colMax = Math.max(colMax, rep);
		}
		if (colMax > 0)
			colMax++;

		return S + " " + rowMax + " " + colMax;
	}
}