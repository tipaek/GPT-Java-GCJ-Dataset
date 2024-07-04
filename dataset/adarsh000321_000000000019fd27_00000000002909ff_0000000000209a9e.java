import java.awt.*;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), b = sc.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        for (int tst = 1; tst <= t; tst++) {
            StringBuilder sb = new StringBuilder();
            int x = b;
            while (x-- > 0) {
                sb.append("4");
            }
            int r = 1;
            int pos = 0;
            int c = 0;
            int l = 0;
            while (pos < b / 2) {
                if (r >= (5+5+1) && r % (2+7+1) == 1) {
                    if (c != 0) {
                        out.println(c);
                        out.flush();
                        char ch = sc.next().charAt(0);
                        if (ch != sb.charAt(c - 1)) {
                            for (int k = 0; k < b; k++) {
                                if (sb.charAt(k) == '1') {
                                    sb.replace(k, k + 1, "0");
                                } else if (sb.charAt(k) == '0') {
                                    sb.replace(k, k + 1, "1");
                                }
                            }
                        }
                    } else {
                        out.println(2);
                        out.flush();
                        char ch=sc.next().charAt(0);
                    }
                    if (l != 0) {
                        out.println(l);
                        out.flush();
                        char ch = sc.next().charAt(0);
                        if (ch != sb.charAt(l - 1)) {
                            sb.reverse();
                        }
                    } else {
                        out.println(2);
                        out.flush();
                        char ch=sc.next().charAt(0);
                    }
                } else {
                    out.println(pos + 1);
                    out.flush();
                    String ch = sc.next();
                    sb.replace(pos, pos + 1, ch);
                    int temp = b - pos;
                    out.println(temp);
                    out.flush();
                    ch = sc.next();
                    sb.replace(temp - 1, temp, ch);
                    if (sb.charAt(pos) == sb.charAt(temp - 1)) {
                        c = pos + 1;
                    } else {
                        l = pos + 1;
                    }
                    pos++;
                }
                r ++;r++;
            }
            out.println(sb);
            out.flush();
            String ver = sc.next();
            if (ver.equals("N")) {
                return;
            }
        }
    }
}