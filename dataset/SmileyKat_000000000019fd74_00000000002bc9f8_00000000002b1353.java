import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private static long[] P2 = new long[31];

	private static String solve(long N) {
		List<int[]> path = new ArrayList<>();
		int p = -1;
		for (int i = P2.length - 1; p < 0 && i >= 0; --i) {
			if (N >= P2[i]) p = i;
		}
		boolean left = true;
		appendRow(path, p, left);
		left = !left;
		N -= P2[p];
		for (int i = p - 1; N > 0 && i >= 0; --i) {
			if (N >= P2[i]) {
				appendRow(path, i, left);
				left = !left;
				N -= P2[i];
			} else {
				if (left) path.add(new int[] {i + 1, 1});
				else path.add(new int[] {i + 1, i + 1});
				--N;
			}
		}
		if (N > 0) {
			Collections.reverse(path);
			int r = p + 1;
			for (int i = 0; i < N; ++i) {
				path.add(new int[] {r + 1, r + 1});
				++r;
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
			for (int i = r; i >= 0; --i) path.add(new int[] {r, i});
		}
	}

	public static void main(String[] args) {
		P2[0] = 1;
		for (int i = 1; i < P2.length; ++i) P2[i] = 2 * P2[i - 1];

		Scanner sc = new Scanner(System.in);
		int numTest = sc.nextInt();
		for (int test = 1; test <= numTest; ++test) {
			long N = sc.nextLong();
			System.out.printf("Case #%d:\n%s", test, solve(N));
		}
		sc.close();
	}

}
