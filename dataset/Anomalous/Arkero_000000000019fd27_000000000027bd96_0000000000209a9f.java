import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = Integer.parseInt(scanner.nextLine().trim());

        StringBuilder output = new StringBuilder();

        for (int testCase = 1; testCase <= numberOfTests; ++testCase) {
            String inputLine = scanner.nextLine().trim();
            output.append("Case #").append(testCase).append(": ").append(formatLine(inputLine)).append("\n");
        }
        System.out.print(output);
    }

    static String formatLine(String input) {
        StringBuilder formattedLine = new StringBuilder();
        int length = input.length();
        char previousChar = '\0';
        int count = 0;

        for (int i = 0; i <= length; i++) {
            if (i < length && (input.charAt(i) == previousChar || previousChar == '\0')) {
                count++;
            } else {
                if (previousChar != '\0') {
                    int digit = Character.getNumericValue(previousChar);
                    appendRepeatedChars(formattedLine, digit, '(');
                    appendRepeatedChars(formattedLine, count, previousChar);
                    appendRepeatedChars(formattedLine, digit, ')');
                }
                count = 1;
            }

            if (i < length) {
                previousChar = input.charAt(i);
            }
        }
        return formattedLine.toString();
    }

    static void appendRepeatedChars(StringBuilder builder, int times, char character) {
        for (int i = 0; i < times; i++) {
            builder.append(character);
        }
    }
}