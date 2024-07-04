import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	private Scanner scanner;
	private PrintWriter writer;

	public Solution(InputStream in, OutputStream out) {
		scanner = new Scanner(in);
		writer = new PrintWriter(out);
	}

	public void solveA() {
		int T = scanner.nextInt();
		for (int i = 0; i < T; i++) {
			int X = scanner.nextInt();
			int Y = scanner.nextInt();
			String M = scanner.next();

			// Case 1: 4 4 SSSS --> X=4,Y=4, currX=-4,currY= 0 --> m=4 ; result = 4
			// Case 2: 3 0 SNSS --> X=3,Y=0, currX=-3,currY=-2 --> m=4 ; result = IMPOSSIBLE
			// Case 3: 2 10 NSNNSN --> X=2,Y=10, currX=-2,curry=12 --> m=6 ; result =
			// IMPOSSIBLE
			// Case 4: 0 1 S --> X=0,Y=1, currX= 0,currY= 0 --> m=1 ; result = 1
			// Case 5: 2 7 SSSSSSSS --> X=2,Y=7, currX=-2,currY=-1 --> m=8 ; result = 5,
			// Case 6: 3 2 SSSW --> X=3,Y=2, currX=-2,currY=-1 --> m=4 ; result = 4
			// Case 7: 4 0 NESW --> X=4,Y=0, currX= 4,currY= 0 --> m=4 ; result = 2

			int currX = X * -1;
			int currY = Y;
			for (int j = 0; j < M.length(); j++) {
				if (M.charAt(j) == 'N') {
					currY = currY + 1;
				} else if (M.charAt(j) == 'S') {
					currY = currY - 1;
				} else if (M.charAt(j) == 'E') {
					currX = currX - 1;
				} else if (M.charAt(j) == 'W') {
					currX = currX + 1;
				}
			}

			int finalXY = Math.abs(currX) + Math.abs(currY);
			if (finalXY > M.length()) {
				writer.printf("Case #%d: IMPOSSIBLE%n", i + 1);
			} else {
				int count = 0;

				int startX = 0;
				int xDirection = 0;
				if (currX > (X * -1)) {
					xDirection = 1;
				} else if (currX <= (X * -1)) {
					xDirection = -1;
				}

				int startY = 0;
				int yDirection = 0;

				X = X * -1;
				for (int j = 0; j < M.length(); j++) {
					count = count + 1;
					if (M.charAt(j) == 'N') {
						Y = Y + 1;
					} else if (M.charAt(j) == 'S') {
						Y = Y - 1;
					} else if (M.charAt(j) == 'E') {
						X = X - 1;
					} else if (M.charAt(j) == 'W') {
						X = X + 1;
					}

					if (startX == X && startY == Y) {
						break;
					} else {
						if (startX != X) {
							startX = startX + xDirection;
						} else if (startY != Y) {
							if (Y > startY) {
								yDirection = 1;
							} else {
								yDirection = -1;
							}
							startY = startY + yDirection;
						}
					}
				}

				writer.printf("Case #%d: %d%n", i + 1, count);
			}

		}
		writer.flush();
		writer.close();
	}

	public static void main(String[] args) {
		Solution solution = new Solution(System.in, System.out);
		solution.solveA();
	}
}