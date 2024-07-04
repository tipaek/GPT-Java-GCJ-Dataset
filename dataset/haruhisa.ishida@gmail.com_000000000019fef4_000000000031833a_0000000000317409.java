import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
	int T;
	int x, y;
	char[] s;
	int time = -1;

	Solution(int T, BufferedReader in) throws Exception {
		this.T = T;
		String[] tokens = in.readLine().split(" ");
		x = Integer.parseInt(tokens[0]);
		y = Integer.parseInt(tokens[1]);
		s = tokens[2].toCharArray();
	}

	void update(char c) {
		if (c == 'N') {
			++y;
		} else if (c == 'S') {
			--y;
		} else if (c == 'E') {
			++x;
		} else {
			--x;
		}
	}

	void calc() {
		for (int i = 0; i < s.length; ++i) {
			update(s[i]);
			if (Math.abs(x) + Math.abs(y) <= (i + 1)) {
				time = (i + 1);
				break;
			}
		}
	}

	void show() {
		if (time < 0) {
			System.out.println("Case #" + T + ": " + "IMPOSSIBLE");
		} else {
			System.out.println("Case #" + T + ": " + time);
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