//package code;
import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int K;
	static int[][] matrix;
	static int[] buf;
	static int delta;
	static int swaps;
	static int calcs;

	static int calcSwappedDiagonal(int src, int dst) {
		int k = 0;
		++calcs;
		for (int d = 0; d < N; ++d) {
			final int D = (d == src)? dst: (d == dst? src: d);
			k += matrix[D][d];
		}
		return Math.abs(K - k);
	}

	static boolean swap(int src, int dst) {
		final int newDelta = calcSwappedDiagonal(src, dst);
		if (newDelta < delta) {
			++swaps;
			System.arraycopy(matrix[src], 0, buf, 0, buf.length);
			System.arraycopy(matrix[dst], 0, matrix[src], 0, buf.length);
			System.arraycopy(buf, 0, matrix[dst], 0, buf.length);
			delta = newDelta;
			return true;
		} else {
			return false;
		}
	}

	static boolean optimize() {
		boolean newSolution = false;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (i != j && swap(i, j)) newSolution = true;
			}
		}
		return newSolution;
	}
	static void case5(Scanner in, int caseNum) {
		N = in.nextInt();
		K = in.nextInt();
		swaps = 0;
		calcs = 0;
		matrix = new int[N][N];
		buf = new int[N];
		boolean isOk = false;

		int start = N;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (start > N) start -= N;
				matrix[i][j] = start++;
			}
			start--;
		}

		StringBuilder row = new StringBuilder();
/*
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				row.append(matrix[i][j]).append(' ');
			}
			System.out.println(row.toString());
			row.setLength(0);
		}
*/

		delta = 0;
		for (int d = 0; d < N; ++d) delta += matrix[d][d];
		delta = Math.abs(K - delta);

		if (delta == 0) isOk = true;
		else {
//			System.out.println("swaps: " + swaps + ", calcs: " + calcs + ", delta: " + delta);
			while (optimize()) ;
			if (delta == 0) isOk = true;
		}

		System.out.println("Case #" + caseNum + ": " + (isOk? "POSSIBLE": "IMPOSSIBLE"));
//		System.out.println("swaps: " + swaps + ", calcs: " + calcs + ", delta: " + delta);
		if (!isOk) return;

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				row.append(matrix[i][j]).append(' ');
			}
			System.out.println(row.toString());
			row.setLength(0);
		}
	}

	public static void main(String[] args) {
		try {
			FileInputStream is = new FileInputStream(new File("/Users/apc/Desktop/Jam2020/src/main/java/code/test.in"));
			System.setIn(is);
		}
		catch (Throwable ignored) {}

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

		for (int i = 1; i <= t; ++i) {
			case5(in, i);
		}
	}
}
