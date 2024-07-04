import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            
            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i) - '0';
                int depthChange = digit - currentDepth;
                
                if (depthChange > 0) {
                    for (int j = 0; j < depthChange; j++) {
                        result.append('(');
                    }
                } else if (depthChange < 0) {
                    for (int j = 0; j < -depthChange; j++) {
                        result.append(')');
                    }
                }
                
                result.append(digit);
                currentDepth = digit;
            }
            
            for (int j = 0; j < currentDepth; j++) {
                result.append(')');
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
        
        scanner.close();
    }
}