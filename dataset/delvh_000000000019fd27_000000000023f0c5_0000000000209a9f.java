import static java.lang.System.out;

import java.util.Scanner;

public class Solution {

	private void solve(Scanner in) throws Exception {
		String			raw				= in.next();
		StringBuilder	sb				= new StringBuilder(raw);
		int				totalInserted	= 0;
		int[]			numbers			= new int[sb.length()];
		// initialization of array
		for (int i = 0; i < raw.length(); i++)
			numbers[i] = Integer.valueOf(raw.substring(i, i + 1));
		// beginning parentheses
		for (int beginningParentheses = 0; beginningParentheses < numbers[0]; beginningParentheses++) {
			sb.insert(0, '(');
			totalInserted++;
		}
		// followup parentheses
		for (int index = 0; index < numbers.length - 1; index++)
			// closing of parentheses if next number is smaller
			if (numbers[index] > numbers[index + 1]) {
				int	difference		= numbers[index] - numbers[index + 1];
				int	currentIndex	= sb.indexOf(String.valueOf(numbers[index + 1]), index + totalInserted);// TODO wrong index (don't ignore
																											// parentheses)
				for (int i = 0; i < difference; i++) {
					sb.insert(currentIndex, ')');
					totalInserted++;
				}
			}
			// opening of parentheses
			else if (numbers[index] < numbers[index + 1]) {
				int	difference		= numbers[index + 1] - numbers[index];
				int	currentIndex	= sb.indexOf(String.valueOf(numbers[index + 1]), index + totalInserted);// TODO wrong index (don't ignore
																											// parentheses)
				for (int i = 0; i < difference; i++) {
					sb.insert(currentIndex++, '(');
					totalInserted++;
				}
			}
		for (int i = 0; i < numbers[numbers.length - 1]; i++)
			sb.append(')');

		System.out.print(sb.toString() + "\n");
	}

	private void run() throws Exception {
		Scanner	in	= new Scanner(System.in);
		int		t	= in.nextInt();
		for (int i = 1; i <= t; ++i) {
			out.printf("Case #%d: ", i);
			solve(in);
		}
		in.close();
	}

	public static void main(String[] args) throws Exception { new Solution().run(); }
}