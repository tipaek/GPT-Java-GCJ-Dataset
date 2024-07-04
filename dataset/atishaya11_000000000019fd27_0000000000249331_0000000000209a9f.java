import java.io.*;
import java.util.*;

class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for (int t = 1; t <= count; t++) {
            String s = in.next();

            StringBuilder sb = new StringBuilder();
            int open = 0;
            for (int i = 0; i < s.length(); i++) {
                int d = s.charAt(i) - '0';
                if (open == d) {
                    sb.append(d);
                } else if (open < d) {
                    int c = d - open;
                    while (c-- > 0) {
                        sb.append('(');
                        open++;
                    }
                    sb.append(d);
                } else {
                    int c = open - d;
                    while (c-- > 0) {
                        sb.append(')');
                        open--;
                    }
                    sb.append(d);
                }

            }
            while (open-- > 0) {
                sb.append(')');
            }
            String ans = sb.toString();
            System.out.printf("Case #%d: %s\n", t, ans);
        }
    }
}