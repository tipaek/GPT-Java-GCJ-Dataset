import java.lang.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] strs = null;
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            sc.nextLine();
            strs = new String[T];
            for (int t = 0; t < T; ++t) {
                strs[t] = sc.nextLine();
            }
        }
        
        for (int i = 0; i < strs.length; ++i) {
            String result = solve(strs[i]);
            System.out.println("Case #" + (i + 1) + ": " + result);    
        }
    }
    
    private static String solve(String str) {
        StringBuffer res = new StringBuffer();
        int curr = 0;
        int next = 0;
        int pos = 0;
        while (pos < str.length() + 1) {
            char ch;
            if (pos < str.length()) {
                ch = str.charAt(pos);
            } else {
                ch = '0';
            }
            next = ch - '0';
            int diff = next - curr;
            char brace = diff > 0 ? '(' : ')';
            for (int i = 0; i < Math.abs(diff); ++i) {
                res.append(brace);
            }
            if (pos < str.length()) {
                res.append(ch);
            }
            curr = next;
            ++pos;
        }
        
        return res.toString();
    }
}