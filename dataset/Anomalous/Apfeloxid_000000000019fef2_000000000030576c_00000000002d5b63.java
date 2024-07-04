import java.util.Scanner;

public class Solution {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int numberOfTestCases = scanner.nextInt();

		for (int currentTest = 1; currentTest <= numberOfTestCases; currentTest++) {
			processTestCase();
		}
	}

	private static void processTestCase() {
		int A = scanner.nextInt();
		int B = scanner.nextInt();

		int minX = -7;
		int maxX = 7;
		int minY = -7;
		int maxY = 7;

		for (int x = minX; x <= maxX; x++) {
			for (int y = minY; y <= maxY; y++) {
				System.out.println(x + " " + y);
				String feedback = scanner.next();
				if ("CENTER".equals(feedback)) {
					return;
				}
			}
		}
	}
}