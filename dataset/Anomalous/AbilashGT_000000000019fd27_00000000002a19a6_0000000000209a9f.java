import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.next();
            String result = calculateNestingDepth(inputString);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String calculateNestingDepth(String input) {
        StringBuilder result = new StringBuilder();
        int previousDepth = 0;
        
        for (char ch : input.toCharArray()) {
            int currentDepth = Character.getNumericValue(ch);
            
            if (currentDepth > previousDepth) {
                for (int j = 0; j < currentDepth - previousDepth; j++) {
                    result.append('(');
                }
            } else if (currentDepth < previousDepth) {
                for (int j = 0; j < previousDepth - currentDepth; j++) {
                    result.append(')');
                }
            }
            
            result.append(ch);
            previousDepth = currentDepth;
        }
        
        // Closing any remaining open parentheses
        for (int j = 0; j < previousDepth; j++) {
            result.append(')');
        }
        
        return result.toString();
    }
}