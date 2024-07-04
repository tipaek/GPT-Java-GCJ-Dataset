import java.util.Scanner;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        scanner.nextLine();

        while (testCases-- > 0) {
            processTestCase();
        }
    }

    private static void processTestCase() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();

        int currentNumber = Character.getNumericValue(characters[0]);
        int openBrackets = currentNumber;

        appendBrackets(result, '(', currentNumber);
        result.append(currentNumber);

        for (int i = 1; i < characters.length; i++) {
            int nextNumber = Character.getNumericValue(characters[i]);

            if (nextNumber > currentNumber) {
                appendBrackets(result, '(', nextNumber - currentNumber);
            } else if (nextNumber < currentNumber) {
                appendBrackets(result, ')', currentNumber - nextNumber);
            }

            result.append(nextNumber);
            currentNumber = nextNumber;
        }

        appendBrackets(result, ')', openBrackets);

        System.out.println("Case #" + (testCaseNumber++) + ": " + result);
    }

    private static void appendBrackets(StringBuilder sb, char bracket, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(bracket);
        }
    }
}