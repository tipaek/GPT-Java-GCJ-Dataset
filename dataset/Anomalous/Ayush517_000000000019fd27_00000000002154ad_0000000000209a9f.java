import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i) - '0';
                
                if (digit > currentDepth) {
                    for (int j = 0; j < digit - currentDepth; j++) {
                        result.append('(');
                    }
                } else if (digit < currentDepth) {
                    for (int j = 0; j < currentDepth - digit; j++) {
                        result.append(')');
                    }
                }
                
                result.append(digit);
                currentDepth = digit;
            }

            for (int i = 0; i < currentDepth; i++) {
                result.append(')');
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }

        scanner.close();
    }
}