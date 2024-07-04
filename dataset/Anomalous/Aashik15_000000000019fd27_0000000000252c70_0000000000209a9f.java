import java.util.Scanner;

public class Solution {

    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine();

        while (testCases-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();

        int currentValue = Character.getNumericValue(characters[0]);
        int openBrackets = currentValue;

        appendCharacters(result, '(', currentValue);
        result.append(currentValue);

        for (int i = 1; i < characters.length; i++) {
            int nextValue = Character.getNumericValue(characters[i]);

            if (nextValue > currentValue) {
                appendCharacters(result, '(', nextValue - currentValue);
                openBrackets += nextValue - currentValue;
            } else if (nextValue < currentValue) {
                appendCharacters(result, ')', currentValue - nextValue);
                openBrackets -= currentValue - nextValue;
            }

            result.append(nextValue);
            currentValue = nextValue;
        }

        appendCharacters(result, ')', openBrackets);

        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }

    private static void appendCharacters(StringBuilder builder, char character, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}