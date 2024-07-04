import java.util.*;

public class Solution {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCasesAmount = scanner.nextInt();

		for (int test = 1; test <= testCasesAmount; test++) {
			getSolution();
		}
	}

	private static void getSolution() {
		int A = scanner.nextInt();
		int B = scanner.nextInt();

		int centerXFrom = -7;
		int centerXTo = 7;

		int centerYFrom = -7;
		int centerYTo = 7;

		for (int i = centerXFrom; i <= centerXTo; i++) {
			for (int j = centerYFrom; j <= centerYTo; j++) {
				System.out.println(i + " " + j);
				String response = scanner.next();
				if (response.equals("CENTER")) {
					return;
				}
			}
		}
	}
}
