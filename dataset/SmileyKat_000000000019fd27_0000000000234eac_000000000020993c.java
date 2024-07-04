import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A_Vestigium {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numTest = sc.nextInt();
		for (int test = 1; test <= numTest; ++test) {
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					a[i][j] = sc.nextInt();
				}
			}

			int k = 0;
			for (int i = 0; i < n; ++i) k += a[i][i];

			Set<Integer> nums = new HashSet<>(n);
			int r = 0;
			for (int i = 0; i < n; ++i) {
				nums.clear();
				for (int j = 0; j < n; ++j) nums.add(a[i][j]);
				if (nums.size() != n) ++r;
			}
			int c = 0;
			for (int j = 0; j < n; ++j) {
				nums.clear();
				for (int i = 0; i < n; ++i) nums.add(a[i][j]);
				if (nums.size() != n) ++c;
			}

			System.out.printf("Case #%d: %d %d %d\n", test, k, r, c);
		}
		sc.close();
	}

}
