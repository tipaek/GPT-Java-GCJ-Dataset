import java.io.*;
import java.util.*;

import static java.lang.Runtime.getRuntime;
import static java.lang.System.*;

class Solution {
    static final IO IO = new IO();

    /**
     * CodeJam 2020
     * Qualification Round
     * Nesting Depth
     *
     * Jun Yoon
     */
    public static void main(String[] args) {
        final Solution $ = new Solution();
        final int t = IO.nextInt();
        int caseNum = 0;
        while (++caseNum <= t) {
            IO.printf("Case #%d: ", caseNum);
            $.solve(IO.next());
        }
        IO.close();
    }

    private void solve(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            int n = c - '0';
            for (int i = 0; i < n; i++) sb.append('(');
            sb.append(c);
            for (int i = 0; i < n; i++) sb.append(')');
        }
        while (true) {
            int idx = sb.indexOf(")(");
            if (idx == -1) break;
            sb.delete(idx, idx + 2);
        }
        IO.println(sb.toString());
    }
}

class IO {
    private final boolean IS_MAC_OS = getProperty("os.name").toLowerCase().contains("mac");
    private final String FILE_NAME = "/Users/jun/Desktop/out.txt";

    private final BufferedReader IN = new BufferedReader(new InputStreamReader(in));
    private StringTokenizer ST;
    private PrintWriter OUT;

    IO() {
        try {
            OUT = new PrintWriter(new BufferedWriter(IS_MAC_OS ?
                    new FileWriter(FILE_NAME, false) :
                    new OutputStreamWriter(out)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String next() {
        while (ST == null || !ST.hasMoreTokens()) {
            try {
                ST = new StringTokenizer(IN.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ST.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    float nextFloat() {
        return Float.parseFloat(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    boolean ready() {
        if (ST != null && ST.hasMoreTokens()) {
            return true;
        }
        while (ST == null || !ST.hasMoreTokens()) {
            try {
                if (!IN.ready()) {
                    return false;
                }
                ST = new StringTokenizer(IN.readLine());
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    String readLine() {
        try {
            return IN.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    void print(final Object x) {
        OUT.print(x);
    }

    void println(final Object x) {
        OUT.println(x);
    }

    void println() {
        OUT.println();
    }

    void printf(final String format, final Object... args) {
        OUT.printf(format, args);
    }

    void flush() {
        OUT.flush();
    }

    void close() {
        try {
            IN.close();
            OUT.close();
            if (IS_MAC_OS) getRuntime().exec("open /System/Applications/TextEdit.app " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
        exit(0);
    }
}




