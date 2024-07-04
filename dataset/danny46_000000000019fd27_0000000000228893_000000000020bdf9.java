import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int x = 1; x <= t; ++x) {
            int N = in.nextInt();
            int[][] seg = new int[N][2];
            for(int i = 0; i < N; i++) {
                seg[i][0] = in.nextInt();
                seg[i][1] = in.nextInt();
            }

            String res = solve(N, seg);
            System.out.println("Case #" + x + ": " + res);
        }
    }

    public static String IMP = "IMPOSSIBILE";

    public static String solve(int N, int[][] seg) {
        Arrays.sort(seg, (a, b) -> Integer.compare(a[0], b[0]));
        StringBuilder sb = new StringBuilder();
        int ct = 0;
        int jt = 0;

        for(int i = 0; i < seg.length; i++) {
            int start = seg[i][0];
            int end = seg[i][1];

            if(start >= ct) {
                sb.append('C');
                ct = end;
            } else if (start >= jt) {
                sb.append('J');
                jt = end;
            } else {
                return IMP;
            }
        }

        return sb.toString();
    }
}