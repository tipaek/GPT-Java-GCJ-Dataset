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
        String inputString = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = inputString.toCharArray();
        
        int currentNumber = Character.getNumericValue(characters[0]);
        int openBrackets = currentNumber;

        for (int i = 0; i < currentNumber; i++) {
            result.append("(");
        }
        result.append(currentNumber);

        for (int i = 1; i < characters.length; i++) {
            int digit = Character.getNumericValue(characters[i]);
            if (digit == currentNumber) {
                result.append(digit);
            } else if (digit > currentNumber) {
                for (int j = 0; j < digit - currentNumber; j++) {
                    result.append("(");
                    openBrackets++;
                }
                result.append(digit);
            } else {
                for (int j = 0; j < currentNumber - digit; j++) {
                    result.append(")");
                    openBrackets--;
                }
                result.append(digit);
            }
            currentNumber = digit;
        }

        while (openBrackets-- > 0) {
            result.append(")");
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }
}