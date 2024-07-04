import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

	private static String process(Scanner in) {
		int N = in.nextInt();
		int[][] M = new int[N][N];
		long vestigium = 0;
		int badRows = 0;
		int badCols = 0;
		for(int i = 0; i < N; i++) {
			int[] cache = new int[N+1];
			boolean bad = false;
			for(int j = 0; j < N; j++) {
				M[i][j] = in.nextInt();
				if (cache[M[i][j]]++ > 0)
					bad = true;
				if (i == j)
					vestigium += M[i][j];
			}
			if (bad)
				badRows++;
		}
		for(int j = 0; j < N; j++) {
			int[] cache = new int[N+1];
			boolean bad = false;
			for(int i = 0; i < N; i++) {
				if (cache[M[i][j]]++ > 0)
					bad = true;
			}
			if (bad)
				badCols++;
		}
		return vestigium + " " + badRows + " " + badCols;
	}

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in.available() > 0 ? System.in : 
			new FileInputStream(Thread.currentThread().getStackTrace()[1].getClassName() + ".practice.in"));
		int T = in.nextInt();
		for(int i = 1; i <= T; i++) 
			System.out.format("Case #%d: %s\n", i, process(in));
	}
}