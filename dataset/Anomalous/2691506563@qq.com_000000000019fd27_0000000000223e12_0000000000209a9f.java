import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int currentDepth = 0;
            StringBuilder result = new StringBuilder();
            String input = scanner.next();
            
            for (char ch : input.toCharArray()) {
                int digit = ch - '0';
                
                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                
                result.append(digit);
            }
            
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }
            
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
        
        scanner.close();
    }
}