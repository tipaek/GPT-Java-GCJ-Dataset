import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    private class CenterException extends RuntimeException {
    }

    private boolean hit(int x, int y) {
        pw.printf("%d %d\n", x, y);
        pw.flush();
        String response = nextToken();
        System.err.printf("ASK for %d %d => %s\n", x, y, response);
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

    private int findCenterX(int x, int y) {
        int left = -1_000_000_000;
        int right = x;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (hit(mid, y)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        int leftX = right;

        left = x;
        right = 1_000_000_000;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (hit(mid, y)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int rightX = left;
        return (leftX + rightX) / 2;
    }

    private int findCenterY(int x, int y) {
        int left = -1_000_000_000;
        int right = y;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (hit(x, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        int leftY = right;

        left = y;
        right = 1_000_000_000;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (hit(x, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int rightY = left;
        return (leftY + rightY) / 2;
    }

    private void solveCase(int a, int b) {
        Random random = new Random();
        int x, y;
        while (true) {
            x = random.nextInt(2_000_000_000) - 1_000_000_000;
            y = random.nextInt(2_000_000_000) - 1_000_000_000;
            if (hit(x, y)) break;
        }
        while (true) {
            System.err.printf("CALC %d %d\n", x, y);
            x = findCenterX(x, y);
            System.err.printf("CALC %d %d\n", x, y);
            y = findCenterY(x, y);
            System.err.printf("CALC %d %d\n", x, y);
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    hit(x + i, y + j);
                }
            }
        }
    }

    private void solve() {
        int t = nextInt();
        int a = nextInt();
        int b = nextInt();
        for (int i = 0; i < t; ++i) {
            try {
                solveCase(a, b);
            } catch (CenterException e) {
                System.err.println("CENTER");
            }
        }
    }

    private static final String FILENAME = "A";
    private static final boolean FROM_CONSOLE = true;

    public void run() {
        try {
            if (!FROM_CONSOLE) {
                in = new BufferedReader(new FileReader(FILENAME + ".in"));
                pw = new PrintWriter(FILENAME + ".out");
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                pw = new PrintWriter(System.out);
            }
            tokenizer = new StringTokenizer("");
            solve();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private StringTokenizer tokenizer;
    private BufferedReader in;
    private PrintWriter pw;

    private boolean hasNextToken() {
        try {
            while (!tokenizer.hasMoreTokens()) {
                String line = in.readLine();
                if (line == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.hasMoreTokens();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String nextToken() {
        return hasNextToken() ? tokenizer.nextToken() : null;
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private BigInteger nextBigInteger() {
        return new BigInteger(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }
}