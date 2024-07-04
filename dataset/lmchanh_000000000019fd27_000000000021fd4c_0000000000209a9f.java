import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			solve(in, i);
		}

		in.close();
	}

	private static void solve(Scanner in, int num) {
		final String input = in.next();
		String transformed = "";

		char previous = '0';
		for (int i = 0; i < input.length(); i++) {
			char digit = input.charAt(i);
			if (digit > previous) {
				for (int j = digit - previous; j > 0; j--) {
					transformed += '(';
				}
			} else if (previous > digit) {
				for (int j = previous - digit; j > 0; j--) {
					transformed += ')';
				}
			}

			transformed += digit;
			previous = digit;
		}

		if (previous > '0') {
			for (int j = previous; j > 0; j--) {
				transformed += ')';
			}
		}

		System.out.println("Case #" + num + ": " + transformed);
	}
}