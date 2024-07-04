import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        
        for (int t = 1; t <= T; t++) {
            String s = reader.readLine();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;
            
            for (int i = 0; i < s.length(); i++) {
                int digit = Character.getNumericValue(s.charAt(i));
                
                while (openParentheses < digit) {
                    result.append('(');
                    openParentheses++;
                }
                
                while (openParentheses > digit) {
                    result.append(')');
                    openParentheses--;
                }
                
                result.append(s.charAt(i));
            }
            
            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }
            
            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}