import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = input.nextInt();
		for (int t = 1;t<=T;t++) {
			int N = input.nextInt();

			int[][] matrix = new int[N][N];

			for (int r = 0;r<N;r++) {
				for (int c=0;c<N;c++) {
					matrix[r][c] = input.nextInt();
				}
			}

			Solver s = new Solver(N, matrix);
			String ret = s.solve();

			System.out.println("Case #" + t + ": " + ret);
		}

		input.close();
	}

}

class Solver {
	int N;
	int[][] matrix;

	public Solver(int N, int[][] matrix){
		this.N = N;
		this.matrix = matrix;
	}

	public String solve(){
		Set<Integer>[] rSet = new HashSet[N];
		Set<Integer>[] cSet = new HashSet[N];

		for (int r=0;r<N;r++) {
			rSet[r] = new HashSet<>();
			cSet[r] = new HashSet<>();
		}

		int trace = 0;
		int rcount = 0;
		int ccount = 0;
		int[] raddFlag = new int[N];
		int[] caddFlag = new int[N];

		for (int r=0;r<N;r++) {
			for (int c=0;c<N;c++) {
				int val = matrix[r][c];

				if (r == c) {
					trace += val;
				}

				if (rSet[r].contains(val) && raddFlag[r] == 0) {
					rcount++;
					raddFlag[r]++;
				} else {
					rSet[r].add(val);
				}
				if (cSet[c].contains(val) && caddFlag[c] == 0) {
					ccount++;
					caddFlag[c]++;
				} else {
					cSet[c].add(val);
				}
			}
		}

		return trace + " " + rcount + " " + ccount;
	}
}