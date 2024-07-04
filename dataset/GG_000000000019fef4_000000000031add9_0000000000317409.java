import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			String m = sc.next();
			int val = walk(0, 0, x, y, m, 0);
			System.out.printf("Case #%d %s\n", i, val == -1 ? "IMPOSSIBLE" : val);
		}

	}

	static int walk(int x, int y, int px, int py, String moves, int index) {
		if (x == px && py == y) {
			return index;
		}
		if (moves.length() == index || x < 0 || y < 0) {
			return -1;
		}

		switch (moves.charAt(index)) {
		case 'E':
			px++;
			break;
		case 'W':
			px--;
			break;
		case 'S':
			py--;
			break;
		case 'N':
			py++;
			break;
		}
		ArrayList<Integer> list = new ArrayList<>();
		list.add(walk(x - 1, y, px, py, moves, index + 1));
		list.add(walk(x + 1, y, px, py, moves, index + 1));
		list.add(walk(x, y - 1, px, py, moves, index + 1));
		list.add(walk(x, y + 1, px, py, moves, index + 1));
		list.add(walk(x, y, px, py, moves, index + 1));

		return list.stream().mapToInt(Integer::intValue).filter(e -> e != -1).min().orElse(-1);
	}

}