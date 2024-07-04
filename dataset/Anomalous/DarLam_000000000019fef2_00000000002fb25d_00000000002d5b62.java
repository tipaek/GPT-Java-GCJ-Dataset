import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Solution implements Runnable {

    private static final int MAXL = 30;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private PrintStream out;
    private BufferedReader in;
    private StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Thread(new Solution(null)).start();
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
            int x = nextInt();
            int y = nextInt();
            String answer = findPath(x, y);
            out.println("Case #" + test + ": " + answer);
        }

        System.err.println("time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    private String findPath(int x, int y) {
        char[] dx = new char[]{'E', 'W'};
        char[] dy = new char[]{'N', 'S'};
        if (x < 0) {
            x = -x;
            reverseArray(dx);
        }
        if (y < 0) {
            y = -y;
            reverseArray(dy);
        }
        return findPath(x, dx, y, dy);
    }

    private String findPath(int x, char[] dx, int y, char[] dy) {
        boolean[][][] can = new boolean[MAXL + 1][2][2];
        int[][][] fromS0 = new int[MAXL + 1][2][2];
        int[][][] fromS1 = new int[MAXL + 1][2][2];
        char[][][] fromChar = new char[MAXL + 1][2][2];
        can[0][0][0] = true;

        for (int i = 0; ; i++) {
            if (x == 0 && y == 0 && can[i][0][0]) {
                return reconstructPath(i, fromS0, fromS1, fromChar);
            }
            if (i + 1 >= can.length) {
                break;
            }
            for (int s0 = 0; s0 < 2; s0++) {
                for (int s1 = 0; s1 < 2; s1++) {
                    if (can[i][s0][s1]) {
                        if (isValid(x, 1, s0) && isValid(y, 0, s1)) {
                            updateState(i + 1, 0, s1, dx[0], s0, s1, can, fromS0, fromS1, fromChar);
                        }
                        if (isValid(x, 1, s0) && isValid(y, 0, s1)) {
                            updateState(i + 1, 1, s1, dx[1], s0, s1, can, fromS0, fromS1, fromChar);
                        }
                        if (isValid(x, 0, s0) && isValid(y, 1, s1)) {
                            updateState(i + 1, s0, 0, dy[0], s0, s1, can, fromS0, fromS1, fromChar);
                        }
                        if (isValid(x, 0, s0) && isValid(y, 1, s1)) {
                            updateState(i + 1, s0, 1, dy[1], s0, s1, can, fromS0, fromS1, fromChar);
                        }
                    }
                }
            }
            x /= 2;
            y /= 2;
        }
        return IMPOSSIBLE;
    }

    private void updateState(int i, int s0, int s1, char c, int prevS0, int prevS1, boolean[][][] can, int[][][] fromS0, int[][][] fromS1, char[][][] fromChar) {
        can[i][s0][s1] = true;
        fromS0[i][s0][s1] = prevS0;
        fromS1[i][s0][s1] = prevS1;
        fromChar[i][s0][s1] = c;
    }

    private boolean isValid(int x, int add, int s) {
        return (x % 2) == (add ^ s);
    }

    private String reconstructPath(int i, int[][][] fromS0, int[][][] fromS1, char[][][] fromChar) {
        char[] result = new char[i];
        int s0 = 0;
        int s1 = 0;
        for (int j = i; j > 0; j--) {
            result[j - 1] = fromChar[j][s0][s1];
            int ps0 = fromS0[j][s0][s1];
            int ps1 = fromS1[j][s0][s1];
            s0 = ps0;
            s1 = ps1;
        }
        return new String(result);
    }

    private void reverseArray(char[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(next());
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
}