import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            StringBuilder result = new StringBuilder();
            String input = scanner.next();
            int currentDepth = 0;
            
            for (int i = 0; i < input.length(); i++) {
                int digit = Character.getNumericValue(input.charAt(i));
                int depthChange = digit - currentDepth;
                
                if (depthChange > 0) {
                    result.append("(".repeat(depthChange));
                } else if (depthChange < 0) {
                    result.append(")".repeat(-depthChange));
                }
                
                result.append(digit);
                currentDepth = digit;
            }
            
            result.append(")".repeat(currentDepth));
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }
}