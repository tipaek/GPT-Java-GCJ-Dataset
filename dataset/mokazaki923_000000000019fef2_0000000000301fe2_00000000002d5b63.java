
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int a = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int b = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();

		for (int loop = 0; loop < t; loop++) {
			solve(in);
			/*
			Pair[] pairs;
			if (b == 10) {
				pairs = solve10(in);
			} else if (b == 20) {
				pairs = solve20(in);
			} else {
				pairs = solve100(in);
			}
			char[] result = new char[b];
			for (int i = 0; i < b / 2; i++) {
				result[i] = pairs[i].front ? '1' : '0';
				result[b - i - 1] = pairs[i].end ? '1' : '0';
			}
			System.out.println(new String(result));
			String ok = in.nextLine();
			if (ok.equals("N"))
				break;
			//*/
		}
	}


	private static void solve(Scanner in) {
		for (int x = -5; x < 6; x++) {
			for (int y = -5; y < 6; y++) {
				if (!getValue(in, x, y))
					continue;
				return;
			}
		}
	}


	private static boolean getValue(Scanner in, int x, int y) {
		System.out.println(x + " " + y);
		return in.nextLine().equals("CENTER");
	}

}
