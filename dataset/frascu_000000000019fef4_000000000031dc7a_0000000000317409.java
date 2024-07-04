import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			for (int i = 0; i < t; i++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				char[] m = scanner.next().toCharArray();

				int currX = x;
				int currY = y;
				int count = 0;
				for (int j = 0; j < m.length; j++) {
					char move = m[j];
					if (move == 'S') {
						currY--;
					} else if (move == 'N') {
						currY++;
					} else if (move == 'E') {
						currX++;
					} else if (move == 'W') {
						currX--;
					}
					count++;

					if (currX == 0 && currY == 0) {
						break;
					}

					if (Math.abs(currX) == Math.abs(currY) && currX == 1 && j < m.length - 1) {
						char nextMove = m[j + 1];
						if (nextMove == 'S') {
							currY--;
						} else if (nextMove == 'N') {
							currY++;
						} else if (nextMove == 'E') {
							currX++;
						} else if (nextMove == 'W') {
							currX--;
						}
						count++;
					}

					if (Math.abs(currX) > Math.abs(currY)) {
						currX = currX - (currX / Math.abs(currX));
					} else if (Math.abs(currX) < Math.abs(currY)) {
						currY = currY - (currY / Math.abs(currY));
					} else {
						currX = currX - (currX / Math.abs(currX));
					}

					if (currX == 0 && currY == 0) {
						break;
					}
				}

				if (currX == 0 && currY == 0) {
					System.out.println("Case #" + (i + 1) + ": " + count);
				} else {
					System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
				}
			}
		}

	}

}
