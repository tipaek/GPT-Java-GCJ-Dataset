import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();

		for (int i = 0; i < T; i++) {
			int X = in.nextInt();
			int Y = in.nextInt();
			String M = in.next();

			boolean finish = false;

			if (Solution.possibleMoveInTime(X, Y, 0)) {
				System.out.println("Case #" + (i + 1) + ": 0");
			}

			for (int p = 0; p < M.length(); p++) {
				char move = M.charAt(p);

				if (move == 'S') {
					Y--;
				} else if (move == 'N') {
					Y++;
				} else if (move == 'E') {
					X++;
				} else if (move == 'W') {
					X--;
				}

				if (Solution.possibleMoveInTime(X, Y, p + 1)) {					
					System.out.println("Case #" + (i + 1) + ": " + (p + 1));
					finish = true;
					break;
				}
			}			

			if (!finish) {
				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
			}
		}

	}

	public static double distance(int X, int Y) {
		return Math.sqrt(Math.pow((0-X), 2) + Math.pow((0-Y), 2));
	}

	public static boolean possibleMoveInTime(int X, int Y, int time) {
		return (Math.abs(X) + Math.abs(Y)) <= time;
	}
}
