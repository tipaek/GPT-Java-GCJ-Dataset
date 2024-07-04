import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = sc.nextInt();
		for (int i2 = 1; i2 <= t; i2++) {
			int n = sc.nextInt();

			int matrix[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int x = sc.nextInt();
					matrix[i][j] = x;
				}
			}

			System.out.println("Case #" + i2 + ": " + solution(matrix));
		}

		sc.close();
	}

	private static String solution(int[][] matrix) {
		int n = matrix.length;
		//System.out.println(Arrays.deepToString(matrix));
		int s = 0;
		int r = 0;
		int c = 0;
		for (int i = 0; i < n; i++) {
			s += matrix[i][i];
		}

		for (int i = 0; i < n; i++) {
			HashSet<Integer> uniq = new HashSet<Integer>();
			for (int j = 0; j < n; j++) {
				uniq.add(matrix[i][j]);
			}
			if (uniq.size() != n) {
				r++;
			}
		}
		
		for (int i = 0; i < n; i++) {
			HashSet<Integer> uniq = new HashSet<Integer>();
			for (int j = 0; j < n; j++) {
				uniq.add(matrix[j][i]);
			}
			if (uniq.size() != n) {
				c++;
			}
		}
		
		return s + " " + r + " " + c;
	}

}