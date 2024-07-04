import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String n = in.next();
            StringBuilder result = new StringBuilder();
            
            int previousDigit = 0;
            for (char ch : n.toCharArray()) {
                int currentDigit = ch - '0';
                
                while (previousDigit < currentDigit) {
                    result.append('(');
                    previousDigit++;
                }
                
                while (previousDigit > currentDigit) {
                    result.append(')');
                    previousDigit--;
                }
                
                result.append(currentDigit);
            }
            
            while (previousDigit > 0) {
                result.append(')');
                previousDigit--;
            }
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}