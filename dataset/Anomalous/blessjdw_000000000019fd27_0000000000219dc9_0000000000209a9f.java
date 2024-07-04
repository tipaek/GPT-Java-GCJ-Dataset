import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            
            for (char digit : input.toCharArray()) {
                int num = digit - '0';
                
                while (currentDepth < num) {
                    result.append('(');
                    currentDepth++;
                }
                
                while (currentDepth > num) {
                    result.append(')');
                    currentDepth--;
                }
                
                result.append(digit);
            }
            
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }
            
            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}