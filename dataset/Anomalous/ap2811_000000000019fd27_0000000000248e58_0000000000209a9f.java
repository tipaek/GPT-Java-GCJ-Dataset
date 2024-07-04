import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        
        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            String s = sc.next();
            int[] digits = new int[s.length()];
            
            for (int i = 0; i < s.length(); i++) {
                digits[i] = s.charAt(i) - '0';
            }
            
            StringBuilder result = new StringBuilder();
            result.append("Case #").append(caseNumber).append(": ");
            
            int currentDepth = 0;
            for (int digit : digits) {
                while (currentDepth < digit) {
                    result.append("(");
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(")");
                    currentDepth--;
                }
                result.append(digit);
            }
            
            while (currentDepth > 0) {
                result.append(")");
                currentDepth--;
            }
            
            System.out.println(result.toString());
        }
    }
}