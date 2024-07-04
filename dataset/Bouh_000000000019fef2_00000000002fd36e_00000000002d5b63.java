import java.io.*;
import java.util.*;

public class Solution {

	public static final int DIX9 = 1000000000;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		solveProblem(in);
	}

	public static void solveProblem(Scanner scanner) {
		int t = scanner.nextInt(); 
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		for (int i = 1; i <= t; ++i) {
			int foundY = DIX9;
			int minY = DIX9 - 101;
			int maxY = DIX9;
			for (int y = minY; y < maxY; y++) {
				System.out.println("0 " + y);
				System.err.println("0 " + y);
				String answer = scanner.next();
				System.err.println(answer);
				if ("MISS".equals(answer)) {
					foundY = y;
					y = DIX9 + 1;
				}
			}
			System.err.println("FoundY " + foundY);
			int foundX = DIX9;
			int minX = DIX9 - 101;
			int maxX = DIX9;
			for (int x = minX; x < maxX; x++) {
				System.out.println(x+ " 0");
				System.err.println(x+ " 0");
				String answer = scanner.next();
				System.err.println(answer);
				if ("MISS".equals(answer)) {
					foundX = x;
					x = DIX9 + 1;
				}
			}
			System.err.println("FoundX " + foundX);
			for (int x = foundX - A - 4; x <= foundX - A + 4; x++) {
				for (int y = foundY - A - 4; y <= foundY - A + 4; y++) {
					System.out.println(x + " " + y);
					System.err.println(x + " " + y);
					String answer = scanner.next();
					System.err.println(answer);
					if ("CENTER".equals(answer)) {
						x = DIX9;
						y = DIX9;
					}
				}
			}
		}
		return;
	}
	
	
}
