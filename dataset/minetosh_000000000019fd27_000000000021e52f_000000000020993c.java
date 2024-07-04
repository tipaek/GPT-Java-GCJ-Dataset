import java.util.Scanner;
import java.util.HashSet;

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
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < N; j++) {
				if (set.contains(M[i][j])) {
					rowMax++;
					break;
				} else {
					set.add(M[i][j]);
				}
			}
		}

		int colMax = 0;
		for (int j = 0; j < N; j++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < N; i++) {
				if (set.contains(M[i][j])) {
					colMax++;
					break;
				} else {
					set.add(M[i][j]);
				}
			}
		}

		return S + " " + rowMax + " " + colMax;
	}
}