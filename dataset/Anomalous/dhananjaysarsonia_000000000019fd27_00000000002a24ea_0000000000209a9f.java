import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int caseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        while (testCases-- > 0) {
            String input = scanner.nextLine();
            char[] characters = input.toCharArray();
            StringBuilder result = new StringBuilder();
            int currentDigit = Character.getNumericValue(characters[0]);
            int balance = currentDigit;

            for (int i = 0; i < currentDigit; i++) {
                result.append('(');
            }
            result.append(currentDigit);

            for (int i = 1; i < characters.length; i++) {
                int nextDigit = Character.getNumericValue(characters[i]);

                if (nextDigit > currentDigit) {
                    for (int j = 0; j < nextDigit - currentDigit; j++) {
                        result.append('(');
                        balance++;
                    }
                } else if (nextDigit < currentDigit) {
                    for (int j = 0; j < currentDigit - nextDigit; j++) {
                        result.append(')');
                        balance--;
                    }
                }

                result.append(nextDigit);
                currentDigit = nextDigit;
            }

            for (int i = 0; i < balance; i++) {
                result.append(')');
            }

            System.out.println("Case #" + (caseNumber++) + ": " + result);
        }
    }
}