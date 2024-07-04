import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Aydar Gizatullin a.k.a. lightning95, aydar.gizatullin@gmail.com
 */
public class Solution {

    private void solveOne() {
        int n = rw.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                a[i][j] = rw.nextInt();
        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0;
        for (int i = 0; i < n; ++i) {
            ans1 += a[i][i];
        }

        for (int i = 0; i < n; ++i) {
            boolean[] us = new boolean[n + 1];
            for (int j = 0; j < n; ++j) {
                if (us[a[i][j]]) {
                    ans2++;
                    break;
                }
                us[a[i][j]] = true;
            }

            Arrays.fill(us, false);
            for (int j = 0; j < n; ++j) {
                if (us[a[j][i]]) {
                    ans3++;
                    break;
                }
                us[a[j][i]] = true;
            }
        }
        rw.print(ans1 + " " + ans2 + " " + ans3);
    }

    private void solve() {
        int t = rw.nextInt();
        for (int i = 1; i <= t; ++i) {
            rw.print("Case #" + i + ": ");
            solveOne();

            rw.println();
        }
    }

    private RW rw;
    private String FILE_NAME = "file";

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        rw = new RW(FILE_NAME + ".in", FILE_NAME + ".out");
        solve();
        rw.close();
    }

    private class RW {
        private StringTokenizer st;
        private PrintWriter out;
        private BufferedReader br;
        private boolean eof;

        RW(String inputFile, String outputFile) {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));

//            File f = new File(inputFile);
//            if (f.exists() && f.canRead()) {
//                try {
//                    br = new BufferedReader(new FileReader(inputFile));
//                    out = new PrintWriter(new FileWriter(outputFile));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }

        private String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }

        private String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    eof = true;
                    return "-1";
                }
            }
            return st.nextToken();
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private void println() {
            out.println();
        }

        private void println(Object o) {
            out.println(o);
        }

        private void print(Object o) {
            out.print(o);
        }

        private void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.close();
        }
    }
}