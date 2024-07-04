import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of test cases
        int n = Integer.parseInt(scanner.nextLine());
        String[] output = new String[n];
        
        for (int i = 0; i < n; i++) {
            // Read input i+1
            String nextLine = scanner.nextLine();
            output[i] = "Case #" + (i + 1) + ": " + generateNestedDepth(nextLine);
        }
        
        // Print output
        for (String result : output) {
            System.out.println(result);
        }
        
        // Close scanner
        scanner.close();
    }

    private static String generateNestedDepth(String inputStr) {
        int currentDepth = 0;
        StringBuilder sb = new StringBuilder();
        
        for (char ch : inputStr.toCharArray()) {
            int currentDigit = Character.getNumericValue(ch);
            adjustNesting(sb, currentDigit, currentDepth);
            currentDepth = currentDigit;
            sb.append(ch);
        }
        
        while (currentDepth > 0) {
            sb.append(')');
            currentDepth--;
        }
        
        return sb.toString();
    }
    
    private static void adjustNesting(StringBuilder sb, int targetDepth, int currentDepth) {
        while (currentDepth < targetDepth) {
            sb.append('(');
            currentDepth++;
        }
        while (currentDepth > targetDepth) {
            sb.append(')');
            currentDepth--;
        }
    }
}