import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
	int T;
	String str;
	int currentDepth = 0;
	String result;

	Solution(int T, BufferedReader in) throws Exception {
		this.T = T;
		this.str = in.readLine();
	}

	String toStr(int val) {
		if (currentDepth == val) {
			return Integer.toString(val);
		} else if (currentDepth < val) {
			StringBuilder strBuilder = new StringBuilder();
			for (int i = currentDepth; i < val; ++i) {
				strBuilder.append("(");
			}
			strBuilder.append(Integer.toString(val));
			currentDepth = val;
			return strBuilder.toString();
		} else {
			StringBuilder strBuilder = new StringBuilder();
			for (int i = currentDepth; i > val; --i) {
				strBuilder.append(")");
			}
			strBuilder.append(Integer.toString(val));
			currentDepth = val;
			return strBuilder.toString();
		}
	}

	void calc() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(toStr(0));
		for (int i = 0; i < str.length(); ++i) {
			int val = Integer.parseInt(str.substring(i, i + 1));
			strBuilder.append(toStr(val));
		}
		strBuilder.append(toStr(0));
		String S = strBuilder.toString();
		result = S.substring(1, S.length() - 1);
	}

	void show() {
		System.out.println("Case #" + this.T + ": " + result);
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
