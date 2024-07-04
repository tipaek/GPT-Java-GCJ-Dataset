import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	static int[] xd = { -1, -1, 0, 0, 1, 1 };
	static int[] yd = { -1, 0, -1, 1, 0, 1 };

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();

		for (int i = 1; i <= t; ++i) {
			Set<String> set = new LinkedHashSet<>();
			int n = in.nextInt();
			dfs(n, 1, 1, 1, set);
			System.out.println("Case #" + i + ":");

			for (String r : set) {
				String[] rs = r.split("!");
				System.out.println(rs[0] + " " + rs[1]);
			}
		}
	}

	private static boolean dfs(int n, int x, int y, int tempSum, Set<String> set) {
		if (tempSum > n || set.size() >= 500)
			return false;
		if (set.contains(x + "!" + y))
			return false;
		set.add(x + "!" + y);
		if (tempSum == n)
			return true;

		// System.out.println("X : " + x + ". Y : " + y + ". TS : " + tempSum + ". Set :
		// " + set);
		for (int i = 0; i < 6; i++) {
			int nx = x + xd[i];
			int ny = y + yd[i];

			if (isValid(nx, ny, set)) {
				// System.out.println("Trying : NX : " + nx + ". NY : " + ny + ". Sum " + nCr(nx
				// - 1, ny - 1));
				boolean result = dfs(n, nx, ny, tempSum + nCr(nx - 1, ny - 1), set);
				if (result)
					return true;
			}
		}
		set.remove(x + "!" + y);
		return false;
	}

	private static boolean isValid(int x, int y, Set<String> set) {
		return x > 0 && y > 0 && (y <= x) && !set.contains(x + "!" + y);
	}

	private static int nCr(int n, int r) {
		return fact(n) / (fact(r) * fact(n - r));
	}

	// Returns factorial of n
	private static int fact(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++)
			res = res * i;
		return res;
	}

}
