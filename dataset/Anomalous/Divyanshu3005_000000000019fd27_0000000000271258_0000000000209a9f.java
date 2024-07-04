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
                int digit = Character.getNumericValue(input.charAt(i));
                
                if (i == 0) {
                    result.append("(".repeat(digit));
                    currentDepth = digit;
                } else {
                    int depthChange = digit - currentDepth;
                    if (depthChange > 0) {
                        result.append("(".repeat(depthChange));
                    } else {
                        result.append(")".repeat(-depthChange));
                    }
                    currentDepth = digit;
                }
                
                result.append(digit);
            }
            
            result.append(")".repeat(currentDepth));
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }
}