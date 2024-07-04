import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {


    class CenterException extends RuntimeException {

    }

    boolean hit(int A, int B) {
        pw.printf("%d %d\n", A, B);
        pw.flush();
        String s = next();
        System.err.printf("ASK for %d %d => %s\n", A, B, s);
        if (s.equals("HIT"))
            return true;
        else if (s.equals("MISS"))
            return false;
        else if (s.equals("CENTER"))
            throw new CenterException();
        throw new RuntimeException("WRONG");
    }

    int centerX(int X, int Y) {
        int left, right;
        left = -1_000_000_000;
        right = X;
        while (left + 1 < right) {
            int c = (left + right) / 2;
            if (hit(c, Y))
                right = c;
            else
                left = c;
        }

        int leftX = right;
        left = X;
        right = 1_000_000_000;
        while (left + 1 < right) {
            int c = (left + right) / 2;
            if (hit(c, Y))
                left = c;
            else
                right = c;
        }
        int rightX = left;
        return (leftX + rightX) / 2;
    }

    int centerY(int X, int Y) {
        int left, right;
        left = -1_000_000_000;
        right = Y;
        while (left + 1 < right) {
            int c = (left + right) / 2;
            if (hit(X, c))
                right = c;
            else
                left = c;
        }

        int leftY = right;
        left = Y;
        right = 1_000_000_000;
        while (left + 1 < right) {
            int c = (left + right) / 2;
            if (hit(X, c))
                left = c;
            else
                right = c;
        }
        int rightY = left;
        return (leftY + rightY) / 2;
    }


    public void solveCase(int A, int B) {
        Random R = new Random();
        int X, Y;
        while (true) {
            X = R.nextInt(2 * 1_000_000_000) - 1_000_000_000;
            Y = R.nextInt(2 * 1_000_000_000) - 1_000_000_000;
            if (hit(X, Y))
                break;
        }
        while (true) {
            System.err.printf("CALC %d %d\n", X, Y);
            X = centerX(X, Y);
            System.err.printf("CALC %d %d\n", X, Y);
            Y = centerY(X, Y);
            System.err.printf("CALC %d %d\n", X, Y);
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    hit(X + i, Y + j);
                }
            }
        }
//        throw new RuntimeException("CANT SOLVE");
    }

    public void solve() {
        int t = nextInt();
        int A = nextInt(), B = nextInt();
        for (int i = 0; i < t; ++i) {
            try {
                solveCase(A, B);
            } catch (CenterException e) {
                System.err.println("CENTER");
            }
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