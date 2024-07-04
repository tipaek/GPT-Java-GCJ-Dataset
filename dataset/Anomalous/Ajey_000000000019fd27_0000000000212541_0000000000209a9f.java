import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            int length = input.length();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            
            for (int i = 0; i < length; i++) {
                int digit = input.charAt(i) - '0';
                
                if (i == 0) {
                    result.append("(".repeat(digit)).append(digit);
                    currentDepth = digit;
                } else {
                    if (currentDepth > digit) {
                        result.append(")".repeat(currentDepth - digit)).append(digit);
                    } else {
                        result.append("(".repeat(digit - currentDepth)).append(digit);
                    }
                    currentDepth = digit;
                }
                
                if (i == length - 1) {
                    result.append(")".repeat(digit));
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
        
        scanner.close();
    }
}