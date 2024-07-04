import java.util.Scanner;

public class Solution {
    private static final String CASE_TEMPLATE = "Case #%d: %s";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next().trim();
            StringBuilder resultBuilder = new StringBuilder();
            int previousDepth = 0;
            
            for (char ch : inputString.toCharArray()) {
                int currentDepth = Character.getNumericValue(ch);
                
                if (currentDepth > previousDepth) {
                    resultBuilder.append("(".repeat(currentDepth - previousDepth));
                } else if (currentDepth < previousDepth) {
                    resultBuilder.append(")".repeat(previousDepth - currentDepth));
                }
                
                resultBuilder.append(ch);
                previousDepth = currentDepth;
            }
            
            resultBuilder.append(")".repeat(previousDepth));
            System.out.printf(CASE_TEMPLATE, caseNumber, resultBuilder.toString());
            System.out.println();
        }
        
        scanner.close();
    }
}