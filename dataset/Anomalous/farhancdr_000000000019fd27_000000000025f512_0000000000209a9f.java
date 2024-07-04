import java.util.Scanner;

public class Solution {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            solve();
        }
    }

    private static void solve() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();
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
                    openBrackets++;
                }
            } else if (nextNumber < currentNumber) {
                for (int j = 0; j < currentNumber - nextNumber; j++) {
                    result.append(')');
                    openBrackets--;
                }
            }
            result.append(nextNumber);
            currentNumber = nextNumber;
        }

        for (int i = 0; i < openBrackets; i++) {
            result.append(')');
        }

        System.out.println(result.toString());
    }
}