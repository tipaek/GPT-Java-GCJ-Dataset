import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        
        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            String s = sc.next();
            int[] digits = new int[s.length()];
            
            // Convert string to array of digits
            for (int i = 0; i < s.length(); i++) {
                digits[i] = s.charAt(i) - '0';
            }
            
            System.out.print("Case #" + caseNumber + ": ");
            
            for (int i = 0; i < digits[0]; i++) {
                System.out.print("(");
            }
            
            for (int i = 0; i < digits.length; i++) {
                if (i > 0) {
                    int diff = digits[i] - digits[i - 1];
                    if (diff > 0) {
                        for (int j = 0; j < diff; j++) {
                            System.out.print("(");
                        }
                    } else if (diff < 0) {
                        for (int j = 0; j < -diff; j++) {
                            System.out.print(")");
                        }
                    }
                }
                System.out.print(digits[i]);
            }
            
            for (int i = 0; i < digits[digits.length - 1]; i++) {
                System.out.print(")");
            }
            
            if (caseNumber < t) {
                System.out.println();
            }
        }
    }
}