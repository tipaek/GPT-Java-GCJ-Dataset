import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int currentDepth = 0;
            StringBuilder result = new StringBuilder();
            String inputString = scanner.next();
            
            for (char ch : inputString.toCharArray()) {
                int digit = ch - '0';
                
                if (currentDepth < digit) {
                    for (int i = 0; i < digit - currentDepth; i++) {
                        result.append('(');
                    }
                } else if (currentDepth > digit) {
                    for (int i = 0; i < currentDepth - digit; i++) {
                        result.append(')');
                    }
                }
                
                result.append(digit);
                currentDepth = digit;
            }
            
            for (int i = 0; i < currentDepth; i++) {
                result.append(')');
            }
            
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
        
        scanner.close();
    }
}