import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		solveProblem(in);
	}

	public static void solveProblem(Scanner scanner) {
		int t = scanner.nextInt(); 
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		for (int i = 1; i <= t; ++i) {
			for (int x = -6; x <= 6; x++) {
				for (int y = -6; y <=6; y++) {
					System.out.println(x + " " + y);
					String answer = scanner.next();
					if ("CENTER".equals(answer)) {
						x = 7;
						y = 7;
					}
				}
			}
		}
		return;
	}
	
	
}
