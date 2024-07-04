import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            StringBuilder news = new StringBuilder();
            int currentDepth = 0;
            
            for (int j = 0; j < s.length(); j++) {
                char currentChar = s.charAt(j);
                int digit = Character.getNumericValue(currentChar);
                
                while (currentDepth > digit) {
                    news.append(')');
                    currentDepth--;
                }
                
                while (currentDepth < digit) {
                    news.append('(');
                    currentDepth++;
                }
                
                news.append(currentChar);
            }
            
            while (currentDepth > 0) {
                news.append(')');
                currentDepth--;
            }
            
            System.out.println("Case #" + i + ": " + news.toString());
        }
    }
}