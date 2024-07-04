import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();
        
        int currentNumber = 0;
        int openBrackets = 0;
        
        int firstDigit = Character.getNumericValue(characters[0]);
        currentNumber = firstDigit;
        openBrackets = firstDigit;
        
        for (int i = 0; i < firstDigit; i++) {
            result.append('(');
        }
        result.append(firstDigit);
        
        for (int i = 1; i < characters.length; i++) {
            int digit = Character.getNumericValue(characters[i]);
            
            if (digit == currentNumber) {
                result.append(digit);
            } else if (digit > currentNumber) {
                int difference = digit - currentNumber;
                for (int j = 0; j < difference; j++) {
                    result.append('(');
                    openBrackets++;
                }
                result.append(digit);
            } else {
                int difference = currentNumber - digit;
                for (int j = 0; j < difference; j++) {
                    result.append(')');
                    openBrackets--;
                }
                result.append(digit);
            }
            
            currentNumber = digit;
        }
        
        while (openBrackets-- > 0) {
            result.append(')');
        }
        
        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }
}