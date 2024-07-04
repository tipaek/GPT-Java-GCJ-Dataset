import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String result = solveProblem(in);
		System.out.println(result);
	}

	public static String solveProblem(Scanner scanner) {
		String result = "";
		int t = scanner.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			String S = scanner.next();
			result+="Case #" + i + ": " + solveCase(S) + "\n";
		}

		return result;
	}

	public static String solveCase(String S) {
		String result = "";
		int opening = 0;
		for (int i = 0; i < S.length(); i++) {
			int val = Integer.parseInt(S.substring(i, i+1));
			if (val > opening) {
				int count = val - opening;
				for (int j = 0; j < count; j++) {
					result+="(";
					opening++;
				}
			}
			if (val < opening) {
				int count = opening - val;
				for (int j = 0; j < count; j++) {
					result+=")";
					opening--;
				}
			}
			result+=val;
		}
		for (int i = 0; i < opening; i++) {
			result+=")";
		}
		return result;
	}
	
	
}
