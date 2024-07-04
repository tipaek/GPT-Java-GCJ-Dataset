import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private static long[] P2 = new long[31];

	private static String solve(long N) {
		List<int[]> path = new ArrayList<>();
		boolean left = true;
		for (int i = 0; N > 0 && i < P2.length; ++i) {
			if (N >= P2[i]) {
				appendRow(path, i, left);
				left = !left;
				N -= P2[i];
			} else {
				if (left) path.add(new int[] {i + 1,  1});
				else path.add(new int[] {i + 1,  i + 1});
				--N;
			}
		}
		if (N > 0) {
			int j = P2.length + 1;
			for (int i = 0; i < N; ++i) {
				if (left) path.add(new int[] {j + i + 1, 1});
				else path.add(new int[] {j + i + 1, j + 1});
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int[] x : path) sb.append(x[0]).append(' ').append(x[1]).append('\n');
		return sb.toString();
	}

	private static void appendRow(List<int[]> path, int r, boolean left) {
		++r;
		if (left) {
			for (int i = 1; i <= r; ++i) path.add(new int[] {r, i});
		} else {
			for (int i = r; i >= 1; --i) path.add(new int[] {r, i});
		}
	}

	public static void main(String[] args) {
		P2[0] = 1;
		for (int i = 1; i < P2.length; ++i) P2[i] = 2 * P2[i - 1];

		Scanner sc = new Scanner(System.in);
		int numTest = sc.nextInt();
		for (int test = 1; test <= numTest; ++test) {
			long N = sc.nextLong();
			System.out.printf("Case #%d:\n%s\n", test, solve(N));
		}
		sc.close();
	}

}
