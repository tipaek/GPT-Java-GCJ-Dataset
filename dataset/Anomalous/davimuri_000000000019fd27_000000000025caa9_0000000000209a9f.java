import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        Solution solution = new Solution();
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            String inputDigits = scanner.next();
            String result = solution.generateNestingDepth(inputDigits);
            System.out.printf("Case #%d: %s%n", testCase, result);
        }
    }

    private String generateNestingDepth(String digits) {
        StringBuilder resultBuilder = new StringBuilder();
        int previousDigit = Character.getNumericValue(digits.charAt(0));
        addCharacters('(', previousDigit, resultBuilder);
        resultBuilder.append(previousDigit);
        
        for (int index = 1; index < digits.length(); index++) {
            int currentDigit = Character.getNumericValue(digits.charAt(index));
            int difference = currentDigit - previousDigit;

            if (difference > 0) {
                addCharacters('(', difference, resultBuilder);
            } else if (difference < 0) {
                addCharacters(')', -difference, resultBuilder);
            }

            resultBuilder.append(currentDigit);
            previousDigit = currentDigit;
        }

        addCharacters(')', previousDigit, resultBuilder);
        return resultBuilder.toString();
    }

    private void addCharacters(char character, int count, StringBuilder builder) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}