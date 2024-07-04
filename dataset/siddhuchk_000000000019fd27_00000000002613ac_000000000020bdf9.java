import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int ca = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			Set<Pair> pairs = new TreeSet<>();
			for (int i = 0; i < n; i++) {
				String[] times = br.readLine().split("\\s+");
				int s = Integer.parseInt(times[0]);
				int e = Integer.parseInt(times[1]);
				Pair ps = new Pair(s, 's', i);
				Pair pe = new Pair(e, 'e', i);
				pairs.add(ps);
				pairs.add(pe);
			}

			// System.out.println(pairs);
			Map<Integer, Character> busy = new HashMap<>();
			List<Character> free = new ArrayList<>();
			free.add('C');
			free.add('J');
			boolean isPos = true;
			for (Pair p : pairs) {
				if (p.c == 's') {
					if (free.isEmpty()) {
						isPos = false;
						break;
					} else {
						char ch = free.remove(0);
						busy.put(p.i, ch);
					}
				} else {
					int index = p.i;
					char ch = busy.get(index);
					free.add(ch);
				}
			}
			if (!isPos) {
				System.out.println("Case #" + ca + ": IMPOSSIBLE");
			} else {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < n; i++) {
					sb.append(busy.get(i));
				}
				System.out.println("Case #" + ca + ": " + sb.toString());
			}
			ca++;
		}
	}
}

class Pair implements Comparable<Pair> {
	int t;
	char c;
	int i;

	public Pair(int t, char c, int i) {
		this.t = t;
		this.c = c;
		this.i = i;
	}

	@Override
	public int compareTo(Pair o) {
		if (this.t == o.t) {
			return this.c - o.c;
		} else {
			return this.t - o.t;
		}
	}

	@Override
	public String toString() {
		return "Pair [t=" + t + ", c=" + c + ", i=" + i + "]";
	}
}