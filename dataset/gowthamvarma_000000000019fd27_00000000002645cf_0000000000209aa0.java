import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	private static final boolean DEBUG = false;

	public static void main(String[] args) throws FileNotFoundException {
		long beginTime = System.nanoTime();
		InputStream is = DEBUG ? new FileInputStream("indicum.txt") : System.in;
		try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
			int testCount = scanner.nextInt();
			// System.out.println("testCount :: " + testCount);
			for (int testNumber = 1; testNumber <= testCount; testNumber++) {
				int n = scanner.nextInt();
				int k = scanner.nextInt();
				solve(testNumber, n, k);
			}
		}
		System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
	}

	private static void solve(int testNumber, int n, int k) {
		boolean result = false;

		int perm = factorial(2*n+1) / factorial(n);
		//System.out.println(perm);

		int[][] a = null;

		for (int magic = n; magic < perm + n; magic++) {
			a = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int v = (magic - i + j) % n + 1;
					a[i][j] = v;
				}
			}
			// System.out.println(Arrays.deepToString(a));
			int trace = getTrace(n, a);
			if (trace == k) {
				result = true;
				break;
			}
		}

		String resStr = result ? "POSSIBLE" : "IMPOSSIBLE";
		System.out.println("Case #" + testNumber + ": " + resStr);
		if (result) {
			for (int i = 0; i < n; i++) {
				String line = Arrays.stream(a[i]).mapToObj(String::valueOf).collect(Collectors.joining(" "));
				System.out.println(line);
			}
		}

	}

	private static int factorial(int num) {
		int factorial = 1;
		for (int i = 1; i <= num; ++i) {
			// factorial = factorial * i;
			factorial *= i;
		}
		return factorial;
	}

	private static int getTrace(int n, int[][] a) {
		int trace = 0;
		for (int i = 0; i < n; i++) {
			trace += a[i][i];
		}
		return trace;
	}

}
