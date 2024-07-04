import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int t1 = 1; t1 <= t; t1++) {
			int n = Integer.parseInt(br.readLine());
			int[][] a = new int[n][];
			int r = 0;
			int c = 0;
			int tr = 0;
			for (int i = 0; i < n; i++) {
				a[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				tr = tr + a[i][i];
			}
			r = rowSum(a, n);
			c = colSum(a, n);
			System.out.println(("Case #" + t1 + ": " + tr + " " + r + " " + c));
		}

	}

	public static int colSum(int[][] a, int n) {
		int cd = 0;
		for (int i = 0; i < n; i++) {
			int c = 0;
			boolean[] cs = new boolean[n + 1];
			for (int j = 0; j < n; j++) {
				if (!cs[a[j][i]]) {
					cs[a[j][i]] = true;
					c++;
				}
			}
			if (c != n)
				cd++;
		}
		return cd;
	}

	public static int rowSum(int[][] a, int n) {
		int cd = 0;
		for (int i = 0; i < n; i++) {
			int c = 0;
			boolean[] cs = new boolean[n + 1];
			for (int j = 0; j < n; j++) {
				if (!cs[a[i][j]]) {
					cs[a[i][j]] = true;
					c++;
				}
			}
			if (c != n)
				cd++;
		}
		return cd;
	}

}