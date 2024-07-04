import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			String m = sc.next();
			Integer val = walk(0, 0, x, y, m, 0, new HashMap<int[], Integer>());
			System.out.printf("Case #%d: %s\n", i, val == null ? "IMPOSSIBLE" : val);
		}

	}

	static Integer walk(int x, int y, int px, int py, String moves, int index, HashMap<int[], Integer> map) {
		if (x == px && py == y) {
			return index;
		}
		if (moves.length() == index) {
			return null;
		}
		Integer val = map.get(new int[] { x, y });
		if (val == null) {
			map.put(new int[] { x, y }, index);
		} else if (val >= index) {
			return null;
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
		list.add(walk(x - 1, y, px, py, moves, index + 1, map));
		list.add(walk(x + 1, y, px, py, moves, index + 1, map));
		list.add(walk(x, y - 1, px, py, moves, index + 1, map));
		list.add(walk(x, y + 1, px, py, moves, index + 1, map));
		list.add(walk(x, y, px, py, moves, index + 1, map));

		OptionalInt opt = list.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).min();
		if (opt.isPresent()) {
			map.put(new int[] { x, y }, opt.getAsInt());
			return opt.getAsInt();
		}
		return null;
	}
}