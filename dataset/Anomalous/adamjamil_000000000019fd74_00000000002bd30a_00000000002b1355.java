import javafx.util.Pair;
import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    private boolean multiple = true;
    private long MOD;
    private int caseNum = 0;
    private BufferedReader in;
    private FastScanner sc;
    private PrintWriter out;
    private StringBuilder ANS = new StringBuilder();
    private static Throwable uncaught;

    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread(null, new Solution(), "", 1 << 26);
        thread.start();
        thread.join();
        if (uncaught != null) {
            throw uncaught;
        }
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            sc = new FastScanner(in);
            if (multiple) {
                int q = sc.nextInt();
                for (int i = 0; i < q; i++) {
                    solve();
                }
            } else {
                solve();
            }
            System.out.print(ANS);
        } catch (Throwable t) {
            uncaught = t;
        } finally {
            out.close();
        }
    }

    private void solve() throws Exception {
        caseNum++;
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] val = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                val[i][j] = sc.nextInt();
            }
        }

        long ans = 0;
        while (true) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ans += val[i][j];
                }
            }

            List<Pair<Integer, Integer>> remove = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (val[i][j] == 0) continue;
                    int neigh = 0, neighs = 0;

                    for (int k = i - 1; k >= 0; k--) {
                        if (val[k][j] != 0) {
                            neigh += val[k][j];
                            neighs++;
                            break;
                        }
                    }
                    for (int k = i + 1; k < r; k++) {
                        if (val[k][j] != 0) {
                            neigh += val[k][j];
                            neighs++;
                            break;
                        }
                    }
                    for (int k = j + 1; k < c; k++) {
                        if (val[i][k] != 0) {
                            neigh += val[i][k];
                            neighs++;
                            break;
                        }
                    }
                    for (int k = j - 1; k >= 0; k--) {
                        if (val[i][k] != 0) {
                            neigh += val[i][k];
                            neighs++;
                            break;
                        }
                    }

                    if (neighs == 0) continue;
                    if (val[i][j] * neighs < neigh) {
                        remove.add(new Pair<>(i, j));
                    }
                }
            }

            if (remove.isEmpty()) break;
            for (Pair<Integer, Integer> pair : remove) {
                val[pair.getKey()][pair.getValue()] = 0;
            }
        }

        pl("Case #" + caseNum + ": " + ans);
    }

    private void p(Object s) {
        ANS.append(s);
    }

    private void pl(Object s) {
        ANS.append(s).append('\n');
    }

    private void pl() {
        ANS.append('\n');
    }

    private static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(BufferedReader in) {
            this.in = in;
        }

        public String nextToken() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() throws Exception {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() throws Exception {
            return Double.parseDouble(nextToken());
        }
    }
}