import java.util.*;
import java.io.*;

public class Solution {
	private static int A = 0;
	private static int B = 0;

	public static int[] findHorizontalBounds(int x, int y, Scanner in) {
		int leftBoundary = Math.max(x - 2 * A, -1000000000);
		int rightBoundary = x;
		int left = binarySearchHorizontal(leftBoundary, rightBoundary, y, in, 1);
		if (left == 1000000001) {
			return new int[]{ left, left };
		}

		rightBoundary = x;
		leftBoundary = Math.min(x + 2 * A, 1000000000);
		int right = binarySearchHorizontal(rightBoundary, leftBoundary, y, in, -1);
		if (right == 1000000001) {
			return new int[]{ right, right };
		}

		return new int[]{ left, right };
	}

	public static int findVerticalBound(int x, int y, Scanner in) {
		int lowerBoundary = Math.max(y - 2 * A, -1000000000);
		int upperBoundary = y;
		return binarySearchVertical(lowerBoundary, upperBoundary, x, in, 1);
	}

	public static int binarySearchVertical(int lowerBoundary, int upperBoundary, int x, Scanner in, int step) {
		if (lowerBoundary == upperBoundary) {
			return lowerBoundary;
		}

		int mid = (lowerBoundary + upperBoundary) / 2;
		String guess = x + " " + mid;
		System.out.println(guess);

		String response = in.next();

		if (response.equals("CENTER")) {
			return 1000000001;
		} else if (response.equals("HIT")) {
			guess = x + " " + (mid - step);
			System.out.println(guess);

			String secondResponse = in.next();
			if (secondResponse.equals("HIT")) {
				return binarySearchVertical(lowerBoundary, mid - step, x, in, step);
			} else {
				return mid;
			}
		} else {
			guess = x + " " + (mid + step);
			System.out.println(guess);

			String secondResponse = in.next();
			if (secondResponse.equals("HIT")) {
				return mid + step;
			}
			return binarySearchVertical(mid + step, upperBoundary, x, in, step);
		}
	}

	public static int binarySearchHorizontal(int lowerBoundary, int upperBoundary, int y, Scanner in, int step) {
		if (lowerBoundary == upperBoundary) {
			return lowerBoundary;
		}

		int mid = (lowerBoundary + upperBoundary) / 2;
		String guess = mid + " " + y;
		System.out.println(guess);

		String response = in.next();

		if (response.equals("CENTER")) {
			return 1000000001;
		} else if (response.equals("HIT")) {
			guess = (mid - step) + " " + y;
			System.out.println(guess);

			String secondResponse = in.next();
			if (secondResponse.equals("HIT")) {
				return binarySearchHorizontal(lowerBoundary, mid - step, y, in, step);
			} else {
				return mid;
			}
		} else {
			guess = (mid + step) + " " + y;
			System.out.println(guess);

			String secondResponse = in.next();
			if (secondResponse.equals("HIT")) {
				return mid + step;
			}
			return binarySearchHorizontal(mid + step, upperBoundary, y, in, step);
		}
	}

	public static void solve(String initialGuess, Scanner in) {
		int spaceIndex = initialGuess.indexOf(" ");
		int x = Integer.parseInt(initialGuess.substring(0, spaceIndex));
		int y = Integer.parseInt(initialGuess.substring(spaceIndex + 1));
		
		int[] horizontalBounds = findHorizontalBounds(x, y, in);
		if (horizontalBounds[0] == 1000000001) {
			return;
		}
				
		int lowerBound = findVerticalBound(x, y, in);
		if (lowerBound == 1000000001) {
			return;
		}
		
		int upperBound = y + (x - horizontalBounds[0]) * (horizontalBounds[1] - x) / (y - lowerBound);
		
		int centerX = (horizontalBounds[0] + horizontalBounds[1]) / 2;
		int centerY = (lowerBound + upperBound) / 2;
		
		String finalGuess = centerX + " " + centerY;
		System.out.println(finalGuess);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int T = in.nextInt();
		A = in.nextInt();
		B = in.nextInt();

		for (int t = 1; t <= T; ++t) {
			String[] initialGuesses = { "0 0", "1000000000 1000000000", "-1000000000 1000000000", "1000000000 -1000000000", "-1000000000 -1000000000" };
			boolean hit = false;
			int count = 0;

			while (!hit && count < initialGuesses.length) {
				String guess = initialGuesses[count];
				System.out.println(guess);
				String response = in.next();
				if (response.equals("CENTER")) {
					return;
				} else if (response.equals("HIT")) {
					hit = true;
				}
				count++;
			}

			if (hit) {
				solve(initialGuesses[--count], in);
			}
		}
		in.close();
	}
}