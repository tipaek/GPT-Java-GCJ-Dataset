import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            
            for (int j = 0; j < input.length(); j++) {
                int digit = Character.getNumericValue(input.charAt(j));
                
                if (digit > currentDepth) {
                    result.append("(".repeat(digit - currentDepth));
                    currentDepth = digit;
                } else if (digit < currentDepth) {
                    result.append(")".repeat(currentDepth - digit));
                    currentDepth = digit;
                }
                
                result.append(digit);
            }
            
            result.append(")".repeat(currentDepth));
            System.out.println("Case #" + i + ": " + result.toString());
        }
        
        scanner.close();
    }
}