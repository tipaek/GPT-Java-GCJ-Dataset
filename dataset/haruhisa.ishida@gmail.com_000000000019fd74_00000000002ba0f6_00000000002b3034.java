import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
	int T;
	int N;
	List<String> list;
	boolean result = true;

	Solution(int T, BufferedReader in) throws Exception {
		this.T = T;
		this.N = Integer.parseInt(in.readLine());
		this.list = new ArrayList<>(N);
		for (int i = 0; i < N; ++i) {
			list.add(in.readLine());
		}
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -1 * Integer.compare(o1.length(), o2.length());
			}
		});
	}

	String fixStr(String str, int length) {
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) != '*') {
				strBuilder.append(str.charAt(i));
			} else {
				for (int j = 0; j < length * 2 - str.length(); ++j) {
					strBuilder.append('*');
				}
			}
		}
		return strBuilder.toString();
	}

	boolean match(String A, String B) {
		boolean result = true;
		for (int i = 0; i < A.length(); ++i) {
			char a = A.charAt(i);
			char b = B.charAt(i);
			if (a == b) {
				result = true;
			} else if (a == '*' || b == '*') {
				result = true;
			} else {
				result = false;
				break;
			}
		}
		return result;
	}

	void calc() {
		List<String> strs = new ArrayList<>(N);
		for (int i = 0; i < list.size(); ++i) {
			strs.add(fixStr(list.get(i), list.get(0).length()));
		}
		for (int i = 1; i < strs.size(); ++i) {
			result = match(strs.get(0), strs.get(i));
			if (!result) {
				break;
			}
		}
		this.list = strs;
	}

	String getResultStr() {
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < list.get(0).length(); ++i) {
			char c = '*';
			for (int j = 0; j < list.size(); ++j) {
				if (list.get(j).charAt(i) != '*') {
					c = list.get(j).charAt(i);
					break;
				}
			}
			if (c != '*') {
				strBuilder.append(c);
			}
		}
		return strBuilder.toString();
	}

	void show() {
		if (result) {
			System.out.println("Case #" + T + ": " + getResultStr());
		} else {
			System.out.println("Case #" + T + ": " + "*");
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
