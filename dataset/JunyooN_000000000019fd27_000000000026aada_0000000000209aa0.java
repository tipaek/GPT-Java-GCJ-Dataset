import java.io.*;
import java.util.*;

import static java.lang.Runtime.getRuntime;
import static java.lang.System.*;

class Solution {
    static final IO IO = new IO();

    /**
     * CodeJam 2020
     * Qualification Round
     * Indicium
     *
     * Jun Yoon
     */
    public static void main(String[] args) {
        final Solution $ = new Solution();
        final int t = IO.nextInt();
        int caseNum = 0;
        while (++caseNum <= t) {
            IO.printf("Case #%d: ", caseNum);
            $.solve(IO.nextInt(), IO.nextInt());
        }
        IO.close();
    }

    private static final Map<Integer, List<int[][]>> GRIDS = new HashMap<>();
    static {
        fill(2, "01 10");
        fill(3, "012 120 201");
        fill(4, "0123 1032 2301 3210");
        fill(4, "0123 1032 2310 3201");
        fill(4, "0123 1230 2301 3012");
        fill(4, "0123 1302 2031 3210");
        fill(5, "01234 10342 23410 34021 42103");
        fill(5, "01234 10342 23401 34120 42013");
        fill(5, "01234 10423 23041 34102 42310");
        fill(5, "01234 10423 23140 34012 42301");
        fill(5, "01234 10342 24013 32401 43120");
        fill(5, "01234 10342 24103 32410 43021");
        fill(5, "01234 10423 24310 32041 43102");
        fill(5, "01234 10423 24301 32140 43012");
        fill(5, "01234 12340 20413 34021 43102");
        fill(5, "01234 12340 20413 34102 43021");
        fill(5, "01234 12403 20341 34012 43120");
        fill(5, "01234 12403 20341 34120 43012");
        fill(5, "01234 12043 23401 34120 40312");
        fill(5, "01234 12043 23410 34102 40321");
        fill(5, "01234 12340 23401 34012 40123");
        fill(5, "01234 12403 23041 34120 40312");
        fill(5, "01234 12403 23140 34012 40321");
        fill(5, "01234 12403 23140 34021 40312");
        fill(5, "01234 12043 24301 30412 43120");
        fill(5, "01234 12043 24310 30421 43102");
        fill(5, "01234 12340 24013 30421 43102");
        fill(5, "01234 12340 24103 30412 43021");
        fill(5, "01234 12340 24103 30421 43012");
        fill(5, "01234 12403 24310 30142 43021");
        fill(5, "01234 13042 20413 34120 42301");
        fill(5, "01234 13402 20143 34021 42310");
        fill(5, "01234 13420 20143 34012 42301");
        fill(5, "01234 13420 20341 34012 42103");
        fill(5, "01234 13402 20341 34120 42013");
        fill(5, "01234 13420 20341 34102 42013");
        fill(5, "01234 13042 24103 30421 42310");
        fill(5, "01234 13042 24310 30421 42103");
        fill(5, "01234 13420 24013 30142 42301");
        fill(5, "01234 13420 24301 30142 42013");
        fill(5, "01234 13042 24103 32410 40321");
        fill(5, "01234 13042 24301 32410 40123");
        fill(5, "01234 13042 24310 32401 40123");
        fill(5, "01234 13402 24013 32140 40321");
        fill(5, "01234 13420 24103 32041 40312");
        fill(5, "01234 13402 24310 32041 40123");
        fill(5, "01234 14023 20341 32410 43102");
        fill(5, "01234 14302 20143 32410 43021");
        fill(5, "01234 14320 20143 32401 43012");
        fill(5, "01234 14302 20413 32041 43120");
        fill(5, "01234 14320 20413 32041 43102");
        fill(5, "01234 14302 20413 32140 43021");
        fill(5, "01234 14023 23140 30412 42301");
        fill(5, "01234 14023 23401 30142 42310");
        fill(5, "01234 14023 23410 30142 42301");
        fill(5, "01234 14320 23041 30412 42103");
        fill(5, "01234 14302 23140 30421 42013");
        fill(5, "01234 14320 23401 30142 42013");
        fill(5, "01234 14023 23140 32401 40312");
        fill(5, "01234 14023 23401 32140 40312");
        fill(5, "01234 14302 23041 32410 40123");
        fill(5, "01234 14302 23410 32041 40123");
    }

    private static void fill(int n, String s) {
        int[][] grid = new int[n][n];
        String[] rows = s.split(" ");
        for (int i = 0; i < rows.length; i++) {
            char[] chars = rows[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                grid[i][j] = (chars[j] - '0') + 1;
            }
        }
        GRIDS.computeIfAbsent(n, k -> new LinkedList<>()).add(grid);
    }

    private void solve(final int N, final int K) {
        for (int[][] grid: GRIDS.get(N)) {
            for (int i = 0; i < N; i++) {
                int sum = 0, reverseSum = 0;
                for (int j = 0; j < N; j++) {
                    sum += grid[j][(j + i) % N];
                    reverseSum += grid[j][N - 1 - ((j + i) % N)];
                }
                if (sum == K) {
                    IO.println("POSSIBLE");
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < N; k++) {
                            if (k != 0) IO.print(" ");
                            IO.print(grid[j][(k + i) % N]);
                        }
                        IO.println();
                    }
                    return;
                }
                if (reverseSum == K) {
                    IO.println("POSSIBLE");
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < N; k++) {
                            if (k != 0) IO.print(" ");
                            IO.print(grid[j][N - 1 - ((k + i) % N)]);
                        }
                        IO.println();
                    }
                    return;
                }
            }
        }
        IO.println("IMPOSSIBLE");
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




