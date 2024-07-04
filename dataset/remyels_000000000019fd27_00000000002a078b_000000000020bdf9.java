import java.util.*;
import java.io.*;

public class Solution {
	static int n;

	static Segment[] segments;

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
		Set<Integer> start = new HashSet<>();
		Set<Integer> end = new HashSet<>();
		Map<Integer, Segment> startToSegment = new HashMap<>();
		Map<Integer, Segment> endToSegment = new HashMap<>();
		boolean cFree = true;
		Set<Segment> cSegments = new HashSet<>();
		Set<Segment> jSegments = new HashSet<>();
		boolean jFree = true;
		Map<Integer, Character> startToActive = new HashMap<>();
		for (Segment s : segments) {
			start.add(s.from);
			end.add(s.to);
			startToSegment.put(s.from, s);
			endToSegment.put(s.to, s);
		}
		for (int i = 0; i <= 24 * 60; i++) {
			if (end.contains(i)) {
				char responsible = startToActive.get(endToSegment.get(i).from);
				if (responsible == 'C') {
					cFree = true;
				} else {
					jFree = true;
				}
			}
			if (start.contains(i)) {
				if (cFree && canDo(cSegments, startToSegment.get(i))) {
					cFree = false;
					cSegments.add(startToSegment.get(i));
					startToActive.put(i, 'C');
				} else if (jFree && canDo(jSegments, startToSegment.get(i))) {
					jFree = false;
					jSegments.add(startToSegment.get(i));
					startToActive.put(i, 'J');
				} else {
					System.out.println("IMPOSSSIBLE");
					return;
				}
			}
		}
		char[] res = new char[n];
		for (Segment s : cSegments) {
			res[s.index] = 'C';
		}
		for (Segment s : jSegments) {
			res[s.index] = 'J';
		}
		System.out.println(res);
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