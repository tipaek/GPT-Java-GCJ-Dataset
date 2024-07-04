import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskVestigium solver = new TaskVestigium();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskVestigium {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            int num = 0;
            while (t > 0) {
                num++;
                t--;
                int n = in.nextInt();
                int[][] ar = new int[n][n];
                int r = 0;
                for (int i = 0; i < n; i++) {
                    int[] cnt = new int[n];
                    boolean ok = true;
                    for (int j = 0; j < n; j++) {
                        ar[i][j] = in.nextInt();
                        cnt[ar[i][j] - 1]++;
                        if (cnt[ar[i][j] - 1] > 1)
                            ok = false;
                    }
                    if (!ok)
                        r++;
                }
                int trace = 0;
                for (int i = 0; i < n; i++)
                    trace += ar[i][i];
                int c = 0;
                for (int i = 0; i < n; i++) {
                    int[] cnt = new int[n];
                    boolean ok = true;
                    for (int j = 0; j < n; j++) {
                        cnt[ar[j][i] - 1]++;
                        if (cnt[ar[j][i] - 1] > 1)
                            ok = false;
                    }
                    if (!ok)
                        c++;
                }
                out.println("Case #" + num + ": " + trace + " " + r + " " + c);
            }
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

