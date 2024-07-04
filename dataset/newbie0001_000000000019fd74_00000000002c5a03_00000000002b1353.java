import java.util.*;
import java.io.*;
import static java.lang.System.out;

/**
 * create a static pascal triangle [][]
 * 
 * ? when go vertical ?
 * ? when go horizontal ?
 */ 
public class Solution {

	private static Scanner sc;
	
	private static final int MAX_ROWS = 100;
	private static int[][] tri = createPascalTriangle(MAX_ROWS);

	private static Path[] path = new Path[501];
	

	public static int[][] createPascalTriangle(int rows) {
		int[][] tri = new int[rows+1][rows+1];

		for (int i = 1; i < tri.length; i++) {
			tri[i][1] = 1;
			for (int j = 2; j <= i; j++) {
				if (j == tri.length - 1) {
					tri[i][j] = 1;
				} else {
					tri[i][j] = tri[i-1][j-1] + tri[i-1][j];
				}
			}
		}

		return tri;
	}
	
	public static void main(String[] args) throws Exception {

		for (int i = 0; i < path.length; i++) {
			path[i] = new Path(0, 0);
		}
		
		sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; ++t) {
			solve(t);			
		}
		
		sc.close();
	}
	
	private static void solve(int t) {

		int N = sc.nextInt();

		int walk_count = 1;
		path[walk_count].set(1, 1);		
		int sum = 1;
		
		if (sum == N) {
			printAnswer(t, path, walk_count); return;
		}

		int r = 1;
		int k = 1;
		while (true) {
			++r;
			if (r == MAX_ROWS) {
				System.err.println("must go different way");
				--r;
			}

			++walk_count;
			path[walk_count].set(r, k);

			// must go back and take a different path
			if (tri[r][k] + sum > N) {

			}

			if (tri[r][k] + sum == N) {
				printAnswer(t, path, walk_count); return;
			}

			// must go back and take a different path
			if (walk_count == 500) {
				System.exit(-1);
			}
			
			++k;
		}
	}


	private static void printAnswer(int t, Path[] path, int walk_count) {
		out.printf("Case #%d:\n", t);
		for (int i = 1; i <= walk_count; i++) {
			out.printf("%d %d\n", path[i].r, path[i].k);
		}
	}

	private static class Path {
		int r, k;

		void set(int r, int k) {
			this.r = r;
			this.k = k;
		}

		Path(int r, int k) {
			this.r = r;
			this.k = k;
		}

		@Override
		public String toString() {
			return r + " " + k;
		}
	}
}
