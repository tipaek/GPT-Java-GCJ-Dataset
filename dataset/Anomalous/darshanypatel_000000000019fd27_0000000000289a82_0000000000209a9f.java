import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static final String PLACEHOLDER = "x";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String inputString = reader.readLine();
            String processedResult = processString(inputString);
            String finalResult = replacePlaceholders(processedResult, inputString);

            System.out.printf("Case #%d: %s%n", t, finalResult);
        }
    }

    private static String processString(String input) {
        if (areAllZeros(input)) {
            return String.join("", Collections.nCopies(input.length(), PLACEHOLDER));
        }

        if (input.length() == 1) {
            int number = Integer.parseInt(input);
            return String.join("", Collections.nCopies(number, "(")) + PLACEHOLDER + String.join("", Collections.nCopies(number, ")"));
        }

        if (input.contains("0")) {
            return handleZeros(input);
        }

        int minDigit = findMinimumDigit(input);
        String reducedString = subtractValueFromString(input, minDigit);

        return String.join("", Collections.nCopies(minDigit, "(")) + processString(reducedString) + String.join("", Collections.nCopies(minDigit, ")"));
    }

    private static boolean areAllZeros(String input) {
        for (char ch : input.toCharArray()) {
            if (ch != '0') {
                return false;
            }
        }
        return true;
    }

    private static String handleZeros(String input) {
        Pattern pattern = Pattern.compile("0+|[1-9]+");
        Matcher matcher = pattern.matcher(input);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            result.append(processString(matcher.group()));
        }

        return result.toString();
    }

    private static int findMinimumDigit(String input) {
        int minDigit = 10;
        for (char ch : input.toCharArray()) {
            int digit = ch - '0';
            if (digit < minDigit) {
                minDigit = digit;
            }
        }
        return minDigit;
    }

    private static String subtractValueFromString(String input, int value) {
        StringBuilder result = new StringBuilder();
        for (char ch : input.toCharArray()) {
            result.append(ch - '0' - value);
        }
        return result.toString();
    }

    private static String replacePlaceholders(String result, String original) {
        int index = 0;
        StringBuilder finalResult = new StringBuilder(result);

        for (int i = 0; i < finalResult.length(); i++) {
            if (finalResult.charAt(i) == PLACEHOLDER.charAt(0)) {
                finalResult.setCharAt(i, original.charAt(index++));
            }
        }

        return finalResult.toString();
    }
}