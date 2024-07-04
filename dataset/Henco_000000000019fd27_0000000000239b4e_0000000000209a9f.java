import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
//		Scanner scanner = new Scanner(new FileInputStream(new File(Solution.class.getResource("input.txt").toURI())));
		Scanner scanner = new Scanner(System.in);
		run(scanner);
	}

	private static void printCase(int i, String str) {
		System.out.println("Case #" + (i + 1) + ": " + str);
	}

	private static void run(Scanner scanner) {
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			solveCase(i, scanner.next());
		}
	}

	private static void solveCase(int i, String next) {
		int[] digits = Arrays.stream(next.split("")).mapToInt(Integer::parseInt).toArray();
		StringBuilder builder = new StringBuilder(digits.length);
		int deep = 0;
		for (int d : digits) {
			int diff = Math.abs(d - deep);

			if (d < deep) {

				char c = ')';
				for (int j = 0; j < diff; j++) {
					builder.append(c);
				}
				builder.append(d);
			} else if (d > deep) {

				char c = '(';
				for (int j = 0; j < diff; j++) {
					builder.append(c);
				}
				builder.append(d);
			} else {
				builder.append(d);
			}
			deep = d;
		}
		for (int j = 0; j < deep; j++) {
			builder.append(')');
		}
		printCase(i, builder.toString());
	}

}
