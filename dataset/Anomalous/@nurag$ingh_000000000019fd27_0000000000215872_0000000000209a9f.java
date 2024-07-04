import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            String inputString = scanner.next();
            int currentDepth = 0;
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < inputString.length(); i++) {
                int digit = Character.getNumericValue(inputString.charAt(i));
                
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
            
            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }
        
        scanner.close();
    }
}