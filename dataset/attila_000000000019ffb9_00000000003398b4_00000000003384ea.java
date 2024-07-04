//package codejam2020r2;

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int ttt = Integer.parseInt(sc.readLine());
        for (int tt = 1; tt <= ttt; tt++) {
            String[] line = sc.readLine().split(" ");
            long l = Long.parseLong(line[0]);
            long r = Long.parseLong(line[1]);
            for (int i = 0; i <= Integer.MAX_VALUE; i++) {
                if (i <= r || i <= l) {
                    if (l < r) {
                        r -= i;
                    } else {
                        l -= i;
                    }
                } else {
                    System.out.println("Case #" + tt + ": " + (i-1) + " " + l + " " + r);
                    break;
                }
            }
        }
    }
}
