import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            String s[] = br.readLine().split(" ");
            int x_ = Integer.parseInt(s[0]);
            int y_ = Integer.parseInt(s[1]);
            String str = s[2];
            int len = str.length();
            int x[] = new int[len + 1];
            int y[] = new int[len + 1];
            x[0] = x_;
            y[0] = y_;
            for (int p = 1; p <= len; p++) {
                if (str.charAt(p - 1) == 'N') {
                    x[p] = x[p - 1];
                    y[p] = y[p - 1] + 1;
                } else if (str.charAt(p - 1) == 'S') {
                    x[p] = x[p - 1];
                    y[p] = y[p - 1] - 1;
                } else if (str.charAt(p - 1) == 'E') {
                    x[p] = x[p - 1] + 1;
                    y[p] = y[p - 1];
                } else if (str.charAt(p - 1) == 'W') {
                    x[p] = x[p - 1] - 1;
                    y[p] = y[p - 1];
                }
            }
            int flag = 0;
            bw.write("Case #" + i + ": ");
            for (int p = 0; p <= len; p++) {
                int cur = 0;
                cur += Math.abs(x[p]) + Math.abs(y[p]);
                if (cur <= p) {
                    bw.write("" + p + "\n");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                bw.write("IMPOSSIBLE" + "\n");
            }
        }
        bw.flush();
    }
}