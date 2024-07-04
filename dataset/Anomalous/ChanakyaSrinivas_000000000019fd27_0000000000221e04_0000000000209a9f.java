import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            
            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i) - '0';
                
                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                
                result.append(input.charAt(i));
            }
            
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
        
        scanner.close();
    }
}