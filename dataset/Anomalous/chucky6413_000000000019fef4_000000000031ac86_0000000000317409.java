import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
	private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter writer = new PrintWriter(System.out);
	private static final StringBuilder resultBuilder = new StringBuilder();
	private static final String NEW_LINE = System.lineSeparator();

	public static void main(String[] args) {
		int testCases = scanner.nextInt();
		for (int testCase = 1; testCase <= testCases; testCase++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			String movements = scanner.next();

			resultBuilder.append("Case #")
						 .append(testCase)
						 .append(": ")
						 .append(findEarliestTime(x, y, movements))
						 .append(NEW_LINE);
		}
		writer.print(resultBuilder.toString());
		writer.close();
	}

	private static String findEarliestTime(int x, int y, String movements) {
		if (x == 0 && y == 0) {
			return "0";
		}

		int time = 0;
		for (char move : movements.toCharArray()) {
			switch (move) {
				case 'N': y++; break;
				case 'E': x++; break;
				case 'S': y--; break;
				case 'W': x--; break;
			}

			time++;
			if (Math.abs(x) + Math.abs(y) <= time) {
				return String.valueOf(time);
			}
		}
		return "IMPOSSIBLE";
	}
}