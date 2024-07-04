import java.io.*;
import java.util.*;

public class Solution {
    FasterScanner sc = new FasterScanner();
    PrintWriter pw = new PrintWriter(System.out);
    static int MOD = 1000000007;

    public static void main(String[] args) {
        Solution m = new Solution();
        m.solve();
        m.done();
    }

    public void solve() {
        int t = sc.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            String s = sc.nextLine();
            int n = s.length();
            char[] C = s.toCharArray();
            int[] values = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = C[i] - '0';
            }
            int[] left = new int[n];
            int[] right = new int[n];
            while (keepGoing(values)) {
                int max = -1;
                for (int i = 0; i < n; i++) {
                    max = Math.max(values[i], max);
                }
                for (int i = 0; i < n; i++) {
                    if (values[i] == max) {
                        left[i]++;
                        values[i]--;
                        while (i+1 < n && values[i+1] == max) {
                            i++;
                            values[i]--;
                        }
                        right[i]++;
                    }
                }
            }
            pw.print("Case #" + tt + ": ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int p = 0; p < left[i]; p++) {
                    sb.append("(");
                }
                sb.append(C[i]);
                for (int p = 0; p < right[i]; p++) {
                    sb.append(")");
                }
            }
            pw.println(sb.toString());
        }
    }

    public boolean keepGoing(int[] values) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] != 0) return true;
        }
        return false;
    }

    public void done() {
        pw.flush();
        pw.close();
    }
}

class Activity {
    int start;
    int end;
    int index;

    public Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public static final Comparator<Activity> BY_START = new Comparator<Activity>() {
        @Override
        public int compare(Activity a1, Activity a2) {
            return a1.start - a2.start;
        }
    };
}

class FasterScanner {
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = System.in.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public String nextLine() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    public String nextString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public long nextLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
        
    public int[] nextIntArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        return arr;
    }
    
    public long[] nextLongArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLong();
        }
        return arr;
    }

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }
}