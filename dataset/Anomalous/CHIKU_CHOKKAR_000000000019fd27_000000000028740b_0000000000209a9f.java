import java.util.Scanner;

public class Main {

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

        int currentNum = Character.getNumericValue(characters[0]);
        int openBrackets = currentNum;

        // Append initial open brackets and the first number
        for (int i = 0; i < currentNum; i++) {
            result.append("(");
        }
        result.append(currentNum);

        for (int i = 1; i < characters.length; i++) {
            int nextNum = Character.getNumericValue(characters[i]);

            if (nextNum > currentNum) {
                // Append additional open brackets
                for (int j = 0; j < nextNum - currentNum; j++) {
                    result.append("(");
                }
                openBrackets += nextNum - currentNum;
            } else if (nextNum < currentNum) {
                // Append closing brackets
                for (int j = 0; j < currentNum - nextNum; j++) {
                    result.append(")");
                }
                openBrackets -= currentNum - nextNum;
            }

            result.append(nextNum);
            currentNum = nextNum;
        }

        // Append remaining closing brackets
        for (int i = 0; i < openBrackets; i++) {
            result.append(")");
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }
}