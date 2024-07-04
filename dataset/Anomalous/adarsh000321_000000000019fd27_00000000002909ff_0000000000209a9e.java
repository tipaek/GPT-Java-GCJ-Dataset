import java.awt.*;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        
        for (int tst = 1; tst <= t; tst++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b; i++) {
                sb.append("4");
            }
            int r = 1;
            int pos = 0;
            int sameIndex = 0;
            int diffIndex = 0;
            
            while (pos < b / 2) {
                if (r >= 11 && r % 10 == 1) {
                    if (sameIndex != 0) {
                        out.println(sameIndex);
                        out.flush();
                        char ch = sc.next().charAt(0);
                        if (ch != sb.charAt(sameIndex - 1)) {
                            for (int k = 0; k < b; k++) {
                                if (sb.charAt(k) == '1') {
                                    sb.setCharAt(k, '0');
                                } else if (sb.charAt(k) == '0') {
                                    sb.setCharAt(k, '1');
                                }
                            }
                        }
                    } else {
                        out.println(2);
                        out.flush();
                        sc.next().charAt(0);
                    }
                    
                    if (diffIndex != 0) {
                        out.println(diffIndex);
                        out.flush();
                        char ch = sc.next().charAt(0);
                        if (ch != sb.charAt(diffIndex - 1)) {
                            sb.reverse();
                        }
                    } else {
                        out.println(2);
                        out.flush();
                        sc.next().charAt(0);
                    }
                } else {
                    out.println(pos + 1);
                    out.flush();
                    String ch = sc.next();
                    sb.setCharAt(pos, ch.charAt(0));
                    
                    int temp = b - pos;
                    out.println(temp);
                    out.flush();
                    ch = sc.next();
                    sb.setCharAt(temp - 1, ch.charAt(0));
                    
                    if (sb.charAt(pos) == sb.charAt(temp - 1)) {
                        sameIndex = pos + 1;
                    } else {
                        diffIndex = pos + 1;
                    }
                    pos++;
                }
                r += 2;
            }
            
            out.println(sb);
            out.flush();
            String verification = sc.next();
            if (verification.equals("N")) {
                return;
            }
        }
    }
}