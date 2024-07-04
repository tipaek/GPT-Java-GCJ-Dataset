import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            String result = processInput(input);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String processInput(String input) {
        int currentDepth = 0;
        StringBuilder output = new StringBuilder();
        
        for (char digit : input.toCharArray()) {
            int targetDepth = Character.getNumericValue(digit);
            
            while (currentDepth < targetDepth) {
                output.append('(');
                currentDepth++;
            }
            
            while (currentDepth > targetDepth) {
                output.append(')');
                currentDepth--;
            }
            
            output.append(digit);
        }
        
        while (currentDepth > 0) {
            output.append(')');
            currentDepth--;
        }
        
        return output.toString();
    }
}