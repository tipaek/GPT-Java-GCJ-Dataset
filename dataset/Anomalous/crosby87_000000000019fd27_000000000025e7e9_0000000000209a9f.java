import java.util.Scanner;

public class Solution {
    
    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static void printParentheses(int n) {
        char parenthesis = n > 0 ? ')' : '(';
        for (int i = 0; i < Math.abs(n); i++) {
            System.out.print(parenthesis);
        }
    }

    public static int[] extractDigits(String numberStr) {
        return numberStr.chars().map(c -> c - '0').toArray();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String inputStr = scanner.next();
            int[] digits = extractDigits(inputStr);
            int[] differences = new int[digits.length + 1];
            
            differences[0] = -digits[0];
            for (int i = 1; i < digits.length; i++) {
                differences[i] = digits[i - 1] - digits[i];
            }
            differences[digits.length] = digits[digits.length - 1];

            System.out.print("Case #" + caseNum + ": ");
            for (int i = 0; i < digits.length; i++) {
                printParentheses(differences[i]);
                System.out.print(digits[i]);
            }
            printParentheses(differences[digits.length]);
            System.out.println();
        }

        scanner.close();
    }
}