import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            
            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i) - '0';
                int depthDifference = digit - currentDepth;
                
                if (depthDifference > 0) {
                    for (int j = 0; j < depthDifference; j++) {
                        result.append('(');
                    }
                } else if (depthDifference < 0) {
                    for (int j = 0; j < -depthDifference; j++) {
                        result.append(')');
                    }
                }
                
                result.append(digit);
                currentDepth = digit;
            }
            
            for (int j = 0; j < currentDepth; j++) {
                result.append(')');
            }
            
            System.out.println("Case #" + caseIndex + ": " + result.toString());
        }
        
        scanner.close();
    }
}