import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			System.out.println("Case #" + i + ": " + solve(in));
		}
	}

	private static String solve(Scanner in) {
		int number = in.nextInt();
		in.nextLine();

		/*
		List<Boolean> onList = new ArrayList<>();
		while(number != 0) {
			boolean mod = number % 2 == 1;
			onList.add(mod);
			number /= 2;
		}
		//*/
		List<String> answerList = new ArrayList<>();
		for (int i = 1; i <= number; i++) {
			answerList.add(i + " 1");
		}
		return String.join("\n", answerList);
	}

}
