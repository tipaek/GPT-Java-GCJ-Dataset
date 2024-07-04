import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;
        
        while (testCases-- > 0) {
            String input = scanner.next();
            String result = processString(input);
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }
    
    public static String processString(String input) {
        StringBuilder output = new StringBuilder();
        int currentDepth = 0;
        
        for (char c : input.toCharArray()) {
            int digit = c - '0';
            int depthChange = digit - currentDepth;
            
            if (depthChange > 0) {
                for (int i = 0; i < depthChange; i++) {
                    output.append('(');
                }
            } else {
                for (int i = 0; i < -depthChange; i++) {
                    output.append(')');
                }
            }
            output.append(c);
            currentDepth = digit;
        }
        
        for (int i = 0; i < currentDepth; i++) {
            output.append(')');
        }
        
        return output.toString();
    }
}