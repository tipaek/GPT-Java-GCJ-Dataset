import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int totalCases = scanner.nextInt();
        scanner.nextLine();

        while (totalCases-- > 0) {
            processCase();
        }
    }

    private static void processCase() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();

        int currentNumber = Character.getNumericValue(characters[0]);
        int openBrackets = currentNumber;

        result.append("(".repeat(currentNumber)).append(currentNumber);

        for (int i = 1; i < characters.length; i++) {
            int nextNumber = Character.getNumericValue(characters[i]);

            if (nextNumber > currentNumber) {
                result.append("(".repeat(nextNumber - currentNumber));
                openBrackets += (nextNumber - currentNumber);
            } else if (nextNumber < currentNumber) {
                result.append(")".repeat(currentNumber - nextNumber));
                openBrackets -= (currentNumber - nextNumber);
            }

            result.append(nextNumber);
            currentNumber = nextNumber;
        }

        result.append(")".repeat(openBrackets));
        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }
}