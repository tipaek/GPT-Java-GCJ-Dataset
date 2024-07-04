import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
	Scanner input;
	PrintStream output;

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		PrintStream output = System.out;
		int numCases = input.nextInt();

		for (int t = 0; t < numCases; t++) {
			output.printf("Case #%d: ", t + 1);
			output.println(new Solution(input, output).solve());
		}

		input.close();
		output.close();

		System.exit(0);
	}
	
	public Solution(Scanner input, PrintStream output) {
		this.input = input;
		this.output = output;
	}

	public String solve() {
		String s = input.next();
		StringBuilder sb = new StringBuilder();
		int openParenthesis = 0;
		
		for (int i = 0; i < s.length(); i++) {
			int n = Integer.parseInt(s.substring(i, i + 1));
			
			if (n > openParenthesis) {
				while (openParenthesis < n) {
					sb.append("(");
					openParenthesis++;
				}
			} else if (n < openParenthesis) {
				while (openParenthesis > n) {
					sb.append(")");
					openParenthesis--;
				}
			}
			
			sb.append(String.valueOf(n));
		}
		
		while (openParenthesis > 0) {
			sb.append(")");
			openParenthesis--;
		}
		
		return sb.toString();
	}
}