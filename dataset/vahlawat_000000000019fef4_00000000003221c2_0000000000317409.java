import java.util.*;
import java.io.*;

public class Solution {
	public static int pX;
	public static int pY;
	public static String dir;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int tc = 1; tc <= t; ++tc) {
			pX = in.nextInt();
			pY = in.nextInt();
			dir = in.nextLine().trim();
			int x = pX;
			int y = pY;
			int min = 0;
			State s = new State(0, 0);
			List<State> l = new ArrayList<State>();
			l.add(s);
			boolean b = false;
			while(s.x != pX) {
				if (dir.charAt(min) == 'N') {
					y = y + 1;
				}
				if (dir.charAt(min) == 'S') {
					y = y - 1;
				}
				min++;
				s.x = s.x + 1;
			}
			if (s.x == x && s.y == y) {
				b = true;
			} else {
				if (y > 0) {
					for (int i = min; i < dir.length(); i++) {
						if (dir.charAt(i) == 'N') {
							y = y + 1;
							s.y = s.y + 1;
						}
						if (dir.charAt(i) == 'S') {
							if (y - s.y > 1) {
								s.y = s.y + 1;
							}
							y = y - 1;
						}
						min++;
						
						if (s.y == y) {
							b = true;
							break;
						}
					}
				} else {
					for (int i = min; i < dir.length(); i++) {
						if (dir.charAt(i) == 'N') {
							if (s.y - y > 1) {
								s.y = s.y - 1;
							}
							y = y + 1;
						}
						if (dir.charAt(i) == 'S') {
							y = y - 1;
							s.y = s.y - 1;
						}
						min++;
						
						if (s.y == y) {
							b = true;
							break;
						}
					}
				}
			}
			if (b) {
				System.out.println("Case #" + tc + ": " + min);
			} else {
				System.out.println("Case #" + tc + ": IMPOSSIBLE");
			}
			
		}
	}
}

class State {
	int x;
	int y;
	
	public State(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return x + ", " + y;
	}
}