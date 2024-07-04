import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader in;
    public static void main(String[] args) throws Exception {
        in = new BufferedReader(
                new InputStreamReader(System.in)
        );
        int T = Integer.parseInt(in.readLine());
        for (int x = 1; x <= T; x++) {
            int U = Integer.parseInt(in.readLine());
            String y = solve(U);
            System.out.printf("Case #%d: %s\n", x, y);
        }
    }

    static String solve(int U) throws Exception {
        String x = "";
        int[] f = new int[128];
        for (int i = 0; i < 10000; i++) {
            String[] line = in.readLine().split(" ");
            long M = Long.parseLong(line[0]);
            String R = line[1];
            f[R.charAt(0)]++;
            for (char c : R.toCharArray()) {
                if (x.indexOf(c) < 0) {
                    x += c;
                }
            }
        }
        char[] X = x.toCharArray();
        for (int i = 0; i < 10; i++) {
            for (int j = i+1; j < 10; j++) {
                char a = X[i];
                char b = X[j];
                if (f[b] > f[a]) {
                    X[i] = b;
                    X[j] = a;
                }
            }
        }
        String R = new String(X);
        return R.substring(9) + R.substring(0, 9);
    }
}
