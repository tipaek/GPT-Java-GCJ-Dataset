import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            
            int currentParenthesisLevel = 0;
            
            for (char ch : input.toCharArray()) {
                int digit = ch - '0';
                
                while (currentParenthesisLevel < digit) {
                    result.append('(');
                    currentParenthesisLevel++;
                }
                
                while (currentParenthesisLevel > digit) {
                    result.append(')');
                    currentParenthesisLevel--;
                }
                
                result.append(digit);
            }
            
            while (currentParenthesisLevel > 0) {
                result.append(')');
                currentParenthesisLevel--;
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
        
        scanner.close();
    }
}