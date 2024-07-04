import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
	int T;
	int U;
	List<Tuple> list;
	Map<Long, List<Tuple>> map;
	char[] D;

	static class Tuple {
		int id;
		long m;
		String s;
	}

	Solution(int T, BufferedReader in) throws Exception {
		this.T = T;
		U = Integer.parseInt(in.readLine());
		list = new ArrayList<>(10000);
		for (int i = 0; i < 10000; ++i) {
			String[] tokens = in.readLine().split(" ");
			Tuple tuple = new Tuple();
			tuple.id = i;
			tuple.m = Long.parseLong(tokens[0]);
			tuple.s = tokens[1];
			list.add(tuple);
		}

		map = new HashMap<>();
		for (Tuple tuple : list) {
			if (!map.containsKey(tuple.m)) {
				map.put(tuple.m, new ArrayList<>());
			}
			map.get(tuple.m).add(tuple);
		}
		D = new char[10];
	}

	void calc() {
		// 1ã¯ç¢ºå®š
		D[1] = map.get(1L).get(0).s.charAt(0);
		Set<Character> set = new HashSet<>();
		set.add(D[1]);
		for (long val = 2; val <= 9; ++val) {
			for (Tuple tuple : map.get(val)) {
				Character c = tuple.s.charAt(0);
				if (!set.contains(c)) {
					set.add(c);
					D[(int) val] = c;
					break;
				}
			}
		}
		// 10ã¯2æ–‡å­—ã®ã‚‚ã®ã‚’è¦‹ã¤ã‘ã‚‹
		for (Tuple tuple : map.get(10L)) {
			if (tuple.s.length() >= 2) {
				D[0] = tuple.s.charAt(1);
				break;
			}
		}
	}

	void show() {
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < 10; ++i) {
			strBuilder.append(D[i]);
		}
		System.out.println("Case #" + T + ": " + strBuilder.toString());
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
