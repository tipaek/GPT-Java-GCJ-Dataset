import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            String inputString = scanner.next();
            processString(inputString, t);
        }
        
        scanner.close();
    }

    private static void processString(String input, int caseNumber) {
        int currentDepth = 0;
        StringBuilder result = new StringBuilder();
        
        for (char ch : input.toCharArray()) {
            int digit = ch - '0';
            
            while (digit > currentDepth) {
                result.append('(');
                currentDepth++;
            }
            
            while (digit < currentDepth) {
                result.append(')');
                currentDepth--;
            }
            
            result.append(ch);
        }
        
        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }
        
        System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
    }
}