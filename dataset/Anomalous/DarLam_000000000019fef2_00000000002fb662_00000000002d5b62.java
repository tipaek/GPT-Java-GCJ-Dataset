import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Solution implements Runnable {

    public static final int MAXL = 31;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

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

    public void solve() throws IOException {
        long startTime = System.currentTimeMillis();

        int t = nextInt();
        for (int test = 1; test <= t; test++) {
            int x = nextInt();
            int y = nextInt();
            String result = findPath(x, y);
            out.println("Case #" + test + ": " + result);
        }

        System.err.println("time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    private String findPath(int x, int y) {
        char[] dx = {'E', 'W'};
        char[] dy = {'N', 'S'};
        if (x < 0) {
            x = -x;
            invertArray(dx);
        }
        if (y < 0) {
            y = -y;
            invertArray(dy);
        }
        return findPath(x, dx, y, dy);
    }

    private String findPath(int x, char[] dx, int y, char[] dy) {
        boolean[][][] canReach = new boolean[MAXL + 1][2][2];
        int[][][] fromX = new int[MAXL + 1][2][2];
        int[][][] fromY = new int[MAXL + 1][2][2];
        char[][][] fromChar = new char[MAXL + 1][2][2];
        canReach[0][0][0] = true;

        for (int i = 0; ; i++) {
            if (x == 0 && y == 0 && canReach[i][0][0]) {
                return reconstructPath(i, fromX, fromY, fromChar);
            }
            if (i + 1 >= canReach.length) {
                break;
            }
            for (int s0 = 0; s0 < 2; s0++) {
                for (int s1 = 0; s1 < 2; s1++) {
                    if (canReach[i][s0][s1]) {
                        if (isValidMove(x, 1, s0) && isValidMove(y, 0, s1)) {
                            updateState(i + 1, 0, s1, dx[0], s0, s1, canReach, fromX, fromY, fromChar);
                        }
                        if (isValidMove(x, 1, s0) && isValidMove(y, 0, s1)) {
                            updateState(i + 1, 1, s1, dx[1], s0, s1, canReach, fromX, fromY, fromChar);
                        }
                        if (isValidMove(x, 0, s0) && isValidMove(y, 1, s1)) {
                            updateState(i + 1, s0, 0, dy[0], s0, s1, canReach, fromX, fromY, fromChar);
                        }
                        if (isValidMove(x, 0, s0) && isValidMove(y, 1, s1)) {
                            updateState(i + 1, s0, 1, dy[1], s0, s1, canReach, fromX, fromY, fromChar);
                        }
                    }
                }
            }
            x /= 2;
            y /= 2;
        }
        return IMPOSSIBLE;
    }

    private void updateState(int i, int s0, int s1, char c, int prevS0, int prevS1, boolean[][][] canReach, int[][][] fromX, int[][][] fromY, char[][][] fromChar) {
        canReach[i][s0][s1] = true;
        fromX[i][s0][s1] = prevS0;
        fromY[i][s0][s1] = prevS1;
        fromChar[i][s0][s1] = c;
    }

    private boolean isValidMove(int coord, int add, int s) {
        return (coord % 2) == (add ^ s);
    }

    private String reconstructPath(int i, int[][][] fromX, int[][][] fromY, char[][][] fromChar) {
        char[] result = new char[i];
        int s0 = 0;
        int s1 = 0;
        for (int j = i; j > 0; j--) {
            result[j - 1] = fromChar[j][s0][s1];
            int prevS0 = fromX[j][s0][s1];
            int prevS1 = fromY[j][s0][s1];
            s0 = prevS0;
            s1 = prevS1;
        }
        return new String(result);
    }

    private void invertArray(char[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
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