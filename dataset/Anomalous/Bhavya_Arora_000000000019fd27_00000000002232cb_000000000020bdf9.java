import java.io.*;
import java.util.*;

public class Solution {

    InputStream is;
    PrintWriter o;

    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            return this.end - other.end;
        }
    }

    void solve() {
        int t = ni();
        for (int q = 1; q <= t; q++) {
            int n = ni();
            Activity[] activities = new Activity[n];
            for (int i = 0; i < n; i++) {
                activities[i] = new Activity(ni(), ni(), i);
            }
            Arrays.sort(activities);
            int cl = 0;
            int jl = 0;
            StringBuilder res = new StringBuilder();
            boolean impossible = false;

            for (Activity activity : activities) {
                if (activity.start >= cl) {
                    res.append("C");
                    cl = activity.end;
                } else if (activity.start >= jl) {
                    res.append("J");
                    jl = activity.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                o.println("Case #" + q + ": IMPOSSIBLE");
            } else {
                char[] ans = new char[n];
                for (int i = 0; i < n; i++) {
                    ans[activities[i].index] = res.charAt(i);
                }
                o.print("Case #" + q + ": ");
                for (char c : ans) {
                    o.print(c);
                }
                o.println();
            }
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }

    void run() {
        is = System.in;
        o = new PrintWriter(System.out);
        solve();
        o.flush();
    }

    byte[] input = new byte[1024];
    int len = 0, ptr = 0;

    int readByte() {
        if (ptr >= len) {
            ptr = 0;
            try {
                len = is.read(input);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (len <= 0) {
                return -1;
            }
        }
        return input[ptr++];
    }

    boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    int skip() {
        int b = readByte();
        while (b != -1 && isSpaceChar(b)) {
            b = readByte();
        }
        return b;
    }

    char nc() {
        return (char) skip();
    }

    String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    String nLine() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b) && b != ' ')) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    int ni() {
        int n = 0, b = readByte();
        boolean minus = false;
        while (b != -1 && !((b >= '0' && b <= '9') || b == '-')) {
            b = readByte();
        }
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        if (b == -1) {
            return -1;
        }
        while (b >= '0' && b <= '9') {
            n = n * 10 + (b - '0');
            b = readByte();
        }
        return minus ? -n : n;
    }

    long nl() {
        long n = 0L;
        int b = readByte();
        boolean minus = false;
        while (b != -1 && !((b >= '0' && b <= '9') || b == '-')) {
            b = readByte();
        }
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (b >= '0' && b <= '9') {
            n = n * 10 + (b - '0');
            b = readByte();
        }
        return minus ? -n : n;
    }

    double nd() {
        return Double.parseDouble(ns());
    }

    float nf() {
        return Float.parseFloat(ns());
    }

    int[] nia(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ni();
        }
        return a;
    }

    long[] nla(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nl();
        }
        return a;
    }

    int[][] nim(int n) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = ni();
            }
        }
        return mat;
    }

    long[][] nlm(int n) {
        long[][] mat = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = nl();
            }
        }
        return mat;
    }

    char[] ns(int n) {
        char[] c = new char[n];
        int i, b = skip();
        for (i = 0; i < n; i++) {
            if (isSpaceChar(b)) {
                break;
            }
            c[i] = (char) b;
            b = readByte();
        }
        return i == n ? c : Arrays.copyOf(c, i);
    }

    void piarr(int[] arr) {
        for (int value : arr) {
            o.print(value + " ");
        }
        o.println();
    }

    void plarr(long[] arr) {
        for (long value : arr) {
            o.print(value + " ");
        }
        o.println();
    }

    void pimat(int[][] mat) {
        for (int[] row : mat) {
            for (int value : row) {
                o.print(value);
            }
            o.println();
        }
    }

    void plmat(long[][] mat) {
        for (long[] row : mat) {
            for (long value : row) {
                o.print(value);
            }
            o.println();
        }
    }
}