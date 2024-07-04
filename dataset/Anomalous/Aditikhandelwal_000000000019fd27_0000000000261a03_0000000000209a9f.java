import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int tc = t;
        
        while (t > 0) {
            String s = scn.next();
            int currentOpen = 0;
            StringBuilder ans = new StringBuilder();
            
            for (int i = 0; i < s.length(); i++) {
                int digit = Character.getNumericValue(s.charAt(i));
                int diff = digit - currentOpen;
                
                if (diff > 0) {
                    appendChars(ans, '(', diff);
                } else if (diff < 0) {
                    appendChars(ans, ')', -diff);
                }
                
                ans.append(digit);
                currentOpen = digit;
            }
            
            appendChars(ans, ')', currentOpen);
            System.out.println("Case #" + (tc - t + 1) + ": " + ans.toString());
            t--;
        }
        
        scn.close();
    }

    private static void appendChars(StringBuilder sb, char ch, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
    }
}