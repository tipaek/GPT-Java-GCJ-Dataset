import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public final class Solution implements Runnable {

    public String solveCase() {
        long L = nextLong(), R = nextLong();
//        long delta = Math.abs(L - R);
//        long i = (-1 + (long)Math.sqrt(1 + 8 * delta)) / 2;
//        if (L1 > R1) {
//            L1 -= i * (i + 1);
//        } else {
//            R1 -= i * (i + 1);
//        }
//            throw new IllegalStateException();
        long i = 1;
        while (true) {

            long X = Math.min(L, R);
            long k = (-(i + 1) / (long) Math.sqrt((i + 1) * (i + 1) + 4 * X)) / 2;
            if (L >= R) {
                L -= i * k + k * k;
                R -= i * k + k * (k + 1);
            } else {
                R -= i * k + k * k;
                L -= i * k + k * (k + 1);
            }
            i += 2 * k;

            if (L >= R && L >= i) {
                L -= i;
                i++;
            }
            if (R > L && R >= i) {
                R -= i;
                i++;

            }

            if (L >= R && L < i)
                break;
            if (R >= L && R < i)
                break;
        }
        return String.format("%d %d %d", i - 1, L, R);
    }

    public void solve() {
        int t = nextInt();
        for (int i = 0; i < t; ++i) {
            pw.printf("Case #%d: %s\n", i + 1, solveCase());
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