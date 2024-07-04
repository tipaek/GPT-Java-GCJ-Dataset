import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = Integer.parseInt(scanner.nextLine().trim());
            StringBuilder output = new StringBuilder();

            for (int i = 1; i <= testCases; i++) {
                String inputLine = scanner.nextLine().trim();
                output.append("Case #").append(i).append(": ").append(formatLine(inputLine)).append("\n");
            }
            System.out.print(output);
        }
    }

    private static String formatLine(String line) {
        StringBuilder result = new StringBuilder();
        int length = line.length();
        int currentIndex = 0;
        char currentChar = ' ';
        int repeatCount = 0;
        int previousDigit = 0;

        while (currentIndex <= length) {
            if (currentIndex < length && (line.charAt(currentIndex) == currentChar || currentChar == ' ')) {
                repeatCount++;
            } else {
                int currentDigit = Character.getNumericValue(currentChar);
                int parenthesesDelta = currentDigit - previousDigit;

                if (parenthesesDelta > 0) {
                    appendChars(result, parenthesesDelta, '(');
                } else {
                    appendChars(result, -parenthesesDelta, ')');
                }

                appendChars(result, repeatCount, currentChar);

                previousDigit = currentDigit;
                repeatCount = 1;
            }

            if (currentIndex < length) {
                currentChar = line.charAt(currentIndex);
            }
            currentIndex++;
        }

        appendChars(result, previousDigit, ')');
        return result.toString();
    }

    private static void appendChars(StringBuilder builder, int count, char character) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}