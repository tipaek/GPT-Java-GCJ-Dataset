import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;
    private boolean eof = false;

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int testCount = nextInt();
        int lowerBound = nextInt();
        int upperBound = nextInt();
        for (int test = 1; test <= testCount; test++) {
            solve();
        }
        out.close();
    }

    private String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return "0";
            }
        }
        return st.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private static final int SIZE = (int) 1e9;
    private static final int RAD = SIZE / 2;
    private static final String CENTER = "CENTER";
    private static final String HIT = "HIT";
    private static final String MISS = "MISS";

    private void solve() {
        Random rand = new Random(12345);
        double sumX = 0;
        double sumY = 0;
        int hitCount = 0;

        for (int i = 0; i < 219; i++) {
            int side = rand.nextInt(4);
            int x = SIZE - rand.nextInt(51);
            int y = rand.nextInt(2 * SIZE + 1) - SIZE;

            if (side % 2 == 0) {
                x = -x;
            }
            if (side / 2 == 0) {
                int temp = x;
                x = y;
                y = temp;
            }

            out.println(x + " " + y);
            out.flush();
            String response = nextToken();

            if (response.equals(CENTER)) {
                return;
            }
            if (response.equals(HIT)) {
                sumX += x;
                sumY += y;
                hitCount++;
            }
        }

        int centerX = (int) Math.round(sumX / hitCount);
        int centerY = (int) Math.round(sumY / hitCount);

        for (int x = centerX - 4; x <= centerX + 4; x++) {
            for (int y = centerY - 4; y <= centerY + 4; y++) {
                out.println(x + " " + y);
                out.flush();
                String response = nextToken();
                if (response.equals(CENTER)) {
                    return;
                }
            }
        }
    }
}