

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;


public class Solution {

	private void getPath(int x, int y, int caseNo) {
		LinkedList<Cell> queue = new LinkedList<>();
		Cell start = new Cell(0, 0, '0', "", x, y);
		queue.add(start);
		HashSet<Cell> visited = new HashSet<>();
		visited.add(start);

		for (int i = 1; i <= 100; i++) {
			LinkedList<Cell> adjNode = new LinkedList<>();

			while (!queue.isEmpty()) {
				Cell cur = queue.pop();
				visited.add(cur);
				if (cur.r == y && cur.c == x) {
					System.out.println("Case #" + caseNo + ": " + cur.path);
					return;
				}
				adjNode.add(new Cell(cur.r + (int) Math.pow(2, i - 1), cur.c,
						'N', cur.path + "N", x, y));
				adjNode.add(new Cell(cur.r - (int) Math.pow(2, i - 1), cur.c,
						'S', cur.path + "S", x, y));
				adjNode.add(new Cell(cur.r, cur.c + (int) Math.pow(2, i - 1),
						'E', cur.path + "E", x, y));
				adjNode.add(new Cell(cur.r, cur.c - (int) Math.pow(2, i - 1),
						'W', cur.path + "W", x, y));
			}

			double min = Integer.MAX_VALUE;
			for (Cell cell : adjNode) {
				if (!visited.contains(cell)) {
					queue.add(cell);
					min = min < cell.dist ? min : cell.dist;
				}
			}
			if (min > 10)
				break;
		}
		System.out.println("Case #" + caseNo + ": " + "IMPOSSIBLE");

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int X = in.nextInt();
			int Y = in.nextInt();

			obj.getPath(X, Y, i);
		}
	}

	class Cell {
		int r, c;
		char dir;
		String path;
		double dist;
		int x, y;

		public Cell(int r, int c, char ch, String str, int x, int y) {
			this.r = r;
			this.c = c;
			this.dir = ch;
			this.path = str;
			this.x = x;
			this.y = y;
			this.dist = calculateDist(r, c, x, y);
		}

		private double calculateDist(int r2, int c2, int x2, int y2) {
			return Math.sqrt(Math.pow(r2 - y2, 2) + Math.pow(c2 - x2, 2));
		}

		@Override
		public String toString() {
			return (this.r) + " " + (this.c);
		}

		@Override
		public boolean equals(Object obj) {
			Cell cell = (Cell) obj;
			return this.r == cell.r && this.c == cell.c;
		}

		@Override
		public int hashCode() {
			return this.r;
		}
	}
}
