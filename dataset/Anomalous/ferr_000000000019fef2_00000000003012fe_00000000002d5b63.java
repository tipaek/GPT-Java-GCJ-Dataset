import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    class CenterException extends RuntimeException {}

    private boolean hit(int A, int B) {
        pw.printf("%d %d\n", A, B);
        pw.flush();
        String response = next();
        System.err.printf("ASK for %d %d => %s\n", A, B, response);
        switch (response) {
            case "HIT":
                return true;
            case "MISS":
                return false;
            case "CENTER":
                throw new CenterException();
            default:
                throw new RuntimeException("Unexpected response");
        }
    }

    private int findCenterX(int X, int Y) {
        int left = -1_000_000_000, right = X;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (hit(mid, Y)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        int leftX = right;
        left = X; right = 1_000_000_000;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (hit(mid, Y)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int rightX = left;
        return (leftX + rightX) / 2;
    }

    private int findCenterY(int X, int Y) {
        int left = -1_000_000_000, right = Y;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (hit(X, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        int leftY = right;
        left = Y; right = 1_000_000_000;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (hit(X, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int rightY = left;
        return (leftY + rightY) / 2;
    }

    private void solveCase(int A, int B) {
        Random random = new Random();
        int X, Y;
        while (true) {
            X = random.nextInt(2_000_000_000) - 1_000_000_000;
            Y = random.nextInt(2_000_000_000) - 1_000_000_000;
            if (hit(X, Y)) break;
        }
        while (true) {
            System.err.printf("CALC %d %d\n", X, Y);
            X = findCenterX(X, Y);
            System.err.printf("CALC %d %d\n", X, Y);
            Y = findCenterY(X, Y);
            System.err.printf("CALC %d %d\n", X, Y);
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    hit(X + i, Y + j);
                }
            }
        }
    }

    private void solve() {
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

    private static final boolean fromConsole = true;
    private BufferedReader in;
    private PrintWriter pw;
    private StringTokenizer st;

    public void run() {
        try {
            if (!fromConsole) {
                in = new BufferedReader(new FileReader("A.in"));
                pw = new PrintWriter("A.out");
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                pw = new PrintWriter(System.out);
            }
            st = new StringTokenizer("");
            solve();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private boolean hasNext() {
        try {
            while (!st.hasMoreTokens()) {
                String line = in.readLine();
                if (line == null) return false;
                st = new StringTokenizer(line);
            }
            return st.hasMoreTokens();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String next() {
        return hasNext() ? st.nextToken() : null;
    }

    private int nextInt() {
        return Integer.parseInt(next());
    }

    private BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    private long nextLong() {
        return Long.parseLong(next());
    }

    private double nextDouble() {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }
}