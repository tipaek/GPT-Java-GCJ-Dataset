import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		solveProblem(in);
	}

	public static void solveProblem(Scanner scanner) {
		int t = scanner.nextInt(); 
		int b = scanner.nextInt();
		for (int i = 1; i <= t; ++i) {
			solveCase(scanner, b);
		}
	}
	
	public static void solveCase(Scanner scanner, int b) {
		String result = "";
		for (int i = 1; i <=b; i++) {
			System.out.println(i);
			result+=scanner.next();
		}
		System.out.println(result);
		//System.out.flush();
		String reponse = scanner.next();
		if (!"Y".equals(reponse)) {
			throw new RuntimeException("Oups");
		}
	}


	
}
