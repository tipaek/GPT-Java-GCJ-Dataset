import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = in.nextInt();
			Interval[] times = new Interval[n];
			for (int i = 0; i < n; i++)
				times[i] = new Interval(in.nextInt(), in.nextInt(), i);
			Interval[] otimes = times.clone();
			Arrays.sort(times);
			Interval cl = times[0], jl = times[1];
			StringBuilder str = new StringBuilder(new String(new char[n]).replace("\0", " "));
			str.setCharAt(times[0].i, 'C');
			str.setCharAt(times[1].i, 'J');
			for (int i = 2; i < n; i++) {
				int time = times[i].s;
				if (cl.e <= time) {
					str.setCharAt(times[i].i, 'C');
					cl = times[i];
				} else if (jl.e <= time) {
					str.setCharAt(times[i].i, 'J');
					jl = times[i];
				} else {
					str = new StringBuilder("IMPOSSIBLE");
					break;
				}
			}
			
			System.out.println("Case #" + t + ": " + str);
		}
	}
}

class Interval implements Comparable<Interval> {
	int s, e, i;
	public Interval(int a, int b, int c) { s = a; e = b; i = c; }
	public int compareTo(Interval other) { return this.s - other.s; }
}