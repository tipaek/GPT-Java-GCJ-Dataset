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

		int centerXFrom = -5;
		int centerXTo = 5;

		int centerYFrom = -5;
		int centerYTo = 5;

		for (int i = centerXFrom; i < centerXTo; i++) {
			for (int j = centerYFrom; j < centerYTo; j++) {
				System.out.println(i + " " + j);
				String response = scanner.next();
				if (response.equals("CENTER")) {
					return;
				}
			}
		}
	}
}
