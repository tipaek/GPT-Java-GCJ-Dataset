import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCaseCount; i++) {
            String inputLine = scanner.nextLine();
            processTestCase(inputLine, i);
        }
    }

    private static void processTestCase(String input, int caseNumber) {
        char[] characters = input.toCharArray();
        StringBuilder result = new StringBuilder();

        if (characters[0] != '0') {
            int initialDigit = characters[0] - '0';
            appendBrackets(initialDigit, true, result);
            result.append(characters[0]);
        } else {
            result.append("0");
        }

        for (int i = 1; i < characters.length; i++) {
            if (characters[i] == characters[i - 1]) {
                result.append(characters[i]);
                continue;
            }

            int previousDigit = characters[i - 1] - '0';
            int currentDigit = characters[i] - '0';

            if (currentDigit > previousDigit) {
                appendBrackets(currentDigit - previousDigit, true, result);
            } else {
                appendBrackets(previousDigit - currentDigit, false, result);
            }
            result.append(characters[i]);
        }

        appendBrackets(characters[characters.length - 1] - '0', false, result);
        System.out.println("Case #" + caseNumber + ": " + result);
    }

    private static void appendBrackets(int count, boolean isOpen, StringBuilder stringBuilder) {
        char bracket = isOpen ? '(' : ')';
        for (int i = 0; i < count; i++) {
            stringBuilder.append(bracket);
        }
    }
}