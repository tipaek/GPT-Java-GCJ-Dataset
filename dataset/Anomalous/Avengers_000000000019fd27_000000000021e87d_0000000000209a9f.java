import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = reader.readLine();
            String result = transformString(input);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    public static String transformString(String input) {
        StringBuilder result = new StringBuilder();
        int previousDigit = 0;

        for (char ch : input.toCharArray()) {
            int currentDigit = Character.getNumericValue(ch);
            int difference = currentDigit - previousDigit;

            if (difference > 0) {
                result.append("(".repeat(difference));
            } else if (difference < 0) {
                result.append(")".repeat(-difference));
            }

            result.append(ch);
            previousDigit = currentDigit;
        }

        result.append(")".repeat(previousDigit));
        return result.toString();
    }
}