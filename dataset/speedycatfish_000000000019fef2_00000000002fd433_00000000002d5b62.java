import java.util.*;
import java.io.*;

public class Solution {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bufread.readLine());
		for (int counter = 0; counter < t; counter++) {
			StringTokenizer st = new StringTokenizer(bufread.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			boolean xFlip = Math.signum(x) == -1;
			boolean yFlip = Math.signum(y) == -1;
			x = Math.abs(x);
			y = Math.abs(y);
			ArrayDeque<Integer> solution = BFS(x, y);
			if (solution == null) {
				System.out.println("Case #" + (counter + 1) + ": IMPOSSIBLE");
			} else {
				StringBuilder sb = new StringBuilder();
				for (int move : solution) {
					switch (move) {
					case 0:
						if (xFlip == false) {
							sb.append('E');
						} else {
							sb.append('W');
						}
						break;
					case 1:
						if (yFlip == false) {
							sb.append('N');
						} else {
							sb.append('S');
						}
						break;
					case 2:
						if (xFlip == false) {
							sb.append('W');
						} else {
							sb.append('E');
						}
						break;
					case 3:
						if (yFlip == false) {
							sb.append('S');
						} else {
							sb.append('N');
						}
						break;
					}
				}
				System.out.println("Case #" + (counter + 1) + ": " + sb.toString());
			}
		}
		bufread.close();
	}

	static ArrayDeque<Integer> BFS(int x, int y) {
		int xLeast = x ^ (x & (x - 1));
		int yLeast = y ^ (y & (y - 1));
		ArrayDeque<State> states = new ArrayDeque<>();
		states.add(new State(0, 0, 0, new ArrayDeque<>()));
		while (states.isEmpty() == false) {
			State currentState = states.removeFirst();
			if (currentState.x > x || currentState.y > y) {
				continue;
			}
			if (currentState.x == x && currentState.y == y) {
				return currentState.solution;
			}
			int currentMove = 1 << currentState.moveNum;
			int currentXLeast = currentState.x ^ (currentState.x & (currentState.x - 1));
			int currentYLeast = currentState.y ^ (currentState.y & (currentState.y - 1));
			if ((currentMove > xLeast && (currentXLeast > xLeast || (currentXLeast == 0 && xLeast != 0))) || (currentMove > yLeast && (currentYLeast > yLeast || (currentYLeast == 0 && yLeast != 0)))) {
				continue;
			}
			for (int i = 0; i < 4; i++) {
				if ((xLeast == 0 || currentState.x == x) && (i == 0 || i == 2)) {
					continue;
				}

				if ((yLeast == 0 || currentState.y == y) && (i == 1 || i == 3)) {
					continue;
				}
				int tx = dx[i] * currentMove + currentState.x;
				int ty = dy[i] * currentMove + currentState.y;
				ArrayDeque<Integer> newSolution = currentState.solution.clone();
				newSolution.add(i);
				State newState = new State(tx, ty, currentState.moveNum + 1, newSolution);
				states.add(newState);
			}
		}
		return null;
	}
}

class State {
	int x;
	int y;
	int moveNum;
	ArrayDeque<Integer> solution;

	public State(int x, int y, int moveNum, ArrayDeque<Integer> solution) {
		this.x = x;
		this.y = y;
		this.moveNum = moveNum;
		this.solution = solution;
	}
}
