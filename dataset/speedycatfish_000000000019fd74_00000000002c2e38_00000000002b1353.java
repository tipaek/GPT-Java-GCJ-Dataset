import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static HashSet<Coord> visited;
	static ArrayDeque<Coord> path;
	static boolean works;
	static int[] dx = { -1, 0, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 0, -1, -1 };
	static int[][] triangle;

	public static void main(String[] args) throws IOException {
		BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
		triangle = new int[500][];
		triangle[0] = new int[] { 1 };
		for (int i = 1; i < 500; i++) {
			triangle[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				int left = 0;
				int right = 0;
				if (j != 0) {
					left = triangle[i - 1][j - 1];
				}
				if (j != i) {
					right = triangle[i - 1][j];
				}
				triangle[i][j] = left + right;
			}
		}
		int t = Integer.parseInt(bufread.readLine());
		for (int counter = 0; counter < t; counter++) {
			n = Integer.parseInt(bufread.readLine());
			visited = new HashSet<>();
			path = new ArrayDeque<>();
			works = false;
			path.add(new Coord(0, 0));
			visited.add(new Coord(0, 0));
			DFS(0, 0, 1, 1);
			System.out.println("Case #" + (counter + 1) + ":");
			for (Coord c : path) {
				System.out.println(c.toString());
			}
		}
		bufread.close();
	}

	static void DFS(int x, int y, int currentSum, int steps) {
		if (currentSum > n) {
			return;
		}
		if (steps > 500) {
			return;
		}
		if (currentSum == n) {
			works = true;
			return;
		}
		for (int i = 0; i < 6; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			Coord newCoord = new Coord(tx, ty);
			if (tx >= 0 && tx < 500 && ty <= tx && visited.contains(newCoord) == false) {
				visited.add(newCoord);
				path.add(newCoord);
				int newSum = currentSum + triangle[x][y];
				DFS(tx, ty, newSum, steps + 1);
				if (works == true) {
					return;
				}
				path.remove(newCoord);
				visited.remove(newCoord);
			}
		}
	}
}

class Coord {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coord other = (Coord) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	int x;
	int y;

	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return (x + 1) + " " + (y + 1);
	}
}