import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		
		String s;
		for (int i = 1; i <= t; i++) {
			s = in.nextLine().trim();
			String res = solve(s.toCharArray());

			System.out.println("Case #" + i + ": " + res);
		}

		in.close();
	}

	private static String solve(char[] s) {
		StringBuilder res = new StringBuilder();

		int openBrackets = 0;
		int neededOpenBrackets = 0;
		int closingDiff = 0;

		int currNum, prevNum;
		for (int i = 0; i < s.length; i++) {
			if (i != 0) {
				// Handle the close brackets

				currNum = getNum(s[i]);
				prevNum = getNum(s[i - 1]);
				if (currNum == prevNum) {
					// Case current num == prev
					while (i < s.length && (currNum = getNum(s[i])) == prevNum) {
						res.append(s[i]);
						i++;
					}
					i--;
					continue;
				} else if (currNum > prevNum) {
					neededOpenBrackets = currNum - openBrackets;

					while (neededOpenBrackets > 0) {
						res.append('(');
						neededOpenBrackets--;
						openBrackets++;
					}
				} else if (currNum < prevNum) {
					closingDiff = openBrackets - currNum;

					while (closingDiff > 0) {
						res.append(')');
						closingDiff--;
						openBrackets--;
					}
				}

			}
			
			// Handle the open brackets
			neededOpenBrackets = getNum(s[i]) - openBrackets;

			while (neededOpenBrackets > 0) {
				res.append('(');
				neededOpenBrackets--;
				openBrackets++;
			}

			res.append(s[i]);
		}

		while (openBrackets > 0) {
			res.append(')');
			openBrackets--;
		}

		return res.toString();
	}

	private static int getNum(char c) {
		return c - '0';
	}

}
