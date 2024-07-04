import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        
        for (int o = 1; o <= t; o++) {
            String s = sc.next();
            int n = Integer.parseInt(s);
            int[] digits = new int[s.length()];
            StringBuilder result = new StringBuilder();
            
            for (int i = s.length() - 1; i >= 0; i--) {
                digits[i] = n % 10;
                n /= 10;
            }
            
            result.append("Case #").append(o).append(": ");
            
            for (int i = 0; i < digits[0]; i++) {
                result.append("(");
            }
            
            for (int i = 0; i < digits.length; i++) {
                if (i > 0) {
                    int diff = digits[i] - digits[i - 1];
                    if (diff > 0) {
                        result.append("(".repeat(diff));
                    } else if (diff < 0) {
                        result.append(")".repeat(-diff));
                    }
                }
                result.append(digits[i]);
            }
            
            for (int i = 0; i < digits[digits.length - 1]; i++) {
                result.append(")");
            }
            
            System.out.println(result);
        }
    }
}