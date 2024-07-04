import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        
        for (int o = 1; o <= t; o++) {
            String s = sc.next();
            int[] digits = new int[s.length()];
            
            // Convert string to integer array
            for (int i = 0; i < s.length(); i++) {
                digits[i] = s.charAt(i) - '0';
            }
            
            StringBuilder result = new StringBuilder();
            result.append("Case #").append(o).append(": ");

            // Add opening brackets for the first digit
            for (int i = 0; i < digits[0]; i++) {
                result.append("(");
            }
            
            // Append the first digit
            result.append(digits[0]);
            
            // Traverse through the digits array
            for (int i = 1; i < digits.length; i++) {
                int diff = digits[i] - digits[i - 1];

                // Add appropriate number of brackets based on the difference
                if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        result.append("(");
                    }
                } else if (diff < 0) {
                    for (int j = 0; j < -diff; j++) {
                        result.append(")");
                    }
                }

                // Append the current digit
                result.append(digits[i]);
            }
            
            // Add closing brackets for the last digit
            for (int i = 0; i < digits[digits.length - 1]; i++) {
                result.append(")");
            }
            
            // Print the result for the current test case
            System.out.println(result.toString());
        }
    }
}