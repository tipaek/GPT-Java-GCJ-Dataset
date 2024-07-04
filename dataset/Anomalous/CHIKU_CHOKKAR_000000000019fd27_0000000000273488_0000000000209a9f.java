import java.util.Scanner;

public class Solutions {
    
    private static Scanner scanner;
    private static int testCaseNumber = 1;

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
        char[] digits = input.toCharArray();
        
        int currentNumber = Character.getNumericValue(digits[0]);
        int openBrackets = currentNumber;

        appendCharacters(result, '(', openBrackets);
        result.append(currentNumber);

        for (int i = 1; i < digits.length; i++) {
            int nextNumber = Character.getNumericValue(digits[i]);
            if (nextNumber > currentNumber) {
                appendCharacters(result, '(', nextNumber - currentNumber);
            } else if (nextNumber < currentNumber) {
                appendCharacters(result, ')', currentNumber - nextNumber);
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