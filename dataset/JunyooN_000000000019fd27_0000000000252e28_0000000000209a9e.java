import java.io.*;
import java.util.*;

import static java.lang.Runtime.getRuntime;
import static java.lang.System.*;

class Solution {
    static final IO IO = new IO();

    /**
     * CodeJam 2020
     * Qualification Round
     * ESAb ATAd
     *
     * Jun Yoon
     */
    public static void main(String[] args) {
        final Solution $ = new Solution();
        final int t = IO.nextInt(), b = IO.nextInt();
        int caseNum = 0;
        while (++caseNum <= t) {
//            IO.printf("Case #%d: ", caseNum);
            $.solve(b);
        }
        IO.close();
    }

    private void solve(int b) {
        Boolean[] ans = new Boolean[b];
        if (b == 10) {
            for (int i = 0; i < b; i++) ans[i] = query(i);
        } else { // b == 20 || b == 100
            for (int i = 0; i < 5; i++) ans[i] = query(i);
            for (int i = 0; i < 5; i++) ans[b - 1 - i] = query(b - 1 - i);
            
            int diffIdx = -1, sameIdx = -1, idx = 5, qCount = 10;
            
            while (idx < b) {
                for (int i = 0; i < idx; i++) {
                    if (diffIdx != -1 && sameIdx != -1) break;
                    if (diffIdx == -1 && ans[i] != ans[b - 1 - i]) diffIdx = i;
                    if (sameIdx == -1 && ans[i] == ans[b - 1 - i]) sameIdx = i;
                }
                if (diffIdx == -1) { // all same
                    if (ans[0] != query(0)) {
                        bitFlip(ans);
                    }
                    qCount++;
                } else if (sameIdx == -1) { // all diff
                    if (ans[0] != query(0)) {
                        mirrorImage(ans);
                    }
                    qCount++;
                } else {
                    boolean bitFlipped = ans[sameIdx] != query(sameIdx);
                    boolean mirrorImaged = ans[diffIdx] != query(diffIdx);
                    qCount += 2;
                    if (bitFlipped && !mirrorImaged) {
                        bitFlip(ans);
                        mirrorImage(ans);
                    } else if (bitFlipped) {
                        bitFlip(ans);
                    } else if (mirrorImaged) {
                        mirrorImage(ans);
                    }
                }
                while (idx < b && (qCount + 1) % 10 != 1) {
                    ans[idx] = query(idx);
                    idx++;
                    qCount++;
                }
            }
            
        }
        for (int i = 0; i < b; i++) IO.print(ans[i] ? 1 : 0);
        IO.println();
        IO.flush();
        IO.readLine();
        IO.flush();
    }

    private void mirrorImage(Boolean[] ans) {
        for (int i = 0; i < ans.length / 2; i++) {
            if (ans[i] == null) continue;
            boolean tmp = ans[i];
            ans[i] = ans[ans.length - 1 - i];
            ans[ans.length - 1 - i] = tmp;
        }
    }

    private void bitFlip(Boolean[] ans) {
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == null) continue;
            ans[i] = !ans[i];
        }
    }

    private boolean query(int i) {
        IO.println(i + 1);
        IO.flush();
        return IO.nextInt() == 1;
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




