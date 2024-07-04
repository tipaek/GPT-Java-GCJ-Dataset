import java.util.*;
import java.io.*;
import static java.lang.System.out;

/**
 * !!! INFINITE 2d
 * You can go to negative coordinates.
 */
public class Solution {

	private static Scanner sc;
	
	
	private static int jump(int j) {
		return 1 << (j-1);
	}

	private static void solve(int t) {
		
		int x = sc.nextInt();
		int y = sc.nextInt();

		if (x % 2 != 0 && y % 2 != 0) {
			out.printf("Case #%d: IMPOSSIBLE\n", t);
			return;
		}
		
		LinkedList<State> states = new LinkedList<>();
		states.add(new State("", 0, 0, 0, 0));
		
		while (!states.isEmpty()) {
			State s = states.poll();
			
			if (s.i == x && s.j == y) {
				out.printf("Case #%d: %s\n", t, s.s);
				return;
			}

			if (s.i % 2 != 0 && s.j % 2 != 0) {
				continue;
			}
			
			if (s.distance > Math.abs(x) + Math.abs(y)) {
				continue;
			}
			
            states.add(new State(s.s + "N", s.i, s.j + jump(s.jumps+1), s.jumps+1,
                    s.distance + jump(s.jumps+1)));
            states.add(new State(s.s + "S", s.i, s.j - jump(s.jumps+1), s.jumps+1,
                    s.distance + jump(s.jumps+1)));
            states.add(new State(s.s + "E", s.i + jump(s.jumps+1), s.j, s.jumps+1,
                    s.distance + jump(s.jumps+1)));
            states.add(new State(s.s + "W", s.i - jump(s.jumps+1), s.j, s.jumps+1,
                    s.distance + jump(s.jumps+1)));
		}
		out.printf("Case #%d: IMPOSSIBLE\n", t);
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.next());
		// System.err.println(T + " " + b);

		for (int t = 1; t <= T; ++t) {
			solve(t);
		}

		sc.close();

		// tests();
	}
	
	private static class State {
		String s;
		int i, j, jumps, distance;
		
		public State(String s, int i, int j, int jumps, int distance) {
			this.s = s;
			this.i = i;
			this.j = j;
            this.jumps = jumps;
            this.distance = distance;
		}

		public String toString() {
			return s + " i=" + i + " j=" + j + " jumps: " + jumps;
		}
	}
}
