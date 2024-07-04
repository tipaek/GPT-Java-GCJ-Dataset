import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;
            
            for (char ch : input.toCharArray()) {
                int digit = ch - '0';
                
                while (currentDepth < digit) {
                    output.append('(');
                    currentDepth++;
                }
                
                while (currentDepth > digit) {
                    output.append(')');
                    currentDepth--;
                }
                
                output.append(ch);
            }
            
            while (currentDepth > 0) {
                output.append(')');
                currentDepth--;
            }
            
            System.out.println("Case #" + i + ": " + output);
        }
    }
}