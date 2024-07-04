import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= testCases; t++) {
            String input = br.readLine();
            int[] digits = new int[input.length()];
            
            for (int i = 0; i < input.length(); i++) {
                digits[i] = Character.getNumericValue(input.charAt(i));
            }
            
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            
            for (int i = 0; i < digits.length; i++) {
                while (currentDepth < digits[i]) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digits[i]) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(digits[i]);
            }
            
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }
            
            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}