import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String... g) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = s.nextInt();
			int[][] a = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = s.nextInt();
				}
			}
			int k = 0, r = 0, c = 0;
			for (int i = 0; i < n; i++) {
				k += a[i][i];
			}
			for (int row = 0; row < n; row++) {
				Set<Integer> set = new HashSet<>();
				for (int col = 0; col < n; col++) {
					if (set.contains(a[row][col])) {
						r++;
						break;
					} else {
						set.add(a[row][col]);
					}
				}
			}
			for (int col = 0; col < n; col++) {
				Set<Integer> set = new HashSet<>();
				for (int row = 0; row < n; row++) {
					if (set.contains(a[row][col])) {
						c++;
						break;
					} else {
						set.add(a[row][col]);
					}
				}
			}
			System.out.printf("Case #%d: %d %d %d", tc, k, r, c).println();
		}
	}
}