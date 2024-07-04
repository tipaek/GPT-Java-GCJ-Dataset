import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = in.nextInt();
			Interval[] times = new Interval[n];
			for (int i = 0; i < n; i++)
				times[i] = new Interval(in.nextInt(), in.nextInt());
			Arrays.sort(times);
			Interval cl = times[0], jl = times[1];
			StringBuilder str = new StringBuilder("CJ");
			for (int i = 2; i < n; i++) {
				int time = times[i].s;
				if (cl.e <= time) {
					str.append("C");
					cl = times[i];
				} else if (jl.e <= time) {
					str.append("J");
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
	int s, e;
	public Interval(int a, int b) { s = a; e = b; }
	public int compareTo(Interval other) { return this.s - other.s; }
}