import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
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
        OutputWriter out = new OutputWriter(outputStream);
        TaskC solver = new TaskC();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), M = in.nextInt();
            int a[][] = new int[N][M];
            long total = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    a[i][j] = in.nextInt();
                    total += a[i][j];
                }
            }
            long ans = 0;
            while (true) {
                List<Integer> X = new ArrayList<>();
                List<Integer> Y = new ArrayList<>();
                ans += total;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (a[i][j] == -1) {
                            continue;
                        }
                        double neighbours = 0;
                        int num = 0;
                        for (int k = j + 1; k < M; k++) {
                            if (a[i][k] != -1) {
                                neighbours += a[i][k];
                                num++;
                                break;
                            }
                        }
                        for (int k = i + 1; k < N; k++) {
                            if (a[k][j] != -1) {
                                neighbours += a[k][j];
                                num++;
                                break;
                            }
                        }
                        for (int k = j - 1; k >= 0; k--) {
                            if (a[i][k] != -1) {
                                neighbours += a[i][k];
                                num++;
                                break;
                            }
                        }
                        for (int k = i - 1; k >= 0; k--) {
                            if (a[k][j] != -1) {
                                neighbours += a[k][j];
                                num++;
                                break;
                            }
                        }
                        if (neighbours / num > a[i][j]) {
                            X.add(i);
                            Y.add(j);
                        }
                    }
                }
                if (X.size() == 0) {
                    break;
                }
                for (int x = 0; x < X.size(); x++) {
                    total -= a[X.get(x)][Y.get(x)];
                    a[X.get(x)][Y.get(x)] = -1;
                }
            }
            out.printLine("Case #" + testNumber + ": " + ans);
        }

    }

    static class InputReader {
        BufferedReader in;
        StringTokenizer tokenizer = null;

        public InputReader(InputStream inputStream) {
            in = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            try {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(in.readLine());
                }
                return tokenizer.nextToken();
            } catch (IOException e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

    static class OutputWriter {
        PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}

