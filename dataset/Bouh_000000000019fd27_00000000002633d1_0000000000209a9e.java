import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		solveProblem(in);
	}

	public static void solveProblem(Scanner scanner) {
		int t = scanner.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			int n = scanner.nextInt();
		}
	}
	
	public static void solveCase(Scanner scanner, int n) {
		List<Integer> intes = new ArrayList<>();
		for (int i = 1; i <=n; i++) {
			System.out.println(i);
			intes.add(scanner.nextInt());
		}
		String result = "";
		for(Integer inte : intes) {
			result+= inte.toString();
		}
		System.out.println(result);
		String reponse = scanner.next();
		if ("N".equals(reponse)) {
			throw new RuntimeException("Oups");
		}
	}


	
}
