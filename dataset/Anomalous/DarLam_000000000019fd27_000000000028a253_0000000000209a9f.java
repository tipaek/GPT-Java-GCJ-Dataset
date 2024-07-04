import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Solution implements Runnable {

    private PrintStream out;
    private BufferedReader in;
    private StringTokenizer st;

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

    @Override
    public void run() {
        try {
            solve();
            out.close();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws IOException {
        long startTime = System.currentTimeMillis();

        int t = nextInt();
        for (int test = 1; test <= t; test++) {
            String s = next();
            String result = processString(s);
            out.println("Case #" + test + ": " + result);
        }

        System.err.println("time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    private String processString(String s) {
        StringBuilder builder = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            adjustDepth(currentDepth, digit, builder);
            builder.append(digit);
            currentDepth = digit;
        }

        adjustDepth(currentDepth, 0, builder);
        return builder.toString();
    }

    private void adjustDepth(int from, int to, StringBuilder builder) {
        for (int i = from; i < to; i++) {
            builder.append("(");
        }
        for (int i = from; i > to; i--) {
            builder.append(")");
        }
    }

    private String next() throws IOException {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}