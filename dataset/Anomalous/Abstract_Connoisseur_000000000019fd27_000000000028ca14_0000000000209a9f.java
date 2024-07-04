import java.util.Scanner;

public class Solution {
    private static Scanner sc = new Scanner(System.in);
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        sc.nextLine();

        while (testCases-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();

        int currentNumber = Character.getNumericValue(characters[0]);
        int openBrackets = currentNumber;

        appendBrackets(result, currentNumber, '(');
        result.append(currentNumber);

        for (int i = 1; i < characters.length; i++) {
            int nextNumber = Character.getNumericValue(characters[i]);

            if (nextNumber > currentNumber) {
                appendBrackets(result, nextNumber - currentNumber, '(');
            } else if (nextNumber < currentNumber) {
                appendBrackets(result, currentNumber - nextNumber, ')');
            }

            result.append(nextNumber);
            currentNumber = nextNumber;
        }

        appendBrackets(result, openBrackets, ')');
        System.out.println("Case #" + (testCaseNumber++) + ": " + result);
    }

    private static void appendBrackets(StringBuilder result, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            result.append(bracket);
        }
    }
}