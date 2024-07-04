import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int tt = 0; tt < t; tt++) {
            String s = br.readLine();
            int n = s.length();
            int braceCount = 0;
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                int val = s.charAt(i) - '0';
                
                if (val == braceCount) {
                    sb.append(s.charAt(i));
                } else if (val > braceCount) {
                    sb.append(generateBraces(val - braceCount, '(')).append(s.charAt(i));
                    braceCount = val;
                } else {
                    sb.append(generateBraces(braceCount - val, ')')).append(s.charAt(i));
                    braceCount = val;
                }
            }
            
            if (braceCount > 0) {
                sb.append(generateBraces(braceCount, ')'));
            }
            
            System.out.println("Case #" + (tt + 1) + ": " + sb.toString());
        }
    }

    private static String generateBraces(int count, char brace) {
        return String.join("", Collections.nCopies(count, String.valueOf(brace)));
    }
}