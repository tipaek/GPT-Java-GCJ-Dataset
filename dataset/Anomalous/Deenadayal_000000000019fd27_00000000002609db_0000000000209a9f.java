import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.nextLine();

        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();

        int currentNumber = Character.getNumericValue(characters[0]);
        int openBrackets = currentNumber;

        appendCharacters(result, '(', currentNumber);
        result.append(currentNumber);

        for (int i = 1; i < characters.length; i++) {
            int nextNumber = Character.getNumericValue(characters[i]);
            int difference = nextNumber - currentNumber;

            if (difference > 0) {
                appendCharacters(result, '(', difference);
                openBrackets += difference;
            } else if (difference < 0) {
                appendCharacters(result, ')', -difference);
                openBrackets += difference;
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