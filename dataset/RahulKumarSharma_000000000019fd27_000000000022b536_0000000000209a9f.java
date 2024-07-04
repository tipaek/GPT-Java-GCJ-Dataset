import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cases = Integer.parseInt(sc.nextLine());

		for (int cs = 1; cs <= cases; cs++) {

			String input = sc.nextLine();

			char[] inputChars = input.toCharArray();

			StringBuffer output = new StringBuffer();

			boolean isBracketOpen = false;

			for (char inputChar : inputChars) {

				if (inputChar == '1') {

					if (!isBracketOpen) {
						output.append("(");
						isBracketOpen = true;
					}

					output.append(inputChar);
				} else {
					if (isBracketOpen) {
						output.append(")");
						isBracketOpen = false;
					}

					output.append(inputChar);
				}
			}

			if (isBracketOpen)
				output.append(")");

			System.out.println("Case #" + cs + ": " + output);
		}

		sc.close();
	}
}
