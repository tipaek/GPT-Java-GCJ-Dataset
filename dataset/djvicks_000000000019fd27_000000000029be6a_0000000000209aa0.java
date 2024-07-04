import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int t = in.nextInt();
			final String IMPOSSIBLE = "IMPOSSIBLE";
			final String POSSIBLE = "POSSIBLE";
			String s = "";
			for (int i = 1; i <= t; ++i) {
				int n = 0, k, d = 0;
				outer: {
					n = in.nextInt();
					k = in.nextInt();
					if (n == 0) {
						s = IMPOSSIBLE;
						break outer;
					}
					int r = k % n;
					d = 0;
					if (r == 0 && n <= k && n * n >= k) {
						s = POSSIBLE;
						d = k / n;
					} else {
						s = IMPOSSIBLE;
						break outer;
					}
				}
				System.out.println("Case #" + i + ": " + s);
				if (POSSIBLE.equals(s)) {
					printMatrix(n, d);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printMatrix(int n, int d) {
		for (int v = 0; v < n; v++) {
			d--;
			for (int s = 0; s < n; s++) {
				if (d == -1) {
					d = n - 1;
				}
				System.out.print(++d);
				if (s < n - 1) {
					System.out.print(" ");
				}
				if (d == n) {
					d = 0;
				}
			}
			System.out.println();
		}
	}
}