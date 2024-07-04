import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = in.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            long x = in.nextLong();
            long y = in.nextLong();
            if (x >= 0 && y >= 0) {
                solve(tc, x, y, "E", "W", "N", "S");
            } else if (x <= 0 && y >= 0) {
                solve(tc, Math.abs(x), y, "W", "E", "N", "S");
            } else if (x >= 0 && y <= 0) {
                solve(tc, x, Math.abs(y), "E", "W", "S", "N");
            } else {
                solve(tc, Math.abs(x), Math.abs(y), "W", "E", "S", "N");
            }
        }
        out.close();
    }

    public static void solve(int tc, long x, long y, String fx, String bx, String fy, String by) {
        if (x == 1 && y == 0) {
            System.out.println("Case #" + tc + ": " + fx);
            return;
        }
        if (x == 0 && y == 1) {
            System.out.println("Case #" + tc + ": " + fy);
            return;
        }

        StringBuilder ans = new StringBuilder();
        long s = x + y;
        for (int e1 = 0; e1 <= 32; e1++) {
            for (int e2 = 1; e2 <= e1; e2++) {
                if (s == (1L << e1) + ((1L << e2) - 1)) {
                    if (e2 == e1) {
                        for (int i = 0; i <= e1; i++) {
                            if ((x & (1L << i)) != 0) {
                                ans.append(fx);
                            } else {
                                ans.append(fy);
                            }
                        }
                    } else {
                        if (x >= y) {
                            for (int i = 0; i < e2; i++) {
                                ans.append(bx);
                            }
                            for (int i = e2; i < e1; i++) {
                                ans.append(fy);
                            }
                            ans.append(fx);
                        } else {
                            for (int i = 0; i < e2; i++) {
                                ans.append(by);
                            }
                            for (int i = e2; i < e1; i++) {
                                ans.append(fx);
                            }
                            ans.append(fy);
                        }
                    }
                    System.out.println("Case #" + tc + ": " + ans);
                    return;
                }
            }
        }
        System.out.println("Case #" + tc + ": IMPOSSIBLE");
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    public long[] nextLongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextLong();
        }
        return a;
    }

    public double[] nextDoubleArray(int n) {
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextDouble();
        }
        return a;
    }
}