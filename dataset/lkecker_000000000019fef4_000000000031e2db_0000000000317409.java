package c2020.quali.round1c.p1;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			String path = sc.next();
			outputSolution(i, x, y, path);

		}
		sc.close();
	}

	private static void outputSolution(int i, int x, int y, String path) {

		int ret = DFS(new HashMap<>(), new Point(x, y), 0, path);
		if (ret < 100000) {
			System.out.println("Case #" + i + ": " + ret);
		} else {
			System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
		}

	}

	private static int DFS(HashMap<Point, Integer> times, Point curDif, int time, String path) {
		times.put(curDif, time);
		if (new Point(0, 0).equals(curDif)) {

			return 0;
		}
		if (time >= path.length()) {
			return 100000;
		}
		int erg = 100000;

		Point next = new Point(curDif.x + valTimeX(path, time), curDif.y + valTimeY(path, time));
		if (times.get(next) == null || times.get(next) > time)
			erg = Math.min(erg, DFS(times, next, time + 1, path));
		next = new Point(curDif.x + 1 + valTimeX(path, time), curDif.y + valTimeY(path, time)); // WEST
		if (times.get(next) == null || times.get(next) > time)
			erg = Math.min(erg, DFS(times, next, time + 1, path));
		next = new Point(curDif.x - 1 + valTimeX(path, time), curDif.y + valTimeY(path, time)); // EAST
		if (times.get(next) == null || times.get(next) > time)
			erg = Math.min(erg, DFS(times, next, time + 1, path));
		next = new Point(curDif.x + valTimeX(path, time), curDif.y + 1 + valTimeY(path, time)); // SOUTH
		if (times.get(next) == null || times.get(next) > time)
			erg = Math.min(erg, DFS(times, next, time + 1, path));
		next = new Point(curDif.x + valTimeX(path, time), curDif.y - 1 + valTimeY(path, time)); // NORTH
		if (times.get(next) == null || times.get(next) > time)
			erg = Math.min(erg, DFS(times, next, time + 1, path));
		return erg + 1;

	}

	private static int valTimeX(String path, int time) {
		try {
			if (path.charAt(time) == 'W')
				return -1;
			if (path.charAt(time) == 'E')
				return 1;
			return 0;
		} catch (StringIndexOutOfBoundsException e) {
			return 0;
		}
	}

	private static int valTimeY(String path, int time) {
		try {
			if (path.charAt(time) == 'S')
				return -1;
			if (path.charAt(time) == 'N')
				return 1;
			return 0;
		} catch (StringIndexOutOfBoundsException e) {
			return 0;
		}
	}

}
