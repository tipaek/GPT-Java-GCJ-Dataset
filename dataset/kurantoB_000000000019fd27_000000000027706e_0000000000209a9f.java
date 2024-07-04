import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = in.nextInt();
		for (int i = 1; i <= numCases; i++) {
			System.out.println("Case #" + i + ": " + processProblem(in));
		}
		in.close();
	}

	private static String processProblem(Scanner in) {
		return solve(in.nextLine());
	}
	
	private static String solve(String inString) {
		StringBuilder sb = new StringBuilder();
		int depth = 0;
		for (int i = 0; i < inString.length(); i++) {
			int val = Integer.parseInt(inString.substring(i, i + 1));
			if (val > depth) {
				int diff = val - depth;
				for (int j = 0; j < diff; j++) {
					sb.append('(');
					depth++;
				}
			} else {
				int diff = depth - val;
				for (int j = 0; j < diff; j++) {
					sb.append(')');
					depth--;
				}
			}
			sb.append(String.valueOf(val));
		}
		for (int j = 0; j < depth; j++) {
			sb.append(')');
		}
		return sb.toString();
	}

}
