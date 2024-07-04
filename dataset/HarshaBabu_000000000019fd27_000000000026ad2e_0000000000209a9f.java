
import java.io.*;
import java.util.*;



public class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		solve(br);
	}

	public static void solve(BufferedReader br) throws IOException {
		int numberOfTestCases = Integer.parseInt(br.readLine());
		for (int i = 1; i <= numberOfTestCases; i++) {

			String input = br.readLine();
			//System.out.println(input);

			StringBuilder output = new StringBuilder();
			int prevdigit = 0;
			List<Integer> digits = new ArrayList<Integer>();
			for (int j = 0; j < input.length(); j++) {

				int digit = getDigit(input, j);

				int preAppenderCount = 0;
				int postAppenderCount = 0;

				digits.add(digit);
				if (prevdigit < digit) {

					if (output.length() > 0) {
						output = postAppenderLP(output, digit);
					} else {
						output = preAppenderLP(output, digit);
					}

					output.append(digit);
				} else if (prevdigit > digit) {

					long LpCount = getLpCount(output.toString());
					long rpCount = getRpCount(output.toString());

					long rp = LpCount - rpCount;

					if (rp > digit) {
						output = postAppenderRP(output, rp);
					}

					output.append(digit);
				} else {
					output.append(digit);
				}
				prevdigit = digit;
			}

			long LpCount = getLpCount(output.toString());
			long rpCount = getRpCount(output.toString());

			long rp = LpCount - rpCount;

			if (rp > 0) {
				output = postAppenderRP(output, rp);
			}

			System.out.println("Case #" + i + ": " + output);
		}
	}

	public static long getLpCount(String input) {

		return input.chars().filter(ch -> ch == '(').count();
	}

	public static long getRpCount(String input) {

		return input.chars().filter(ch -> ch == ')').count();
	}

	public static Integer getDigit(String input, int index) {
		Character ch = input.charAt(index);
		int digit = Integer.parseInt(String.valueOf(ch));
		return digit;
	}

	public static StringBuilder preAppenderLP(StringBuilder input, long rp) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < rp; i++) {
			s.append("(");
		}

		return s.append(input);
	}

	public static StringBuilder postAppenderRP(StringBuilder input, long rp) {
		StringBuilder s = new StringBuilder();
		s.append(input);
		for (int i = 0; i < rp; i++) {
			s.append(")");
		}
		return s;
	}

	public static StringBuilder preAppenderRP(StringBuilder input, int count) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < count; i++) {
			s.append(")");
		}

		return s.append(input);
	}

	public static StringBuilder postAppenderLP(StringBuilder input, long rp) {
		StringBuilder s = new StringBuilder();
		s.append(input);
		for (int i = 0; i < rp; i++) {
			s.append("(");
		}
		return s;
	}
}
