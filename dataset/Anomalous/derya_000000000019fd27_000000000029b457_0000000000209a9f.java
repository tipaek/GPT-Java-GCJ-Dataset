import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Solution {
    private static final PrintStream OUTPUT = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            char[] digits = scanner.nextLine().toCharArray();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (char digitChar : digits) {
                int digit = Character.getNumericValue(digitChar);

                if (digit > openBrackets) {
                    appendCharacters(result, '(', digit - openBrackets);
                    openBrackets = digit;
                } else if (digit < openBrackets) {
                    appendCharacters(result, ')', openBrackets - digit);
                    openBrackets = digit;
                }
                result.append(digitChar);
            }

            appendCharacters(result, ')', openBrackets);

            OUTPUT.printf("Case #%d: %s%n", testCase, result.toString());
        }
    }

    private static void appendCharacters(StringBuilder builder, char character, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}