import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tt = 1; tt <= t; tt++) {
			int n = sc.nextInt();
			int[][] matrix = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					matrix[i][j] = sc.nextInt();
			}

			int trace = 0, r = 0, c = 0;
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				trace += matrix[i][i];
				for (int j = 0; j < n; j++) {
					if (set.contains(matrix[i][j])) {
						r++;
						break;
					}
					set.add(matrix[i][j]);
				}
				set.clear();
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (set.contains(matrix[j][i])) {
						c++;
						break;
					}
					set.add(matrix[j][i]);
				}
				set.clear();
			}

			System.out.println("Case #" + tt + ": " + trace + " " + r + " " + c);
		}
	}
}