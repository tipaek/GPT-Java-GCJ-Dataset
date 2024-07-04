import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			String line = bufferedReader.readLine();
			final int numberOfCases = Integer.parseInt(line);

			for (int c = 1; c <= numberOfCases; c++) {
				line = bufferedReader.readLine();
				int size = line.length();
				int[] digits = new int[size];
				for (int i = 0; i < size; i++) {
					digits[i] = Integer.parseInt("" + line.charAt(i));
				}
				String result = "";
				int previousDigit = 0;
				for (int i = 0; i < size; i++) {
					int currentDigit = digits[i];
					if (previousDigit != currentDigit) {
						if (previousDigit > currentDigit) {
							int total = previousDigit - currentDigit;
							for (int j = 0; j < total; j++) {
								result += ")";
							}
						} else {
							int total = currentDigit - previousDigit;
							for (int j = 0; j < total; j++) {
								result += "(";
							}
						}
						previousDigit = currentDigit;
					}
					result += currentDigit;
				}
				for (int j = 0; j < previousDigit; j++) {
					result += ")";
				}

				System.out.println("Case #" + c + ": " + result);
			}
		}
	}
}
