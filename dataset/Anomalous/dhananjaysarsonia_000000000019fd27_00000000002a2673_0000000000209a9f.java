import java.util.Scanner;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);
    private static int caseNumber = 1;

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        scanner.nextLine();

        while (testCases-- > 0) {
            String input = scanner.nextLine();
            System.out.println("Case #" + (caseNumber++) + ": " + processString(input));
        }
    }

    private static String processString(String input) {
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();
        int currentBalance = 0;
        int previousValue = 0;

        for (char ch : characters) {
            int currentValue = Character.getNumericValue(ch);
            int difference = currentValue - previousValue;

            if (difference > 0) {
                appendCharacters(result, '(', difference);
            } else if (difference < 0) {
                appendCharacters(result, ')', -difference);
            }

            result.append(currentValue);
            previousValue = currentValue;
            currentBalance += difference;
        }

        appendCharacters(result, ')', currentBalance);
        return result.toString();
    }

    private static void appendCharacters(StringBuilder builder, char character, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}