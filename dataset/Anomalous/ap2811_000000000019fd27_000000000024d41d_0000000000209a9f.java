import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        
        for (int o = 1; o <= t; o++) {
            String s = sc.next();
            int[] digits = new int[s.length()];
            
            for (int i = 0; i < s.length(); i++) {
                digits[i] = s.charAt(i) - '0';
            }
            
            StringBuilder result = new StringBuilder();
            result.append("Case #").append(o).append(": ");
            
            int currentDepth = 0;
            for (int i = 0; i < digits.length; i++) {
                while (currentDepth < digits[i]) {
                    result.append("(");
                    currentDepth++;
                }
                while (currentDepth > digits[i]) {
                    result.append(")");
                    currentDepth--;
                }
                result.append(digits[i]);
            }
            
            while (currentDepth > 0) {
                result.append(")");
                currentDepth--;
            }
            
            System.out.println(result.toString());
        }
        
        sc.close();
    }
}