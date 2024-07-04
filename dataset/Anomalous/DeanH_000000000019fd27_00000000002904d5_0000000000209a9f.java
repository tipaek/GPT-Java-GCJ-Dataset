import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            String n = in.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            
            for (char c : n.toCharArray()) {
                int digit = Character.getNumericValue(c);
                
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
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
        
        in.close();
    }
}