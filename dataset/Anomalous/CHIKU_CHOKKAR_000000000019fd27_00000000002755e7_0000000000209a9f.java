import java.util.Scanner;

public class Solutions {
    
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

        int currentNumber = Character.getNumericValue(characters[0]);
        int openBrackets = currentNumber;

        // Append initial open brackets
        for (int i = 0; i < currentNumber; i++) {
            result.append("(");
        }
        result.append(currentNumber);

        for (int i = 1; i < characters.length; i++) {
            int nextNumber = Character.getNumericValue(characters[i]);
            if (nextNumber == currentNumber) {
                result.append(nextNumber);
            } else if (nextNumber > currentNumber) {
                for (int j = 0; j < nextNumber - currentNumber; j++) {
                    result.append("(");
                }
                result.append(nextNumber);
                openBrackets += nextNumber - currentNumber;
            } else {
                for (int j = 0; j < currentNumber - nextNumber; j++) {
                    result.append(")");
                }
                result.append(nextNumber);
                openBrackets -= currentNumber - nextNumber;
            }
            currentNumber = nextNumber;
        }

        // Close remaining open brackets
        for (int i = 0; i < openBrackets; i++) {
            result.append(")");
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }
}