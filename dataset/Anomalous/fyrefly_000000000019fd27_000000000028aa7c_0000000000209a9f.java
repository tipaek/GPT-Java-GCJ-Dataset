import java.util.Scanner;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.nextLine();

        while (t-- > 0) {
            processTestCase();
        }
    }

    private static void processTestCase() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();

        int currentNumber = Character.getNumericValue(input.charAt(0));
        appendBrackets(result, currentNumber, '(');
        result.append(currentNumber);

        for (int i = 1; i < input.length(); i++) {
            int nextNumber = Character.getNumericValue(input.charAt(i));

            if (nextNumber > currentNumber) {
                appendBrackets(result, nextNumber - currentNumber, '(');
            } else if (nextNumber < currentNumber) {
                appendBrackets(result, currentNumber - nextNumber, ')');
            }

            result.append(nextNumber);
            currentNumber = nextNumber;
        }

        appendBrackets(result, currentNumber, ')');
        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }

    private static void appendBrackets(StringBuilder sb, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            sb.append(bracket);
        }
    }
}