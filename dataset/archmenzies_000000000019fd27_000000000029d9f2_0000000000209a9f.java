import static java.lang.Character.getNumericValue;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] a) {
		try {
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
			int testCases = parseInt(inputReader.readLine());

			for (int t = 1; t <= testCases; t++) {
				StringBuilder output = new StringBuilder();

				int currentDepth = 0;
				int inputChar;
				while ((inputChar = inputReader.read()) != '\n') {
					int nextDigit = getNumericValue(inputChar);
					while (currentDepth > nextDigit) {
						output.append(")");
						currentDepth--;
					}
					while (currentDepth < nextDigit) {
						output.append("(");
						currentDepth++;
					}
					output.append(nextDigit);
				}
				while (currentDepth > 0) {
					output.append(")");
					currentDepth--;
				}

				System.out.printf("Case #%d: %s%n", t, output.toString());
			}

		} catch (IOException e) {
			 e.printStackTrace();
		}
	}
}
