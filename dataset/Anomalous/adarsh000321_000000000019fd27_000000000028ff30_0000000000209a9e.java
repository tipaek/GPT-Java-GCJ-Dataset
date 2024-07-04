import java.awt.*;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        
        for (int test = 1; test <= t; test++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b; i++) {
                sb.append("4");
            }
            
            int r = 1;
            int pos = 0;
            int c = 0;
            int l = 0;
            
            while (pos < b / 2) {
                if (r >= 11 && r % 10 == 1) {
                    if (c != 0) {
                        out.println(c);
                        out.flush();
                        char ch = scanner.next().charAt(0);
                        if (ch != sb.charAt(c - 1)) {
                            for (int k = 0; k < b; k++) {
                                sb.setCharAt(k, sb.charAt(k) == '1' ? '0' : '1');
                            }
                        }
                    } else {
                        out.println(2);
                        out.flush();
                    }
                    
                    if (l != 0) {
                        out.println(l);
                        out.flush();
                        char ch = scanner.next().charAt(0);
                        if (ch != sb.charAt(l - 1)) {
                            sb.reverse();
                        }
                    } else {
                        out.println(2);
                        out.flush();
                    }
                } else {
                    out.println(pos + 1);
                    out.flush();
                    String ch = scanner.next();
                    sb.setCharAt(pos, ch.charAt(0));
                    
                    int mirrorPos = b - pos - 1;
                    out.println(mirrorPos + 1);
                    out.flush();
                    ch = scanner.next();
                    sb.setCharAt(mirrorPos, ch.charAt(0));
                    
                    if (sb.charAt(pos) == sb.charAt(mirrorPos)) {
                        c = pos + 1;
                    } else {
                        l = pos + 1;
                    }
                    pos++;
                }
                r += 2;
            }
            out.println(sb.toString());
            out.flush();
            String verification = scanner.next();
            if (verification.equals("N")) {
                return;
            }
        }
    }
}