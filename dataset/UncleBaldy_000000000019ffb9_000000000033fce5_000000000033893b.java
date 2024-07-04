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
            int v[] = readInts(), K = v[0], Q = v[1];
            String C = in.readLine();
            int[] L = readInts(), R = readInts(), P = readInts();
            int[] S = readInts(), E = readInts();
            String y = solve(C, K, Q, L, R, P, S, E);
            System.out.printf("Case #%d: %s\n", x, y);
        }
    }

    static String solve(String C, int K, int Q, int[] L, int[] R, int[] P, int[] S, int[] E) throws Exception {
        Stack<Integer> stack = new Stack<>();
        int[] match = new int[K];
        for (int i = 0; i < K; i++) {
            char c = C.charAt(i);
            if (c == '(') {
                stack.push(i);
            }
            else {
                int j = stack.pop();
                match[i] = j;
                match[j] = i;
            }
        }
        long sum = 0;
        for (int i = 0; i < Q; i++) {
            sum += minTime(S[i] - 1, E[i] - 1, K, match);
        }
        return sum+"";
    }

    static long minTime(int start, int end, int K, int[] match) {
        if (start == end) return 0;
        long t = 0;
        boolean[] used = new boolean[K];
        int[] q = new int[K];
        int qLen = 1;
        q[0] = start;
        used[start] = true;
        for (int i = 0; i < qLen;) {
            t++;
            for (int lim = qLen; i < lim; i++) {
                int n = q[i];
                int o = match[n];
                if (n > 0 && !used[n-1]) {
                    used[n-1] = true;
                    q[qLen++] = n-1;
                    if (n-1 == end) return t;
                }
                if (n+1 < K && !used[n+1]) {
                    used[n+1] = true;
                    q[qLen++] = n+1;
                    if (n+1 == end) return t;
                }
                if (!used[o]) {
                    used[o] = true;
                    q[qLen++] = o;
                    if (o == end) return t;
                }
            }
        }
        return t;
    }
}