import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int totalTestCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < totalTestCases; i++) {
            processTestCase();
        }
    }

    private static void processTestCase() {
        String inputString = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = inputString.toCharArray();

        int currentNumber = Character.getNumericValue(characters[0]);
        int openBrackets = currentNumber;

        appendCharacters(result, '(', currentNumber);
        result.append(currentNumber);

        for (int i = 1; i < characters.length; i++) {
            int nextNumber = Character.getNumericValue(characters[i]);

            if (nextNumber > currentNumber) {
                appendCharacters(result, '(', nextNumber - currentNumber);
                openBrackets += nextNumber - currentNumber;
            } else if (nextNumber < currentNumber) {
                appendCharacters(result, ')', currentNumber - nextNumber);
                openBrackets -= currentNumber - nextNumber;
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