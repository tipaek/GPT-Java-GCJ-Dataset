import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int testCases = scanner.nextInt();
            
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                String input = scanner.next();
                StringBuilder result = new StringBuilder();
                int currentDepth = Character.getNumericValue(input.charAt(0));
                
                // Append initial opening parentheses
                for (int i = 0; i < currentDepth; i++) {
                    result.append('(');
                }
                result.append(currentDepth);
                
                int length = input.length();
                for (int i = 1; i < length; i++) {
                    int nextDepth = Character.getNumericValue(input.charAt(i));
                    
                    if (nextDepth > currentDepth) {
                        // Add opening parentheses to match the depth
                        for (int j = currentDepth; j < nextDepth; j++) {
                            result.append('(');
                        }
                    } else if (nextDepth < currentDepth) {
                        // Add closing parentheses to match the depth
                        for (int j = currentDepth; j > nextDepth; j--) {
                            result.append(')');
                        }
                    }
                    result.append(nextDepth);
                    currentDepth = nextDepth;
                }
                
                // Close any remaining open parentheses
                while (currentDepth > 0) {
                    result.append(')');
                    currentDepth--;
                }
                
                System.out.println("Case #" + caseNum + ": " + result.toString());
            }
        }
        scanner.close();
    }
}