import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int t1 = 1; t1 <= t; t1++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Pair> pairs = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				pairs.add(new Pair(a[0], a[1], i));
			}
			Collections.sort(pairs);
			Stack<Pair> cameron = new Stack<>();
			Stack<Pair> jamie = new Stack<>();
			cameron.add(pairs.get(0));

			boolean f = true;
			for (int i = 1; i < n; i++) {
				Pair p1 = pairs.get(i);
//				System.out.println(p1.s + " " + p1.f);
				if (cameron.peek().f <= p1.s) {
					cameron.push(p1);
				} else if (jamie.isEmpty() || jamie.peek().f <= p1.s) {
					jamie.push(p1);
				} else {
					f = false;
					break;
				}
			}
			if (!f) {
				System.out.println(("Case #" + t1 + ": " + "IMPOSSIBLE"));
			} else {
				char[] ch = new char[n];
				while (!cameron.isEmpty()) {
					Pair p1 = cameron.pop();
					ch[p1.index] = 'C';
				}
				while (!jamie.isEmpty()) {
					Pair p1 = jamie.pop();
					ch[p1.index] = 'J';
				}
				System.out.println(("Case #" + t1 + ": " + new String(ch)));
			}
		}
	}

	static class Pair implements Comparable<Pair> {
		int s;
		int f;
		int index;

		public Pair(int s, int f, int index) {
			this.s = s;
			this.f = f;
			this.index = index;
		}

		@Override
		public int compareTo(Pair p) {
			if (this.f != p.f)
				return this.f - p.f;
			else if (this.s != p.s)
				return this.s - p.s;
			else
				return this.index - p.index;
		}

		@Override
		public String toString() {
			return "Pair [s=" + s + ", f=" + f + ", index=" + index + "]";
		}

	}
}
