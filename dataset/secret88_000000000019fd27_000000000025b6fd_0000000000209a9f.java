import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		// declare the necessary variables
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		in.nextLine();
		for (int test = 0; test < T; test++) {
			String line = in.nextLine();
			String[] digits = line.split("");

			String newString = "";

			for (int itr = 0; itr < digits.length; itr++) {

				// The current digit at the current position
				int digit = digits[itr].chars().reduce(0, (a, b) -> 10 * a + b - '0');
				String parent = digits[itr];

				// Openings here
				if (itr == 0) {
					while (digit-- > 0) {
						parent = "(" + parent;
					}
				} else {
					int diff = digit - digits[itr - 1].chars().reduce(0, (a, b) -> 10 * a + b - '0');
					if (diff > 0) {
						while (diff-- > 0) {
							parent = "(" + parent;
						}
					}
				}

				// Closing
				digit = digits[itr].chars().reduce(0, (a, b) -> 10 * a + b - '0');
				if (digits.length == 1) {
					while (digit-- > 0) {
						parent += ")";
					}
				}

				else if (itr < (digits.length - 1)) {
					int diff = digit - digits[itr + 1].chars().reduce(0, (a, b) -> 10 * a + b - '0');
					if (diff > 0) {
						while (diff-- > 0) {
							parent += ")";
						}
					}
				} else
					while (digit-- > 0) {
						parent += ")";
					}

				newString += parent;
			}

			System.out.println("Case #" + (test + 1) + ": " + newString);
		}

	}
}