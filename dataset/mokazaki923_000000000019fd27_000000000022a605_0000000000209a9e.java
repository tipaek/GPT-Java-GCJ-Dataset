import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int b = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();

		for (int loop = 0; loop < t; loop++) {
			String result;
			if (b == 10) {
				result = solve10(in);
			} else if (b == 10) {
				result = "";
			} else {
				result = "";
			}
			System.out.println(result);
			String ok = in.nextLine();
			if (ok.equals("N"))
				break;
		}
	}

	static String solve10(Scanner in) {
		String result = "";
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1);
			result += in.nextLine();
		}
		return result;
	}

}
