import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.next();
            processCase(inputString, i);
        }
        
        scanner.close();
    }

    private static void processCase(String inputString, int caseNumber) {
        int currentDepth = 0;
        StringBuilder result = new StringBuilder();
        
        for (char digitChar : inputString.toCharArray()) {
            int digit = digitChar - '0';
            
            while (digit > currentDepth) {
                result.append("(");
                currentDepth++;
            }
            
            while (digit < currentDepth) {
                result.append(")");
                currentDepth--;
            }
            
            result.append(digitChar);
        }
        
        while (currentDepth > 0) {
            result.append(")");
            currentDepth--;
        }
        
        System.out.println(String.format("Case #%d: %s", caseNumber, result.toString()));
    }
}