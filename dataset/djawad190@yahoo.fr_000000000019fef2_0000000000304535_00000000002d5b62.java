import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		int N;
		long x, y;
		long distance;
		String sol;

		for (int i = 1; i <= T; i++) {
			x = in.nextLong();
			y = in.nextLong();
			distance = distance(0, 0, x, y);

			// if (distance % 2 == 0) {
			// System.out.println("Case #" + i + ": IMPOSSIBLE");
			// continue;
			// }
			sol = batch(0, 0, x, y, "");
			System.out.println("Case #" + i + ": " + sol);

		}
	}

	static final String	NORTH		= "N";
	static final String	SOUTH		= "S";
	static final String	EAST		= "E";
	static final String	WEST		= "W";
	static final String	IMPOSSIBLE	= "IMPOSSIBLE";

	static String batch(long x1, long y1, long x, long y, String curSol) {
		ArrayList<String> sol = new ArrayList<>();
		ArrayList<Position> positions = new ArrayList<>();
		String solution;

		positions.add(solution(x1, y1, x, y, curSol, NORTH));
		positions.add(solution(x1, y1, x, y, curSol, SOUTH));
		positions.add(solution(x1, y1, x, y, curSol, EAST));
		positions.add(solution(x1, y1, x, y, curSol, WEST));
		Position pos;
		for (int i = 0; i < positions.size(); i++) {
			pos = positions.get(i);
			if (pos.isSolution)
				sol.add(pos.sol);
			else if (!pos.sol.equals(IMPOSSIBLE)) {
				solution = batch(pos.x, pos.y, x, y, pos.sol);
				if (!solution.equals(IMPOSSIBLE))
					sol.add(solution);
			}
		}

		if (sol.isEmpty())
			solution = IMPOSSIBLE;

		else {
			solution = sol.get(0);
			for (String string : sol) {
				if (solution.length() > string.length())
					solution = string;
			}
		}

		return solution;
	}

	static Position solution(long x1, long y1, long x, long y, String curSol, String direction) {
		String sol = curSol;
		boolean isSolution;
		long jump = (long) Math.pow(2, curSol.length());

		switch (direction) {
			case NORTH:
				y1 += jump;
				sol += NORTH;
				if (Math.abs(y1) > Math.abs(y) + 1)
					sol = IMPOSSIBLE;
				break;
			case SOUTH:
				y1 -= jump;
				sol += SOUTH;
				if (Math.abs(y1) > Math.abs(y) + 1)
					sol = IMPOSSIBLE;
				break;
			case EAST:
				x1 += jump;
				sol += EAST;
				if (Math.abs(x1) > Math.abs(x) + 1)
					sol = IMPOSSIBLE;
				break;
			case WEST:
				x1 -= jump;
				sol += WEST;
				if (Math.abs(x1) > Math.abs(x) + 1)
					sol = IMPOSSIBLE;
				break;
		}
		isSolution = x1 == x && y1 == y;
		return new Position(x1, y1, sol, isSolution);
	}

	static class Position {
		long	x;
		long	y;
		String	sol			= IMPOSSIBLE;
		boolean	isSolution	= false;

		public Position(long x1, long y1, String sol1, boolean isSol) {
			x = x1;
			y = y1;
			sol = sol1;
			isSolution = isSol;
		}

	}

	static long distance(long x1, long y1, long x2, long y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}