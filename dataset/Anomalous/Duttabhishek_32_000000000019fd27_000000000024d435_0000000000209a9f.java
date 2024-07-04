import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        while (testCases-- > 0) {
            processTestCase();
        }
    }

    private static void processTestCase() {
        String inputString = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = inputString.toCharArray();

        int currentNumber = Character.getNumericValue(characters[0]);
        int openBrackets = currentNumber;

        for (int i = 0; i < currentNumber; i++) {
            result.append('(');
        }
        result.append(currentNumber);

        for (int i = 1; i < characters.length; i++) {
            int nextNumber = Character.getNumericValue(characters[i]);

            if (nextNumber > currentNumber) {
                for (int j = 0; j < nextNumber - currentNumber; j++) {
                    result.append('(');
                }
            } else if (nextNumber < currentNumber) {
                for (int j = 0; j < currentNumber - nextNumber; j++) {
                    result.append(')');
                }
            }

            result.append(nextNumber);
            currentNumber = nextNumber;
        }

        for (int i = 0; i < openBrackets; i++) {
            result.append(')');
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }
}