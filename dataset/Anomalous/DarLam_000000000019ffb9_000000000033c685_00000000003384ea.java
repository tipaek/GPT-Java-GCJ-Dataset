import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Solution implements Runnable {

    private PrintStream out;
    private BufferedReader in;
    private StringTokenizer st;

    @Override
    public void run() {
        try {
            solve();
            out.close();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void solve() throws IOException {
        long startTime = System.currentTimeMillis();

        int testCases = nextInt();
        for (int test = 1; test <= testCases; test++) {
            long l = nextLong();
            long r = nextLong();
            String answer = calculateAnswer(l, r);
            out.println("Test #" + test + ": " + answer);
        }

        System.err.println("Execution time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    private String calculateAnswer(long l, long r) {
        long[] state = {0, l, r};
        reduce(state, 1);
        reduce(state, 2);
        for (int i = 0; i < 100; i++) {
            reduceSingle(state);
        }
        reduceBoth(state);
        reduceSingle(state);
        return state[0] + " " + state[1] + " " + state[2];
    }

    private void reduceBoth(long[] state) {
        int index = state[1] >= state[2] ? 1 : 2;
        long left = 0;
        long right = 1000000000;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            if (state[index] - state[0] * mid - mid * mid >= 0 && state[3 - index] - state[0] * mid - mid * (mid + 1) >= 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        state[index] -= state[0] * left + left * left;
        state[3 - index] -= state[0] * left + left * (left + 1);
        state[0] += 2 * left;
    }

    private void reduceSingle(long[] state) {
        int index = state[1] >= state[2] ? 1 : 2;
        long left = 0;
        long right = 2;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            if (state[index] - state[0] * mid - mid * (mid + 1) / 2 >= 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        state[index] -= state[0] * left + left * (left + 1) / 2;
        state[0] += left;
    }

    private void reduce(long[] state, int position) {
        long left = 0;
        long right = 1000000000;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            if (state[position] - state[0] * mid - mid * (mid + 1) / 2 >= 0 &&
                state[position] - state[0] * mid - mid * (mid + 1) / 2 >= state[3 - position]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        state[position] -= state[0] * left + left * (left + 1) / 2;
        state[0] += left;
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

    public Solution(String fileName) throws IOException {
        Locale.setDefault(Locale.US);
        if (fileName == null) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintStream(new BufferedOutputStream(System.out));
        } else {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName + ".in")));
            out = new PrintStream(new BufferedOutputStream(new FileOutputStream(fileName + ".out")));
        }
        st = new StringTokenizer("");
    }

    public static void main(String[] args) throws IOException {
        new Thread(new Solution(null)).start();
    }
}