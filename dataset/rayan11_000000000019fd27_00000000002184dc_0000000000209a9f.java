/* 4
0000
101
111000
1 */
import java.util.*;
import java.io.*;

public class Solution {
    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i ++) {
            String line = br.readLine().trim();
            StringBuilder ans = new StringBuilder ();
            int idx = 0;
            while (idx < line.length()) {
                if (line.charAt(idx) == '1') {
                    ans.append ('(');
                    while (idx < line.length() && line.charAt(idx) == '1') {
                        ans.append (line.charAt(idx));
                        idx ++;
                    }
                    ans.append (')');
                }
                else {
                    ans.append (line.charAt(idx));
                    idx ++;
                }
            }

            System.out.printf ("Case #%d: %s\n", i, ans.toString());
        }
    }
}
