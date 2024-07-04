import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
        TaskE solver = new TaskE();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), K = in.nextInt();
            out.print("Case #" + testNumber + ": ");
            if (K == N + 1 || K == N * N - 1 || (N <= 3 && K % N > 0)) {
                out.printLine("IMPOSSIBLE");
                return;
            }
            out.printLine("POSSIBLE");
            int a[][] = new int[N][N];
            if (K % N == 0) {
                for (int i = 0; i < N; i++) {
                    int j = i;
                    int c = 1;
                    while (c <= N) {
                        a[i][j] = c;
                        c++;
                        j = (j + 1) % N;
                    }
                }
                if (K != N) {
                    int div = K / N;
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            if (a[i][j] == div) {
                                a[i][j] = 1;
                            } else if (a[i][j] == 1) {
                                a[i][j] = div;
                            }
                        }
                    }
                }
            } else {
                int x = 0, y = 0;
                for (int i = 1; i <= N; i++) {
                    int rem = K - (N - 2) * i;
                    if (rem % 2 == 0) {
                        x = i;
                        y = rem / 2;
                        break;
                    }
                }
                for (int i = 0; i < N - 2; i++) {
                    a[i][i] = x;
                    a[i][(i + 1) % (N - 2)] = y;
                }
                a[N - 2][N - 2] = y;
                a[N - 2][N - 1] = x;
                a[N - 1][N - 2] = x;
                a[N - 1][N - 1] = y;
                boolean columnsFilled[][] = new boolean[N + 1][N];
                for (int i = 0; i < N; i++) {
                    for (int num = 1; num <= N; num++) {
                        if (num == x || num == y) {
                            continue;
                        }
                        int j = (i + 1) % N;
                        while (a[i][j] != 0 || columnsFilled[num][j]) {
                            j = (j + 1) % N;
                        }
                        a[i][j] = num;
                        columnsFilled[num][j] = true;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    out.print(a[i][j]);
                    if (j < N - 1) {
                        out.print(" ");
                    }
                }
                out.printLine();
            }
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

