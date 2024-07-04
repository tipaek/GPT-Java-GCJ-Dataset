import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final char[] NAMES = {'C', 'J'};
    
    private PrintStream out;
    private BufferedReader in;
    private StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Thread(new Solution(null)).start();
    }

    public Solution(String filename) throws IOException {
        Locale.setDefault(Locale.US);
        if (filename == null) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintStream(new BufferedOutputStream(System.out));
        } else {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(filename + ".in")));
            out = new PrintStream(new BufferedOutputStream(new FileOutputStream(filename + ".out")));
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

        int testCases = nextInt();
        for (int test = 1; test <= testCases; test++) {
            int n = nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = nextInt();
                endTimes[i] = nextInt();
            }

            char[] result = assignTasks(n, startTimes, endTimes);
            out.print("Case #" + test + ": ");
            if (result == null) {
                out.print(IMPOSSIBLE);
            } else {
                for (char c : result) {
                    out.print(c);
                }
            }
            out.println();
        }

        System.err.println("time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    private char[] assignTasks(int n, int[] startTimes, int[] endTimes) {
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(i -> startTimes[i]));

        char[] assignments = new char[n];
        int[] busyUntil = new int[NAMES.length];

        for (int index : indices) {
            int taskIndex = -1;
            for (int j = 0; j < busyUntil.length; j++) {
                if (busyUntil[j] <= startTimes[index]) {
                    taskIndex = j;
                    break;
                }
            }
            if (taskIndex == -1) {
                return null;
            }
            busyUntil[taskIndex] = endTimes[index];
            assignments[index] = NAMES[taskIndex];
        }
        return assignments;
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