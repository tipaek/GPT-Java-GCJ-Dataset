/*
https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/0000000000209a9f

4
0000
101
111000
1

out:
Case #1: 0000
Case #2: (1)0(1)
Case #3: (111)000
Case #4: (1)
*/

import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int a0 = 1; a0 <= t; a0++) {
            String s = in.next();
            
            System.out.println("Case #" + a0 + ": " + getResult(s));
        }
    }

    private static String getResult(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int d = Character.digit(ch, 10);
            
            while (d > depth) {
                sb.append("(");
                depth++;
            }
            while (d < depth) {
                sb.append(")");
                depth--;
            }
            sb.append(ch);
        }
        while (depth > 0) {
            sb.append(")");
            depth--;
        }

        return sb.toString();
    }
}
