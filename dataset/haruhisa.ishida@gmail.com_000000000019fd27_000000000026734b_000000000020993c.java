import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
	int T;
	int N;
	int[][] M;
	int trace = 0, rowRepeat = 0, colRepeat = 0;

	Solution(int T, BufferedReader in) throws Exception {
		this.T = T;
		this.N = Integer.parseInt(in.readLine());
		this.M = new int[N][N];
		for (int i = 0; i < N; ++i) {
			String[] tokens = in.readLine().split(" ");
			for (int j = 0; j < N; ++j) {
				this.M[i][j] = Integer.parseInt(tokens[j]);
			}
		}
	}

	boolean isRowRepeat(int rowNo) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; ++i) {
			if (set.contains(this.M[rowNo][i])) {
				return true;
			}
			set.add(this.M[rowNo][i]);
		}
		return false;
	}

	boolean isColRepeat(int colNo) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; ++i) {
			if (set.contains(this.M[i][colNo])) {
				return true;
			}
			set.add(this.M[i][colNo]);
		}
		return false;
	}

	void calc() {
		for (int i = 0; i < N; ++i) {
			this.trace += this.M[i][i];
		}
		for (int i = 0; i < N; ++i) {
			if (this.isRowRepeat(i)) {
				this.rowRepeat++;
			}
		}
		for (int i = 0; i < N; ++i) {
			if (this.isColRepeat(i)) {
				this.colRepeat++;
			}
		}
	}

	void show() {
		System.out.println("Case #" + this.T + ": " + this.trace + " " + this.rowRepeat + " " + this.colRepeat);
	}

	public static void main(String[] args) throws Exception {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		int T = Integer.parseInt(in.readLine());
		for (int i = 1; i <= T; ++i) {
			Solution sol = new Solution(i, in);
			sol.calc();
			sol.show();
		}

		in.close();

	}
}
