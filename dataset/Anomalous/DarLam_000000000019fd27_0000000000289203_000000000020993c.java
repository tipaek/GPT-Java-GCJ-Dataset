import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Solution implements Runnable {

    private PrintStream out;
    private BufferedReader in;
    private StringTokenizer st;

    public void solve() throws IOException {
        long startTime = System.currentTimeMillis();

        int testCases = nextInt();
        for (int test = 1; test <= testCases; test++) {
            int n = nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = nextInt();
                }
            }
            String result = solveCase(n, matrix);
            out.println("Case #" + test + ": " + result);
        }

        System.err.println("Execution time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    private String solveCase(int n, int[][] matrix) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;
        int[] used = new int[n + 1];
        int marker = 0;

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
            marker++;
            for (int j = 0; j < n; j++) {
                if (used[matrix[i][j]] == marker) {
                    rowDuplicates++;
                    break;
                } else {
                    used[matrix[i][j]] = marker;
                }
            }
            marker++;
            for (int j = 0; j < n; j++) {
                if (used[matrix[j][i]] == marker) {
                    colDuplicates++;
                    break;
                } else {
                    used[matrix[j][i]] = marker;
                }
            }
        }
        return trace + " " + rowDuplicates + " " + colDuplicates;
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