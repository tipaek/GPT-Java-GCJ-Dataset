
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Submit without package declaration!
 */
public class Solution {

	private static int x, y, xAbs, yAbs;
	private static Deque<Character> path;

	private static Scanner getScanner(final String fileName) {
		try {
			return new Scanner(new BufferedReader(new FileReader(fileName)));
		} catch (FileNotFoundException e) {
			return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		}
	}

	public static void main(String[] args) {
		final Scanner in = getScanner("res/1b1.txt");
		final int nTestCases = in.nextInt();
		for (int t = 1; t <= nTestCases; t++) {
			// input
			x = in.nextInt();
			y = in.nextInt();
			// magic
			path = new ArrayDeque<>();
			xAbs = Math.abs(x);
			yAbs = Math.abs(y);
			boolean xOdd = xAbs % 2 == 1;
			boolean yOdd = yAbs % 2 == 1;
			if (xOdd && yOdd || !xOdd && !yOdd) {
				// exactly one odd jump to make
				System.out.println(String.format("Case #%d: %s", t, "IMPOSSIBLE"));
				continue;
			}
			final Map<Character, int[]> neighbors = neighbors(0, 0);
			for (Map.Entry<Character, int[]> entry : neighbors.entrySet()) {
				if (jump(entry.getKey(), entry.getValue()[0], entry.getValue()[1])) {
					System.out.print(String.format("Case #%d: ", t));
					path.descendingIterator().forEachRemaining(
							System.out::print);
					System.out.println();
					break;
				}
			}
			// print
			if (path.isEmpty())
				System.out.println(String.format("Case #%d: %s", t, "IMPOSSIBLE"));
		}
	}

	private static boolean jump(char c, int a, int b) {
		path.push(c);
		if (a == x && b == y) return true;
		final Map<Character, int[]> neighbors = neighbors(a, b);
		for (Map.Entry<Character, int[]> entry : neighbors.entrySet()) {
			if (jump(entry.getKey(), entry.getValue()[0], entry.getValue()[1]))
				return true;
		}
		path.pop();
		return false;
	}

	private static Map<Character, int[]> neighbors(int a, int b) {
		Map<Character, int[]> res = new HashMap<>();
		final int pow = (int) Math.pow(2, path.size());
		if (Math.abs(b + pow) <= yAbs) res.put('N', new int[]{a, b + pow});
		if (Math.abs(b - pow) <= yAbs) res.put('S', new int[]{a, b - pow});
		if (Math.abs(a + pow) <= xAbs) res.put('E', new int[]{a + pow, b});
		if (Math.abs(a - pow) <= xAbs) res.put('W', new int[]{a - pow, b});
		return res;
	}

}
