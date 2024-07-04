import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i=1; i<=T; i++) {
            char s[] = input.next().toCharArray();
            int x = 0;
            char open = '(';
            char close = ')';
            String out = "";
            char prev = 'n';
            while (x < s.length) {
                int val = Integer.parseInt(String.valueOf(s[x]));
                if (prev == 'n') {
                    while (val > 0) {
                        out += open;
                        val--;
                    }
                    out += s[x];
                    prev = s[x];
                }
                else {
                    int pre = Integer.parseInt(String.valueOf(prev));
                    if (pre == val);
                    else if (pre > val) {
                        int sub = pre-val;
                        while (sub > 0) {
                            out += close;
                            sub--;
                        }
                    } else {
                        int sub = val - pre;
                        while (sub > 0) {
                            out += open;
                            sub--;
                        }
                    }
                    out += s[x];
                    prev = s[x];
                }
                x++;
            }
            int pre = Integer.parseInt(String.valueOf(prev));
            while (pre > 0) {
                out += close;
                pre--;
            }
            System.out.println(String.format("Case #%d: %s", i, out));
        }
    }
}