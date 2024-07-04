import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.Math.ceil;
import static java.lang.Math.log;
import static java.lang.Math.pow;

public class Solution {

	enum Direction {
		N(1), E(1), S(-1), W(-1);

		private final int sign;

		Direction(int sign) {
			this.sign = sign;
		}

		public int getDistance(int i) {
			return sign * (int) pow(2, i);
		}
	}

	public static void main(String[] args) {
		try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
			int testCases = parseInt(inputReader.readLine());

			for (int t = 1; t <= testCases; t++) {
				int[] coordinates = Arrays.stream(inputReader.readLine().split(" "))
						.mapToInt(Integer::parseInt).toArray();
				int x = coordinates[0];
				int y = coordinates[1];

				int maxJumps = (int) ceil(log(abs(x) + abs(y) + 1) / log(2));

				String path;
				if (x != 0 && x % 2 != 0) {
					// Move X first
					String east = getPath("E", x - Direction.E.getDistance(0), y, maxJumps);
					String west = getPath("W", x - Direction.W.getDistance(0), y, maxJumps);
					path = reducePaths(east, west);
				} else if (y != 0 && y % 2 != 0) {
					// Move Y first
					String north = getPath("N", x, y - Direction.N.getDistance(0), maxJumps);
					String south = getPath("S", x, y - Direction.S.getDistance(0), maxJumps);
					path = reducePaths(north, south);
				} else if (x == 0 && y == 0) {
					path = "";
				} else {
					// Impossible
					path = "IMPOSSIBLE";
				}

				System.out.printf("Case #%d: %s%n", t, path);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getPath(String currentPath, int x, int y, int maxJumps) {
		if (currentPath.length() > maxJumps && (x != 0 || y != 0)) {
			return "IMPOSSIBLE";
		} else if (x == 0 && y == 0) {
			return currentPath;
		} else {
			String north = getPath(currentPath + "N", x, y - Direction.N.getDistance(currentPath.length()), maxJumps);
			String south = getPath(currentPath + "S", x, y - Direction.S.getDistance(currentPath.length()), maxJumps);
			String east = getPath(currentPath + "E", x - Direction.E.getDistance(currentPath.length()), y, maxJumps);
			String west = getPath(currentPath + "W", x - Direction.W.getDistance(currentPath.length()), y, maxJumps);
			String northSouth = reducePaths(north, south);
			String eastWest = reducePaths(east, west);
			return reducePaths(northSouth, eastWest);
		}
	}

	private static String reducePaths(String path1, String path2) {
		if ("IMPOSSIBLE".equals(path1) && "IMPOSSIBLE".equals(path2)) {
			return "IMPOSSIBLE";
		} else if ("IMPOSSIBLE".equals(path1)) {
			return path2;
		} else if ("IMPOSSIBLE".equals(path2)) {
			return path1;
		} else {
			return path1.length() <= path2.length() ? path1 : path2;
		}
	}
}