import java.io.*;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;

public class Solution {

    private void solve(int t) throws IOException {
        int n = in.nextInt();
        int[][] ints = in.next2Ints(n, n);

        int k = 0, r = 0, c = 0;

        for (int i = 0; i < n; i++) {
            k += ints[i][i];
        }

        for (int i = 0; i < n; i++) {
            boolean[] seenR = new boolean[n];
            boolean[] seenC = new boolean[n];
            for (int j = 0; j < n; j++) {
                seenR[ints[i][j] - 1] = true;
                seenC[ints[j][i] - 1] = true;
            }

            for (boolean b : seenR) {
                if (!b) {
                    r += 1;
                    break;
                }
            }

            for (boolean b : seenC) {
                if (!b) {
                    c += 1;
                    break;
                }
            }
        }

        out.println("Case #" + t + ": " + k + " " + r + " " + c);
    }

    private FastScanner in;
    private PrintWriter out;

    private void run() throws IOException, ExecutionException, InterruptedException {
        in = new FastScanner();
        out = new PrintWriter(System.out, false);
        try {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                solve(1 + i);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            out.flush();
        }
    }

    void check(boolean b) {
        if (!b) throw new RuntimeException();
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
//        Integer stackSize = null;
        Integer stackSize = 1 << 28; // 256mb
        if (stackSize != null) {
            new Thread(null, new Runnable() {
                @Override
                public void run() {
                    try {
                        new Solution().run();
                    } catch (IOException | ExecutionException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "", stackSize).start();
        } else {
            new Solution().run();
        }
    }
}

class FastScanner {
    private final BufferedReader br;
    private StringTokenizer st;
    private String last;

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastScanner(String path) throws IOException {
        br = new BufferedReader(new FileReader(path));
    }

    public FastScanner(String path, String decoder) throws IOException {
        br = new BufferedReader(new InputStreamReader(new FileInputStream(path), decoder));
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreElements())
            st = new StringTokenizer(br.readLine());
        last = null;
        return st.nextToken();
    }

    String nextLine() throws IOException {
        st = null;
        return (last == null) ? br.readLine() : last;
    }

    boolean hasNext() {
        if (st != null && st.hasMoreElements())
            return true;

        try {
            while (st == null || !st.hasMoreElements()) {
                last = br.readLine();
                st = new StringTokenizer(last);
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    String[] nextStrings(int n) throws IOException {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = next();
        return arr;
    }

    String[] nextLines(int n) throws IOException {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextLine();
        return arr;
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    int[] nextInts(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextInt();
        return arr;
    }

    Integer[] nextIntegers(int n) throws IOException {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextInt();
        return arr;
    }

    int[][] next2Ints(int n, int m) throws IOException {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = nextInt();
        return arr;
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    long[] nextLongs(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextLong();
        return arr;
    }

    long[][] next2Longs(int n, int m) throws IOException {
        long[][] arr = new long[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = nextLong();
        return arr;
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next().replace(',', '.'));
    }

    double[] nextDoubles(int size) throws IOException {
        double[] arr = new double[size];
        for (int i = 0; i < size; i++)
            arr[i] = nextDouble();
        return arr;
    }

    boolean nextBool() throws IOException {
        String s = next();
        if (s.equalsIgnoreCase("true") || s.equals("1"))
            return true;

        if (s.equalsIgnoreCase("false") || s.equals("0"))
            return false;

        throw new IOException("Boolean expected, String found!");
    }

    public double[][] next2Doubles(int n, int m) throws IOException {
        double[][] arr = new double[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = nextDoubles(m);
        }
        return arr;
    }
}
