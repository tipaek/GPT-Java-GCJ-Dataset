import java.util.Scanner;

public class Solutions {
    
    private static Scanner scanner;
    private static int caseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        while (testCases-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();

        int currentNumber = Character.getNumericValue(characters[0]);
        int openBrackets = currentNumber;

        // Append initial opening brackets
        for (int i = 0; i < currentNumber; i++) {
            result.append("(");
        }
        result.append(currentNumber);

        for (int i = 1; i < characters.length; i++) {
            int nextNumber = Character.getNumericValue(characters[i]);

            if (nextNumber > currentNumber) {
                // Append opening brackets
                for (int j = 0; j < nextNumber - currentNumber; j++) {
                    result.append("(");
                }
                openBrackets += nextNumber - currentNumber;
            } else if (nextNumber < currentNumber) {
                // Append closing brackets
                for (int j = 0; j < currentNumber - nextNumber; j++) {
                    result.append(")");
                }
                openBrackets -= currentNumber - nextNumber;
            }

            result.append(nextNumber);
            currentNumber = nextNumber;
        }

        // Append remaining closing brackets
        for (int i = 0; i < openBrackets; i++) {
            result.append(")");
        }

        System.out.println("Case #" + (caseNumber++) + ": " + result.toString());
    }
}