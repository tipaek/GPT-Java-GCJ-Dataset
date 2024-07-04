import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        new NestingDepth().solve();
    }
}

class NestingDepth {
    private final FScanner in;
    private final FPrinter out;
    private final char[] resstr;
    private static final int ZERO = '0';
    private static final char BRA = '(';
    private static final char KET = ')';
    private static final int MAXLEN = 2000;
    private int t;

    NestingDepth() throws IOException {
        in = new FScanner();
        out = new FPrinter();
        resstr = new char[MAXLEN];
    }

    void analyzeCase(int tc) throws IOException {
        char[] st = in.next().toCharArray();
        int len = st.length;
        int depth = 0;
        int laq = 0;

        for (char c : st) {
            int diff = depth - (c - ZERO);
            char bk = (diff < 0) ? BRA : KET;
            diff = Math.abs(diff);
            for (int j = 0; j < diff; j++) {
                resstr[laq++] = bk;
            }
            resstr[laq++] = c;
            depth = c - ZERO;
        }

        for (int j = 0; j < depth; j++) {
            resstr[laq++] = KET;
        }

        String ans = new String(resstr, 0, laq);
        out.printlnCase(tc, ans);
    }

    void solve() throws IOException {
        t = in.nextInt();
        in.in.ordinaryChars('0', '9');
        in.in.wordChars('0', '9');

        for (int i = 1; i <= t; i++) {
            analyzeCase(i);
        }

        out.close();
    }
}

class FScanner {
    private final StreamTokenizer in;

    FScanner() throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    }

    int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    String next() throws IOException {
        in.nextToken();
        return in.sval;
    }
}

class FPrinter {
    private final PrintWriter out;

    FPrinter() throws IOException {
        out = new PrintWriter(System.out);
    }

    void printlnCase(int tc, String ans) {
        out.printf("Case #%d: %s%n", tc, ans);
    }

    void close() {
        out.flush();
        out.close();
    }
}