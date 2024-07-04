import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
			solve(967);
		
		
		
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

		List<String> answerList = solve500(number);
		if (answerList.size() < 500)
			return "\n" + String.join("\n", answerList);
		answerList = solve(number);
		if (answerList.size() < 500)
			return "\n" + String.join("\n", answerList);
		return "";
	}

	static List<String> solve500(int number) {
		final int firstNumber = number;
		
		List<String> answerList = new ArrayList<>();

		List<Boolean> onList = new ArrayList<>();
		while(number != 0) {
			boolean mod = number % 2 == 1;
			onList.add(mod);
			number /= 2;
		}

		long sum = 0;
		int repeatCount = onList.size() - 1;
		boolean left = false;
		for (int i = 1; i <= repeatCount; i++) {
			int length = i;
			for (int j = 0; j < length; j++) {
				if (left)
					answerList.add(i + " " + (j + 1));
				else
					answerList.add(i + " " + (length - j));
			}
			left = !left;
			sum += (long)Math.pow(2, i - 1);
		}
		for (int i = 1; i <= firstNumber - sum; i++) {
			answerList.add((repeatCount + i) + " " + (left ? "1" : (repeatCount + i)));
		}
		
		return answerList;
	}
	
	static List<String> solve(int number) {
		final int firstNumber = number;
		
		List<String> answerList = new ArrayList<>();

		int onCount = 0;
		List<Boolean> onList = new ArrayList<>();
		while(number != 0) {
			boolean mod = number % 2 == 1;
			if (mod)
				onCount++;
			onList.add(mod);
			number /= 2;
		}
		
		
		
		

		long sum = 0;
		int repeatCount = onList.size() - 1 - 1;
		boolean left = false;
		for (int i = 1; i <= repeatCount; i++) {
			int length = i;
			for (int j = 0; j < length; j++) {
				if (left)
					answerList.add(i + " " + (j + 1));
				else
					answerList.add(i + " " + (length - j));
			}
			left = !left;
			sum += (long)Math.pow(2, i - 1);
		}
		
		answerList.add((repeatCount + 1) + " " + (left ? "1" : (repeatCount + 1)));
		sum++;
		
		int length = repeatCount + 2;
		for (int j = 0; j < length; j++) {
			if (left)
				answerList.add((repeatCount + 2) + " " + (j + 1));
			else
				answerList.add((repeatCount + 2) + " " + (length - j));
		}
		left = !left;
		sum += (long)Math.pow(2, repeatCount + 1);

		for (int i = 3; i <= firstNumber - sum; i++) {
			answerList.add((repeatCount + i) + " " + (left ? "1" : (repeatCount + i)));
		}
		return answerList;
	}

}
