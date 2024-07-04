import java.util.Scanner;

public class Main {
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
        char[] digits = input.toCharArray();

        int currentNumber = Character.getNumericValue(digits[0]);
        int openBrackets = currentNumber;

        appendCharacters(result, '(', currentNumber);
        result.append(currentNumber);

        for (int i = 1; i < digits.length; i++) {
            int nextNumber = Character.getNumericValue(digits[i]);
            if (nextNumber > currentNumber) {
                appendCharacters(result, '(', nextNumber - currentNumber);
            } else if (nextNumber < currentNumber) {
                appendCharacters(result, ')', currentNumber - nextNumber);
            }
            result.append(nextNumber);
            currentNumber = nextNumber;
        }

        appendCharacters(result, ')', openBrackets);
        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }

    private static void appendCharacters(StringBuilder sb, char character, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
    }
}