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
            int brac = 0;
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                int val = s.charAt(i) - '0';
                
                if (val == brac) {
                    sb.append(s.charAt(i));
                } else if (val > brac) {
                    int diff = val - brac;
                    sb.append(repeatChar('(', diff)).append(s.charAt(i));
                    brac += diff;
                } else {
                    int diff = brac - val;
                    sb.append(repeatChar(')', diff)).append(s.charAt(i));
                    brac -= diff;
                }
            }
            
            if (brac > 0) {
                sb.append(repeatChar(')', brac));
            }
            
            System.out.println("Case #" + (tt + 1) + ": " + sb.toString());
        }
    }

    private static String repeatChar(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}