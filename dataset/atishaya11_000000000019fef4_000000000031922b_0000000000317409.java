import java.io.*;
import java.util.*;

class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for (int t = 1; t <= count; t++) {

            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();
            int m = s.length();
            String ans = "IMPOSSIBLE";
            for (int i = 1; i <= m; i++) {
                char ch = s.charAt(i - 1);
                switch(ch) {
                    case 'N':
                        y += 1;
                    break;
                    case 'E':
                        x += 1;
                    break;
                    case 'S':
                        y -= 1;
                    break;
                    case 'W':
                        x -= 1;
                    break;
                }
                if (Math.abs(x) + Math.abs(y) <= i) {
                    ans = String.valueOf(i);
                    break;
                } 
            }

            System.out.printf("Case #%d: %s\n", t, ans);
        }
    }
}

