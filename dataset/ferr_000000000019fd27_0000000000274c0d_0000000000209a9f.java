import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    public String solveCase() {
        String s = next();
        StringBuilder res = new StringBuilder();
        int d = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                d++;
            } else if (c == ')') {
                d--;
                if (d < 0) {
                    res.append('(');
                    d++;
                }
            } else {
                int v = Integer.parseInt("" + c);
                while (v != d) {
                    if (v > d) {
                        res.append('(');
                        d++;
                    } else {
                        res.append(')');
                        d--;
                    }
                }
            }
            res.append(c);
        }
        while (d > 0) {
            res.append(')');
            d--;
        }
        return res.toString();
    }

    public void solve() {
        int t = nextInt();
        for (int i = 0; i < t; ++i) {
            String ans = solveCase();
            pw.printf("Case #%d: %s\n", i + 1, ans);
        }
    }

    static final String filename = "A";
    static final boolean fromConsole = true;

    public void run() {
        try {
            if (!fromConsole) {
                in = new BufferedReader(new FileReader(filename + ".in"));
                pw = new PrintWriter(filename + ".out");
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                pw = new PrintWriter(System.out);
            }
            st = new StringTokenizer("");
            long st = System.currentTimeMillis();
            solve();
            //pw.printf("\nWorking time: %d ms\n", System.currentTimeMillis() - st);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private StringTokenizer st;
    private BufferedReader in;
    private PrintWriter pw;

    boolean hasNext() {
        try {
            while (!st.hasMoreTokens()) {
                String line = in.readLine();
                if (line == null) {
                    return false;
                }
                st = new StringTokenizer(line);
            }
            return st.hasMoreTokens();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String next() {
        return hasNext() ? st.nextToken() : null;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }
}









