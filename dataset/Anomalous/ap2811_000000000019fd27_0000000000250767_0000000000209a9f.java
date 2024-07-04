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
            int previousDigit = 0;
            
            for (int digit : digits) {
                int diff = digit - previousDigit;
                
                if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        result.append('(');
                    }
                } else if (diff < 0) {
                    for (int j = 0; j < -diff; j++) {
                        result.append(')');
                    }
                }
                
                result.append(digit);
                previousDigit = digit;
            }
            
            for (int j = 0; j < previousDigit; j++) {
                result.append(')');
            }
            
            System.out.println("Case #" + o + ": " + result);
        }
    }
}