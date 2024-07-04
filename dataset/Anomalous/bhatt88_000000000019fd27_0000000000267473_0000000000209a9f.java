import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(br.readLine());

            for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
                String inputLine = "0" + br.readLine() + "0";
                StringBuilder result = new StringBuilder();
                int inputLength = inputLine.length();

                for (int i = 1; i < inputLength; i++) {
                    int currentDigit = Character.getNumericValue(inputLine.charAt(i));
                    int previousDigit = Character.getNumericValue(inputLine.charAt(i - 1));

                    if (currentDigit != previousDigit) {
                        char parenthesis = (currentDigit > previousDigit) ? '(' : ')';
                        for (int j = 0; j < Math.abs(currentDigit - previousDigit); j++) {
                            result.append(parenthesis);
                        }
                    }

                    if (i != inputLength - 1) {
                        result.append(currentDigit);
                    }
                }

                System.out.println("Case #" + (caseIndex + 1) + ": " + result.toString());
            }
        }
    }
}