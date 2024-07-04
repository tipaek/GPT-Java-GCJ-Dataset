import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int T = reader.nextInt();
		for (int t = 0; t < T; t++) {
			int N = reader.nextInt();
			List<Pair<Integer, Integer>> actsTrue = new ArrayList<Pair<Integer, Integer>>();
			List<Pair<Integer, Integer>> acts = new ArrayList<Pair<Integer, Integer>>();
			for (int i = 0; i < N; i++) {
				int st = reader.nextInt();
				int fin = reader.nextInt();
				acts.add(new Pair(st, fin,i));
				actsTrue.add(new Pair(st, fin,i));
			}

			String res = "";
			boolean cBusy = false;

			// sort by starting time
			Collections.sort(acts, new Comparator<Pair<Integer, Integer>>() {

				@Override
				public int compare(Pair<Integer, Integer> p0, Pair<Integer, Integer> p1) {
					return p0.first - p1.first;
				}

			});

			// do greddy assign
			int simc = 0;
			PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<Pair<Integer, Integer>>(
					new Comparator<Pair<Integer, Integer>>() {

						@Override
						public int compare(Pair<Integer, Integer> p0, Pair<Integer, Integer> p1) {
							return p0.second - p1.second;
						}

					});
			Map<Pair<Integer, Integer>, String> map = new HashMap<Pair<Integer, Integer>, String>();
			for (int i = 0; i < N; i++) {
				Pair<Integer, Integer> p = acts.get(i);
				Pair<Integer, Integer> p2;

				while (!q.isEmpty()) {
					p2 = q.peek();
					if (p2.second <= p.first) {
						q.poll();
						if (p2.C) {
							cBusy = false;
						}
					} else {
						break;
					}
				}
				if (!cBusy) {
					p.C = true;
					cBusy = true;
					map.put(p, "C");
				} else {
					map.put(p, "J");
				}
				q.add(p);
				if (q.size() > 2) {
					res = "IMPOSSIBLE";
					break;
				}
			}
			if (!res.equals("IMPOSSIBLE")) {
				for (int i = 0; i < N; i++) {
					Pair<Integer, Integer> p = actsTrue.get(i);
					res += map.get(p);
				}
			}
			System.out.printf("Case #%d: %s\n", t + 1, res);

		}

	}

}

class Pair<F, S> {
	public final F first;
	public final S second;
	public boolean C;
	int i;

	public Pair(F first, S second) {
		this.first = first;
		this.second = second;
	}
	
	public Pair(F first, S second, int i) {
		this.first = first;
		this.second = second;
		this.i=i;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Pair)) {
			return false;
		}
		Pair<?, ?> p = (Pair<?, ?>) o;
		return Objects.equals(p.first, first) && Objects.equals(p.second, second) && p.i == i;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + i;
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Pair{" + String.valueOf(first) + " " + String.valueOf(second) + "}";
	}

	public static <A, B> Pair<A, B> create(A a, B b) {
		return new Pair<A, B>(a, b);
	}
}
