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

			int count = 0;
			int startX = 0;
			int startY = 0;
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

			currY = Y;
			for (int j = 0; j < M.length(); j++) {
				count = count + 1;
				
				if (M.charAt(j) == 'N') {
					currY = currY + 1;
				} else if (M.charAt(j) == 'S') {
					currY = currY - 1;
				} 
				
				if (startX == currX && startY == currY) {
					break;
				} else {

					int xDirection = 0;
					if (currX < startX) {
						xDirection = -1;
					} else {
						xDirection = 1;
					}

					int yDirection = 0;
					if (currY > startY) {
						yDirection = 1;
					} else {
						yDirection = -1;
					}

					if (startX != currX) {
						startX = startX + xDirection;
					} else if (startY != currY) {
						startY = startY + yDirection;
					}
					if (startX == currX && startY == currY) {
						break;
					}
				}				
			}


			if (startX != currX || startY != currY) {
				writer.printf("Case #%d: IMPOSSIBLE%n", i + 1);
			} else {
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