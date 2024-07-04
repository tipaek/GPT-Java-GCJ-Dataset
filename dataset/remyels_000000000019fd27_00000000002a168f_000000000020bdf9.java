import java.util.*;
import java.io.*;

public class Solution {
	static int n;

	static Segment[] segments;
	
	static List<String> possibilities = new ArrayList<>();

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int t = console.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.print("Case #" + (i + 1) + ": ");
			n = console.nextInt();
			segments = new Segment[n];
			for (int j = 0; j < n; j++) {
				segments[j] = new Segment(console.nextInt(), console.nextInt(), j);
			}
			solve();
		}
	}

	public static void solve() {
		possibilities = new ArrayList<>();
		generateAll();
		outer: for (int i = 0; i<possibilities.size(); i++) {
			String cur = possibilities.get(i);
			boolean[] coccup = new boolean[24*60];
			boolean[] joccup = new boolean[24*60];
			for (int j = 0; j<cur.length(); j++) {
				if (cur.charAt(j) == 'C') {
					for (int k = segments[j].from; k<segments[j].to; k++) {
						if (coccup[k]) {
							continue outer;
						}
						coccup[k] = true;
					}
				}
				else {
					for (int k = segments[j].from; k<segments[j].to; k++) {
						if (joccup[k]) {
							continue outer;
						}
						joccup[k] = true;
					}
				}
			}
			System.out.println(cur);
			return;
		}
		System.out.println("IMPOSSIBLE");
	}

	public static void generateAll() {
		generateAll("");
	}
	
	public static void generateAll(String s) {
		if (s.length() == n) {
			possibilities.add(s);
			return;
		}
		generateAll(s+"C");
		generateAll(s+"J");
	}

	public static boolean canDo(Set<Segment> segs, Segment newseg) {
		for (Segment se : segs) {
			if (Math.max(se.from, newseg.from) < Math.min(se.to, newseg.to)) {
				return false;
			}
		}
		return true;
	}
}

class Segment {
	public int from;
	public int to;
	public int index;

	public Segment(int from, int to, int index) {
		this.from = from;
		this.to = to;
		this.index = index;
	}
}