package c2020.quali.round1c.p1;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

		int ret = DFS(new Point(x, y), 0, path);
		if (ret < 100000) {
			System.out.println("Case #" + i + ": " + ret);
		} else {
			System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
		}

	}

	private static int DFS(Point curDif, int time, String path) {
		if (new Point(0, 0).equals(curDif)) {

			return 0;
		}
		if (time >= path.length()) {
			return 100000;
		}
		int erg = 100000;

		Point next = new Point(curDif.x + valTimeX(path, time), curDif.y + valTimeY(path, time));
		erg = Math.min(erg, DFS(next, time + 1, path));
		next = new Point(curDif.x + 1 + valTimeX(path, time), curDif.y + valTimeY(path, time)); // WEST
		erg = Math.min(erg, DFS(next, time + 1, path));
		next = new Point(curDif.x - 1 + valTimeX(path, time), curDif.y + valTimeY(path, time)); // EAST
		erg = Math.min(erg, DFS(next, time + 1, path));
		next = new Point(curDif.x + valTimeX(path, time), curDif.y + 1 + valTimeY(path, time)); // SOUTH
		erg = Math.min(erg, DFS(next, time + 1, path));
		next = new Point(curDif.x + valTimeX(path, time), curDif.y - 1 + valTimeY(path, time)); // NORTH
		erg = Math.min(erg, DFS(next, time + 1, path));
		return erg + 1;

	}

	private static int valTimeX(String path, int time) {
		if (path.charAt(time) == 'W')
			return -1;
		if (path.charAt(time) == 'E')
			return 1;
		return 0;
	}

	private static int valTimeY(String path, int time) {
		if (path.charAt(time) == 'S')
			return -1;
		if (path.charAt(time) == 'N')
			return 1;
		return 0;
	}

}
