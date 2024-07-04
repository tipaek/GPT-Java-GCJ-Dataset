import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
	int T;
	long X, Y;
	boolean enable = true;
	List<Long> xOrigins = null, yOrigins = null;

	Solution(int T, BufferedReader in) throws Exception {
		this.T = T;
		String[] tokens = in.readLine().split(" ");
		X = Long.parseLong(tokens[0]);
		Y = Long.parseLong(tokens[1]);
		this.enable = check();
	}

	boolean check() {
		if ((X + Y) % 2 == 0) {
			return false;
		} else {
			return true;
		}
	}

	List<Long> getBases(long val) {
		List<Long> list = new ArrayList<>();
		long base = 1;
		while (base <= val) {
			list.add(base);
			base *= 2;
		}
		Collections.reverse(list);

		List<Long> result = new ArrayList<>();
		result.add(list.get(0));
		long v = list.get(0);
		for (int i = 1; i < list.size(); ++i) {
			if (v < val) {
				result.add(list.get(i));
				v += list.get(i);
			} else {
				result.add(-1 * list.get(i));
				v -= list.get(i);
			}
		}
		return result;
	}

	List<Long>[] getOrigins(long val, List<Long> bases) {
		long v = bases.get(0);
		List<Long>[] result = new List[2];
		result[0] = new ArrayList<Long>();
		result[1] = new ArrayList<Long>();
		result[0].add(v);
		for (int i = 1; i < bases.size(); ++i) {
			long currentDiff = Math.abs(v - val);
			long nextDiff = Math.abs(v + bases.get(i) - val);
			if (currentDiff > nextDiff) {
				result[0].add(bases.get(i));
				v += bases.get(i);
			} else {
				result[1].add(bases.get(i));
			}
		}
		return result;
	}

	void calc() {
		if (!enable) {
			return;
		}
		List<Long> bases = getBases(Math.abs(X) + Math.abs(Y));
		if (Math.abs(X) > Math.abs(Y)) {
			List<Long>[] list = getOrigins(Math.abs(X), bases);
			xOrigins = list[0];
			yOrigins = list[1];
		} else {
			List<Long>[] list = getOrigins(Math.abs(Y), bases);
			xOrigins = list[1];
			yOrigins = list[0];
		}
		if (X < 0) {
			List<Long> list = new ArrayList<>();
			for (int i = 0; i < xOrigins.size(); ++i) {
				list.add(xOrigins.get(i) * -1);
			}
			xOrigins = list;
		}
		if (Y < 0) {
			List<Long> list = new ArrayList<>();
			for (int i = 0; i < yOrigins.size(); ++i) {
				list.add(yOrigins.get(i) * -1);
			}
			yOrigins = list;
		}
		Collections.reverse(xOrigins);
		Collections.reverse(yOrigins);
	}

	String toStr() {
		Deque<Long> xQue = new ArrayDeque<>();
		xQue.addAll(xOrigins);
		Deque<Long> yQue = new ArrayDeque<>();
		yQue.addAll(yOrigins);
		StringBuilder strBuilder = new StringBuilder();
		while (!xQue.isEmpty() || !yQue.isEmpty()) {
			if (!xQue.isEmpty() && !yQue.isEmpty()) {
				if (Math.abs(xQue.peek()) < Math.abs(yQue.peek())) {
					long x = xQue.poll();
					if (x > 0) {
						strBuilder.append("E");
					} else {
						strBuilder.append("W");
					}
				} else {
					long y = yQue.poll();
					if (y > 0) {
						strBuilder.append("N");
					} else {
						strBuilder.append("S");
					}
				}
			} else if (!xQue.isEmpty()) {
				long x = xQue.poll();
				if (x > 0) {
					strBuilder.append("E");
				} else {
					strBuilder.append("W");
				}
			} else {
				long y = yQue.poll();
				if (y > 0) {
					strBuilder.append("N");
				} else {
					strBuilder.append("S");
				}
			}
		}
		return strBuilder.toString();
	}

	void show() {
		if (!enable) {
			System.out.println("Case #" + T + ": IMPOSSIBLE");
		} else {
			System.out.println("Case #" + T + ": " + toStr());
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