import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
	static class Tuple implements Comparable<Tuple> {
		int id;
		int start, end;
		boolean isJamie = true;

		Tuple(int id, String line) {
			this.id = id;
			String[] tokens = line.split(" ");
			start = Integer.parseInt(tokens[0]);
			end = Integer.parseInt(tokens[1]);
		}

		@Override
		public int compareTo(Tuple o) {
			if (o.start != this.start) {
				return Integer.compare(this.start, o.start);
			} else {
				return Integer.compare(this.end, o.end);
			}
		}
	}

	int T, N;
	List<Tuple> list;
	Deque<Tuple> jamie = new ArrayDeque<>();
	Deque<Tuple> cameron = new ArrayDeque<>();
	boolean possible = true;

	Solution(int T, BufferedReader in) throws Exception {
		this.T = T;
		this.N = Integer.parseInt(in.readLine());
		this.list = new ArrayList<>(N);
		for (int i = 0; i < N; ++i) {
			this.list.add(new Tuple(i, in.readLine()));
		}
		Collections.sort(this.list);
	}

	Deque<Tuple> getDeque(Tuple tuple) {
		if (jamie.isEmpty() && cameron.isEmpty()) {
			return jamie;
		} else if (cameron.isEmpty() && jamie.peekLast().end <= tuple.start) {
			return jamie;
		} else if (jamie.peekLast().end <= tuple.start) {
			return jamie;
		} else if (cameron.isEmpty()) {
			return cameron;
		} else if (!cameron.isEmpty() && cameron.peekLast().end <= tuple.start) {
			return cameron;
		} else {
			return null;
		}
	}

	void calc() {
		for (int i = 0; i < list.size(); ++i) {
			Deque<Tuple> deque = getDeque(list.get(i));
			if (deque == null) {
				this.possible = false;
				break;
			} else {
				deque.addLast(list.get(i));
			}
		}
		while (!this.cameron.isEmpty()) {
			Tuple t = this.cameron.pollFirst();
			t.isJamie = false;
		}
	}

	void show() {
		StringBuilder strBuilder = new StringBuilder();
		if (!this.possible) {
			strBuilder.append("IMPOSSIBLE");
		} else {
			Collections.sort(this.list, new Comparator<Tuple>() {
				@Override
				public int compare(Tuple o1, Tuple o2) {
					return Integer.compare(o1.id, o2.id);
				}
			});
			for (int i = 0; i < list.size(); ++i) {
				Tuple t = list.get(i);
				if (t.isJamie) {
					strBuilder.append("J");
				} else {
					strBuilder.append("C");
				}
			}
		}
		System.out.println("Case #" + this.T + ": " + strBuilder.toString());
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
