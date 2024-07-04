import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            int currentDepth = 0;
            StringBuilder result = new StringBuilder();
            
            for (int j = 0; j < input.length(); j++) {
                int digit = input.charAt(j) - '0';
                int difference = digit - currentDepth;
                
                if (difference > 0) {
                    result.append("(".repeat(difference));
                } else if (difference < 0) {
                    result.append(")".repeat(-difference));
                }
                
                result.append(digit);
                currentDepth = digit;
            }
            
            result.append(")".repeat(currentDepth));
            System.out.println("Case #" + i + ": " + result);
        }
        
        scanner.close();
    }
}