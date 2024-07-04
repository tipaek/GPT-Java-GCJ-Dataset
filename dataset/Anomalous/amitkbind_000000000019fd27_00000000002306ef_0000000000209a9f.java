import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int balance = 0;

            for (int i = input.length() - 1; i >= 0; i--) {
                int digit = Character.getNumericValue(input.charAt(i));

                while (balance < digit) {
                    result.insert(0, ')');
                    balance++;
                }
                while (balance > digit) {
                    result.insert(0, '(');
                    balance--;
                }
                result.insert(0, digit);
            }

            while (balance > 0) {
                result.insert(0, '(');
                balance--;
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }
}