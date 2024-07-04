import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int x = 1; x <= t; ++x) {
            int N = in.nextInt();
            int[][] seg = new int[N][3];
            for(int i = 0; i < N; i++) {
                seg[i][0] = in.nextInt();
                seg[i][1] = in.nextInt();
                seg[i][2] = i;
            }

            String res = solve(N, seg);
            System.out.println("Case #" + x + ": " + res);
        }
    }

    public static String IMP = "IMPOSSIBLE";

    public static String solve(int N, int[][] seg) {
        Arrays.sort(seg, (a, b) -> Integer.compare(a[0], b[0]));
        char[] chars = new char[N];
        int ct = 0;
        int jt = 0;

        for(int i = 0; i < seg.length; i++) {
            int start = seg[i][0];
            int end = seg[i][1];
            int seq = seg[i][2];
            if(start >= ct) {
                chars[seq] = ('C');
                ct = end;
            } else if (start >= jt) {
                chars[seq] = ('J');
                jt = end;
            } else {
                return IMP;
            }
        }

        return new String(chars);
    }
}