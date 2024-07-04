import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) throws Exception {
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			System.out.print("Case #" + i + ": ");
			solve();
		}

	}

	// **SOLUTION**
	public static void solve() throws Exception {
		int n = sc.nextInt();
		int trace = 0;
		int[][] arr = new int[n][n];

		HashSet<Integer>[] row = new HashSet[n];
		HashSet<Integer>[] col = new HashSet[n];

		for (int i = 0; i < n; i++) {
			row[i] = new HashSet<>();
			col[i] = new HashSet<>();
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				int x = sc.nextInt();
				row[i].add(x);
				col[j].add(x);
				if (i == j)
					trace += x;
			}

		int r = 0, c = 0;
		for (int i = 0; i < n; i++) {
			if (row[i].size() != n)
				r++;
			if (col[i].size() != n)
				c++;
		}

		System.out.println(trace + " " + r + " " + c);

	}

	public static InputStreamReader r = new InputStreamReader(System.in);

	public static BufferedReader br = new BufferedReader(r);

	public static Scanner sc = new Scanner(System.in);
}
