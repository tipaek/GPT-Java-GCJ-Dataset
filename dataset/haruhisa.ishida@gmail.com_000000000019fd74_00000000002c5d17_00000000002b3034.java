import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
	static class Tuple {
		int x, y;

		Tuple(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Match {
		String longStr, shortStr;
		boolean match[][];
		Deque<Tuple> deque;

		Match(String A, String B) {
			if (A.length() > B.length()) {
				this.longStr = A;
				this.shortStr = B;
			} else {
				this.longStr = B;
				this.shortStr = A;
			}
			this.match = new boolean[shortStr.length()][longStr.length()];
			for (int i = 0; i < match.length; ++i) {
				Arrays.fill(match[i], false);
			}
			for (int i = 0; i < shortStr.length(); ++i) {
				char s = shortStr.charAt(i);
				for (int j = 0; j < longStr.length(); ++j) {
					char l = longStr.charAt(j);
					if (s == l) {
						match[i][j] = true;
					} else if (s == '*' || l == '*') {
						match[i][j] = true;
					} else {
						match[i][j] = false;
					}
				}
			}
			deque = search(shortStr.length() - 1, longStr.length() - 1);
		}

		String getMatchStr() {
			if (deque == null) {
				return null;
			} else {
				StringBuilder strBuilder = new StringBuilder();
				while (!deque.isEmpty()) {
					Tuple tuple = deque.pollFirst();
					char s = shortStr.charAt(tuple.x);
					char l = longStr.charAt(tuple.y);
					if (s == '*' && l == '*') {
						strBuilder.append('*');
					} else if (s == '*') {
						strBuilder.append(l);
					} else {
						strBuilder.append(s);
					}
				}
				return strBuilder.toString();
			}
		}

		Deque<Tuple> search(int x, int y) {
			if (x == 0 && y == 0) {
				if (match[x][y]) {
					Deque<Tuple> deque = new ArrayDeque<>();
					deque.addFirst(new Tuple(0, 0));
					return deque;
				} else {
					return null;
				}
			} else {
				if (match[x][y]) {
					Deque<Tuple> next = null;
					if (x > 0 && y > 0) {
						Deque<Tuple> deq = search(x - 1, y - 1);
						if (deq != null) {
							next = deq;
						}
					}
					if (x > 0) {
						Deque<Tuple> deq = search(x - 1, y);
						if (deq != null) {
							if (next == null) {
								next = deq;
							} else {
								next = next.size() > deq.size() ? deq : next;
							}
						}
					}
					if (y > 0) {
						Deque<Tuple> deq = search(x, y - 1);
						if (deq != null) {
							if (next == null) {
								next = deq;
							} else {
								next = next.size() > deq.size() ? deq : next;
							}
						}
					}
					if (next != null) {
						next.addLast(new Tuple(x, y));
						return next;
					} else {
						return null;
					}
				} else {
					return null;
				}
			}
		}
	}

	int T, N;
	List<String> list;
	boolean result = true;
	String resultStr = null;

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

	void calc() {
		Match match = new Match(list.get(0), list.get(1));
		String str = match.getMatchStr();
		resultStr = str;
		for (int i = 2; i < list.size(); ++i) {
			if (str == null) {
				System.out.println("null");
				result = false;
				break;
			} else {
				match = new Match(str, list.get(i));
				str = match.getMatchStr();
			}
		}
		resultStr = str;
	}

	String removeAster(String s) {
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) != '*') {
				strBuilder.append(s.charAt(i));
			}
		}
		return strBuilder.toString();
	}

	void show() {

		resultStr = resultStr != null ? removeAster(resultStr) : "*";
		System.out.println("Case #" + T + ": " + resultStr);
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