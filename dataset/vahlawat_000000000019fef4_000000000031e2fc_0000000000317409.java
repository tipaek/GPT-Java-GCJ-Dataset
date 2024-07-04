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
			dir = in.nextLine();
			int x = pX;
			int y = pY;
			int min = 0;
			State s = new State(0, 0);
			List<State> l = new ArrayList<State>();
			l.add(s);
			boolean b = false;
			for (int i = 1; i < dir.length(); i++) {
				
				if (dir.charAt(i) == 'N') {
					y = y + 1;
				}
				if (dir.charAt(i) == 'S') {
					y = y - 1;
				}
				min++;
				List<State> newList = new ArrayList<State>();
				for (State state: l) {
					// stay 1 min
					State newState = new State(state.x, state.y);
					if (newState.x == x && newState.y == y) {
						// we meet
						b = true;
						break;
					}
					newList.add(newState);
					// move North
					newState = new State(state.x, state.y + 1);
					if (newState.x == x && newState.y == y) {
						// we meet
						b = true;
						break;
					}
					newList.add(newState);
					// move South
					newState = new State(state.x, state.y - 1);
					if (newState.x == x && newState.y == y) {
						// we meet
						b = true;
						break;
					}
					newList.add(newState);
					// move East
					if (state.x < pX) {
						newState = new State(state.x + 1, state.y);
						if (newState.x == x && newState.y == y) {
							// we meet
							b = true;
							break;
						}
						newList.add(newState);
					}
				}
				if (b) {
					break;
				}
				l = newList; 
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