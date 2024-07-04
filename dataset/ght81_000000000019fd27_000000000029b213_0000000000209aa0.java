import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
			for (int testCases = in.nextInt(), testCase = 1; testCase <= testCases; testCase++) {
				int[][] a = solve(in.nextInt(), in.nextInt());
				out.println("Case #" + testCase + ": " + (a.length == 0 ? "IMPOSSIBLE" : "POSSIBLE"));
				for (int i = 0; i < a.length; i++) {
					for (int j = 0; j < a.length; j++) {
						out.print(a[i][j] + " ");
					}
					out.println();
				}
			}
		}
	}

	private static int[][] solve(int n, int k) {
		final int[][] noans = new int[0][];
		if (n > 5) {
			return noans;
		}
		switch (n) {
		case 2:
			switch (k) {
			case 2:
				return new int[][] { { 1, 2 }, { 2, 1 } };

			case 3:
				return noans;

			case 4:
				return new int[][] { { 2, 1 }, { 1, 2 } };

			}

		case 3:
			switch (k) {
			case 4:
			case 5:
			case 7:
			case 8:
				return noans;

			case 3:
				return new int[][] { { 1, 2, 3 }, { 3, 1, 2 }, { 2, 3, 1 } };

			case 6:
				return new int[][] { { 2, 3, 1 }, { 1, 2, 3 }, { 3, 1, 2 } };

			case 9:
				return new int[][] { { 3, 1, 2 }, { 2, 3, 1 }, { 1, 2, 3 } };

			}

		case 4:
			if (k % 2 == 1) {
				return noans;
			}
			switch (k) {
			case 4:
				return new int[][] { { 1, 2, 3, 4 }, { 4, 1, 2, 3 }, { 3, 4, 1, 2 }, { 2, 3, 4, 1 } };

			case 6:
				return new int[][] { { 1, 2, 3, 4 }, { 2, 1, 4, 3 }, { 3, 4, 2, 1 }, { 4, 3, 1, 2 } };

			case 8:
				return new int[][] { { 2, 3, 4, 1 }, { 1, 2, 3, 4 }, { 4, 1, 2, 3 }, { 3, 4, 1, 2 } };

			case 10:
				return new int[][] { { 1, 4, 3, 2 }, { 4, 1, 2, 3 }, { 3, 2, 4, 1 }, { 2, 3, 1, 4 } };

			case 12:
				return new int[][] { { 3, 4, 1, 2 }, { 2, 3, 4, 1 }, { 1, 2, 3, 4 }, { 4, 1, 2, 3 } };

			case 14:
				return new int[][] { { 3, 4, 1, 2 }, { 4, 3, 2, 1 }, { 1, 2, 4, 3 }, { 2, 1, 3, 4 } };

			case 16:
				return new int[][] { { 4, 1, 2, 3 }, { 3, 4, 1, 2 }, { 2, 3, 4, 1 }, { 1, 2, 3, 4 } };

			}
			;

		case 5:
			if (k == 6 || k == 24) {
				return noans;
			}
			switch (k) {
			case 5:
				return new int[][] { { 1, 2, 3, 4, 5 }, { 5, 1, 2, 3, 4 }, { 4, 5, 1, 2, 3 }, { 3, 4, 5, 1, 2 },
						{ 2, 3, 4, 5, 1 } };

			case 10:
				return new int[][] { { 2, 3, 4, 5, 1 }, { 1, 2, 3, 4, 5 }, { 5, 1, 2, 3, 4 }, { 4, 5, 1, 2, 3 },
						{ 3, 4, 5, 1, 2 } };

			case 15:
				return new int[][] { { 3, 4, 5, 1, 2 }, { 2, 3, 4, 5, 1 }, { 1, 2, 3, 4, 5 }, { 5, 1, 2, 3, 4 },
						{ 4, 5, 1, 2, 3 } };

			case 20:
				return new int[][] { { 4, 5, 1, 2, 3 }, { 3, 4, 5, 1, 2 }, { 2, 3, 4, 5, 1 }, { 1, 2, 3, 4, 5 },
						{ 5, 1, 2, 3, 4 } };

			case 25:
				return new int[][] { { 5, 1, 2, 3, 4 }, { 4, 5, 1, 2, 3 }, { 3, 4, 5, 1, 2 }, { 2, 3, 4, 5, 1 },
						{ 1, 2, 3, 4, 5 } };

			case 7:
				return new int[][] { { 2, 1, 3, 4, 5 }, { 1, 2, 4, 5, 3 }, { 3, 5, 1, 2, 4 }, { 4, 3, 5, 1, 2 },
						{ 5, 4, 2, 3, 1 } };

			case 8:
				return new int[][] { { 1, 2, 3, 4, 5 }, { 2, 1, 4, 5, 3 }, { 3, 5, 2, 1, 4 }, { 4, 3, 5, 2, 1 },
						{ 5, 4, 1, 3, 2 } };

			case 9:
				return new int[][] { { 3, 1, 2, 4, 5 }, { 1, 3, 4, 5, 2 }, { 2, 5, 1, 3, 4 }, { 4, 2, 5, 1, 3 },
						{ 5, 4, 3, 2, 1 } };

			case 11:
				return new int[][] { { 4, 1, 3, 2, 5 }, { 1, 4, 2, 5, 3 }, { 3, 5, 1, 4, 2 }, { 2, 3, 5, 1, 4 },
						{ 5, 2, 4, 3, 1 } };

			case 12:
				return new int[][] { { 3, 2, 1, 4, 5 }, { 2, 3, 4, 5, 1 }, { 1, 5, 2, 3, 4 }, { 4, 1, 5, 2, 3 },
						{ 5, 4, 3, 1, 2 } };

			case 13:
				return new int[][] { { 5, 1, 3, 4, 2 }, { 1, 5, 4, 2, 3 }, { 3, 2, 1, 5, 4 }, { 4, 3, 2, 1, 5 },
						{ 2, 4, 5, 3, 1 } };

			case 14:
				return new int[][] { { 4, 2, 3, 1, 5 }, { 2, 4, 1, 5, 3 }, { 3, 5, 2, 4, 1 }, { 1, 3, 5, 2, 4 },
						{ 5, 1, 4, 3, 2 } };

			case 16:
				return new int[][] { { 5, 2, 3, 4, 1 }, { 2, 5, 4, 1, 3 }, { 3, 1, 2, 5, 4 }, { 4, 3, 1, 2, 5 },
						{ 1, 4, 5, 3, 2 } };

			case 17:
				return new int[][] { { 4, 3, 1, 2, 5 }, { 3, 4, 2, 5, 1 }, { 1, 5, 3, 4, 2 }, { 2, 1, 5, 3, 4 },
						{ 5, 2, 4, 1, 3 } };

			case 18:
				return new int[][] { { 3, 4, 1, 2, 5 }, { 4, 3, 2, 5, 1 }, { 1, 5, 4, 3, 2 }, { 2, 1, 5, 4, 3 },
						{ 5, 2, 3, 1, 4 } };

			case 19:
				return new int[][] { { 5, 3, 1, 4, 2 }, { 3, 5, 4, 2, 1 }, { 1, 2, 3, 5, 4 }, { 4, 1, 2, 3, 5 },
						{ 2, 4, 5, 1, 3 } };

			case 21:
				return new int[][] { { 3, 5, 1, 4, 2 }, { 5, 3, 4, 2, 1 }, { 1, 2, 5, 3, 4 }, { 4, 1, 2, 5, 3 },
						{ 2, 4, 3, 1, 5 } };

			case 22:
				return new int[][] { { 5, 4, 3, 1, 2 }, { 4, 5, 1, 2, 3 }, { 3, 2, 4, 5, 1 }, { 1, 3, 2, 4, 5 },
						{ 2, 1, 5, 3, 4 } };

			case 23:
				return new int[][] { { 4, 5, 3, 1, 2 }, { 5, 4, 1, 2, 3 }, { 3, 2, 5, 4, 1 }, { 1, 3, 2, 5, 4 },
						{ 2, 1, 4, 3, 5 } };

			}

		}
		return noans;
	}

}
