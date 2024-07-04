import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i)
			System.out.println("Case #" + i + ": " + solve(in));
	}

	private static String solve(Scanner in) {
		String line = new StringBuilder(in.nextLine()).toString().replace("1", "(1)").replace(")(", "");
		return line;
	}
}
