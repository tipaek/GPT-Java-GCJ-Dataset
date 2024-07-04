import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            String S = sc.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char c : S.toCharArray()) {
                int digit = Character.getNumericValue(c);
                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(digit);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}