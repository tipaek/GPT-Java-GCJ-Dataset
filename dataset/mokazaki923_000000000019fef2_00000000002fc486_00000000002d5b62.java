import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		long l = (long) Math.pow(2, 30);

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			System.out.println("Case #" + i + ": " + solve(in));
		}
	}

	private static String solve(Scanner in) {
		String[] parts = in.nextLine().split(" ");
		long x = Long.valueOf(parts[0]);
		long y = Long.valueOf(parts[1]);

		List<String> answerList = new ArrayList<>();
		return test(answerList, x, y);
	}

	private static String test(List<String> answerList, long x, long y) {
		long absX = Math.abs(x);
		long absY = Math.abs(y);
		if (absX % 2 == 1) {
			if (absY % 2 == 1)
				return "IMPOSSIBLE";
			// x - 1
			long newX;
			if (x != -1) {
			newX= x - 1;
			answerList.add("E");
			if (newX == 0 && y == 0)
				return String.join("", answerList);

			if (!test(answerList, newX / 2, y / 2).equals("IMPOSSIBLE"))
				return String.join("", answerList);

			answerList.remove(answerList.size() - 1);
			}

			if (x != 1) {
			// x + 1
			newX = x + 1;
			answerList.add("W");
			if (newX == 0 && y == 0)
				return String.join("", answerList);

			if (!test(answerList, newX / 2, y / 2).equals("IMPOSSIBLE"))
				return String.join("", answerList);

			answerList.remove(answerList.size() - 1);
			}
			return "IMPOSSIBLE";

		} else {
			if (absY % 2 != 1)
				return "IMPOSSIBLE";
			// y - 1
			// y + 1

			// x - 1
			long newY;
			if (y != -1) {
			newY = y - 1;
			answerList.add("N");
			if (x == 0 && newY == 0)
				return String.join("", answerList);

			if (!test(answerList, x / 2, newY / 2).equals("IMPOSSIBLE"))
				return String.join("", answerList);

			answerList.remove(answerList.size() - 1);
			}

			if (y != 1) {
			// x + 1
			newY = y + 1;
			answerList.add("S");
			if (x == 0 && newY == 0)
				return String.join("", answerList);

			if (!test(answerList, x / 2, newY / 2).equals("IMPOSSIBLE"))
				return String.join("", answerList);

			answerList.remove(answerList.size() - 1);
			}
			return "IMPOSSIBLE";
		}

//		return String.join("\n", answerList);
	}


}
