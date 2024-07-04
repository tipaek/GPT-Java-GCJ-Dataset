import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= T; t++) {
            String s = sc.next();
            StringBuilder ans = new StringBuilder();
            int open = 0;
            
            for (int i = 0; i < s.length(); i++) {
                int d = Character.getNumericValue(s.charAt(i));
                
                while (open < d) {
                    ans.append('(');
                    open++;
                }
                
                while (open > d) {
                    ans.append(')');
                    open--;
                }
                
                ans.append(d);
            }
            
            while (open > 0) {
                ans.append(')');
                open--;
            }
            
            sb.append("Case #").append(t).append(": ").append(ans).append("\n");
        }
        
        out.print(sb.toString());
        out.close();
    }

    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
}