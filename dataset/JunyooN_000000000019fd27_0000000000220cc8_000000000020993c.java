import java.io.*;
import java.util.*;

import static java.lang.Runtime.getRuntime;
import static java.lang.System.*;

class Solution {
    static final IO IO = new IO();

    /**
     * CodeJam 2020
     * Qualification Round
     * Vestigium
     *
     * Jun Yoon
     */
    public static void main(String[] args) {
        final Solution $ = new Solution();
        final int t = IO.nextInt();
        int caseNum = 0;
        while (++caseNum <= t) {
            IO.printf("Case #%d: ", caseNum);
            $.solve(IO.nextInt());
        }
        IO.close();
    }

    private void solve(int n) {
        int k = 0, r = 0, c = 0;
        Map<Integer, Set<Integer>> cols = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            Set<Integer> row = new HashSet<>(n);
            for (int j = 0; j < n; j++) {
                final int cur = IO.nextInt();
                if (i == j) k += cur;
                row.add(cur);
                cols.computeIfAbsent(j, x -> new HashSet<>(n)).add(cur);
                if (i == n - 1 && cols.get(j).size() < n) c++;
            }
            if (row.size() < n) r++;
        }
        IO.printf("%d %d %d\n", k, r, c);
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




