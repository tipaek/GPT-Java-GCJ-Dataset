import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 0; caseNumber < testCases; caseNumber++) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;
            int openParentheses = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                if (currentDigit > previousDigit) {
                    result.append("(".repeat(currentDigit - previousDigit));
                    openParentheses += currentDigit - previousDigit;
                } else if (currentDigit < previousDigit) {
                    result.append(")".repeat(previousDigit - currentDigit));
                    openParentheses -= previousDigit - currentDigit;
                }
                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            result.append(")".repeat(openParentheses));
            System.out.println("Case #" + (caseNumber + 1) + ": " + result);
        }
        reader.close();
    }
}