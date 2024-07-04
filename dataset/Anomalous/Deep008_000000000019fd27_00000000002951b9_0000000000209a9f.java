import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; ++t) {
            String digits = scanner.next();
            int length = digits.length();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            
            for (int i = 0; i < length; i++) {
                int digit = digits.charAt(i) - '0';
                
                while (digit > currentDepth) {
                    result.append("(");
                    currentDepth++;
                }
                
                while (digit < currentDepth) {
                    result.append(")");
                    currentDepth--;
                }
                
                result.append(digit);
            }
            
            while (currentDepth > 0) {
                result.append(")");
                currentDepth--;
            }
            
            System.out.println("Case #" + t + ": " + result.toString());
        }
        
        scanner.close();
    }
}