import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Solution implements Runnable {

    private PrintStream out;
    private BufferedReader in;
    private StringTokenizer st;

    public void solve() throws IOException {
        long startTime = System.currentTimeMillis();

        int t = nextInt();
        for (int test = 1; test <= t; test++) {
            long l = nextLong();
            long r = nextLong();
            String answer = computeAnswer(l, r);
            out.println("Test #" + test + ": " + answer);
        }

        System.err.println("Execution time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    private String computeAnswer(long l, long r) {
        long[] state = {0, l, r};
        reduce(state, 1);
        reduce(state, 2);
        reduceBoth(state);
        reduceOne(state);
        return state[0] + " " + state[1] + " " + state[2];
    }

    private void reduceBoth(long[] state) {
        int f = state[1] >= state[2] ? 1 : 2;
        long low = 0, high = 1000000000;
        while (low + 1 < high) {
            long mid = (low + high) / 2;
            if (isValidReduction(state, f, mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        applyReduction(state, f, low);
    }

    private boolean isValidReduction(long[] state, int f, long mid) {
        return state[f] - state[0] * mid - mid * mid >= 0 &&
               state[3 - f] - state[0] * mid - mid * (mid + 1) >= 0;
    }

    private void applyReduction(long[] state, int f, long value) {
        state[f] -= state[0] * value + value * value;
        state[3 - f] -= state[0] * value + value * (value + 1);
        state[0] += 2 * value;
    }

    private void reduceOne(long[] state) {
        int f = state[1] >= state[2] ? 1 : 2;
        long low = 0, high = 2;
        while (low + 1 < high) {
            long mid = (low + high) / 2;
            if (state[f] - state[0] * mid - mid * (mid + 1) / 2 >= 0) {
                low = mid;
            } else {
                high = mid;
            }
        }
        state[f] -= state[0] * low + low * (low + 1) / 2;
        state[0] += low;
    }

    private void reduce(long[] state, int p) {
        long low = 0, high = 1000000000;
        while (low + 1 < high) {
            long mid = (low + high) / 2;
            if (isReductionPossible(state, p, mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        state[p] -= state[0] * low + low * (low + 1) / 2;
        state[0] += low;
    }

    private boolean isReductionPossible(long[] state, int p, long mid) {
        return state[p] - state[0] * mid - mid * (mid + 1) / 2 >= 0 &&
               state[p] - state[0] * mid - mid * (mid + 1) / 2 >= state[3 - p];
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    @Override
    public void run() {
        try {
            solve();
            out.close();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public Solution(String name) throws IOException {
        Locale.setDefault(Locale.US);
        if (name == null) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintStream(new BufferedOutputStream(System.out));
        } else {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(name + ".in")));
            out = new PrintStream(new BufferedOutputStream(new FileOutputStream(name + ".out")));
        }
        st = new StringTokenizer("");
    }

    public static void main(String[] args) throws IOException {
        new Thread(new Solution(null)).start();
    }
}