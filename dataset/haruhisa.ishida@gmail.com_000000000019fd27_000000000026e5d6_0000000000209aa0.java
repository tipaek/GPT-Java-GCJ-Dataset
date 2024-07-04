import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
	int T, N, K;
	boolean possible = true;
	List<String> lines;

	Solution(int T, BufferedReader in) throws Exception {
		this.T = T;
		String[] tokens = in.readLine().split(" ");
		this.N = Integer.parseInt(tokens[0]);
		this.K = Integer.parseInt(tokens[1]);
	}

	String getLine(int startVal) {
		StringBuilder strBuilder = new StringBuilder();
		int val = startVal % N;
		if (val == 0) {
			val += N;
		}
		strBuilder.append(val);
		for (int i = 1; i < N; ++i) {
			strBuilder.append(" ");
			val = (val + 1) % N;
			if (val == 0) {
				val = N;
			}
			strBuilder.append(Integer.toString(val));
		}
		return strBuilder.toString();
	}

	void calc() {
		if (K % N != 0) {
			this.possible = false;
			return;
		}
		this.lines = new ArrayList<>(N);
		int startVal = K / N;
		for (int i = 0; i < N; ++i) {
			this.lines.add(getLine(startVal));
			startVal--;
			if (startVal == 0) {
				startVal += N;
			}
		}
	}

	void show() {
		if (this.possible) {
			System.out.println("Case #" + this.T + ": " + "POSSIBLE");
			for (int i = 0; i < this.lines.size(); ++i) {
				System.out.println(this.lines.get(i));
			}
		} else {
			System.out.println("Case #" + this.T + ": " + "IMPOSSIBLE");
		}

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