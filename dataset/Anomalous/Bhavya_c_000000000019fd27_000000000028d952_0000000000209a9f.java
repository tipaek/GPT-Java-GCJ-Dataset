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
        StringBuilder output = new StringBuilder();
        char[] characters = input.toCharArray();

        int currentNumber = Character.getNumericValue(characters[0]);
        int openBrackets = currentNumber;

        appendCharacters(output, '(', currentNumber);
        output.append(currentNumber);

        for (int i = 1; i < characters.length; i++) {
            int nextNumber = Character.getNumericValue(characters[i]);

            if (nextNumber > currentNumber) {
                appendCharacters(output, '(', nextNumber - currentNumber);
            } else if (nextNumber < currentNumber) {
                appendCharacters(output, ')', currentNumber - nextNumber);
            }

            output.append(nextNumber);
            currentNumber = nextNumber;
        }

        appendCharacters(output, ')', openBrackets);
        System.out.println("Case #" + (testCaseNumber++) + ": " + output.toString());
    }

    private static void appendCharacters(StringBuilder builder, char character, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}