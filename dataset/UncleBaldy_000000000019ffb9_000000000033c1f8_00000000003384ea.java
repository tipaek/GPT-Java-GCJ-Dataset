import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Solution {
    static BufferedReader in;
    static Random random;

    static int readInt() throws Exception {
        return Integer.parseInt(in.readLine());
    }

    static long readLong() throws Exception {
        return Long.parseLong(in.readLine());
    }

    static String[] readList() throws Exception {
        return in.readLine().split(" ");
    }

    static int[] readInts() throws Exception {
        String[] list = readList();
        int[] ints = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            ints[i] = Integer.parseInt(list[i]);
        }
        return ints;
    }

    static long[] readLongs() throws Exception {
        String[] list = readList();
        long[] longs = new long[list.length];
        for (int i = 0; i < list.length; i++) {
            longs[i] = Long.parseLong(list[i]);
        }
        return longs;
    }

    public static void main(String[] args) throws Exception {
        random = new Random("GCJ2020".hashCode());
        in = new BufferedReader(new InputStreamReader(System.in));

        int T = readInt();
        for (int x = 1; x <= T; x++) {
            long v[] = readLongs(), L = v[0], R = v[1];
            String n_l_r = solve(L, R);
            System.out.printf("Case #%d: %s\n", x, n_l_r);
        }
    }

    static String solve(long L, long R) throws Exception {
        long D = abs(L - R);
        long N = (long) ((sqrt(8*D + 1) - 1) / 2);
        if (L > R) {
            L -= (N+1) * N / 2;
        }
        else {
            R -= (N+1) * N / 2;
        }
        long LX = (L >= R) ? N+1 : N+2, LB = LX - 1;
        long RX = (L >= R) ? N+2 : N+1, RB = RX - 1;
        long LN = (long) ((sqrt(LB*LB + 4*L) - LB) / 2);
        long RN = (long) ((sqrt(RB*RB + 4*R) - RB) / 2);
        L -= (LX + LN - 1) * LN;
        R -= (RX + RN - 1) * RN;
        return (N + LN + RN) + " " + L + " " + R;
    }
}