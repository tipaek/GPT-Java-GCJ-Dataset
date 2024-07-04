import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        TaskB solver = new TaskB();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskB {
        int L = 33;
        long pascal = new long[L + 1][L + 1];
        boolean visited = new boolean[L + 1][L + 1];
        ArrayList<String> result;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            long N = in.nextInt();
            out.printLine("Case #" + testNumber + ": ");
            result = new ArrayList<>();
            pascal[0][0] = 1;
            for (int i = 1; i < L; i++) {
                pascal[i][0] = 1;
                for (int j = 1; j <= i; j++) {
                    pascal[i][j] = pascal[i - 1][j] + pascal[i - 1][j - 1];
                }
            }
            visited[0][0] = true;
            recur(0, 0, N, new int[1000], new int[1000], 0);
            for (String res : result) {
                out.printLine(res);
            }
//        DebugUtils.debug(result);
        }

        public void recur(int row, int col, long rem, int X[], int Y[], int index) {
            if (result.size() > 0) {
                return;
            }
            X[index] = row + 1;
            Y[index] = col + 1;
            long sum = 0;
            if (pascal[row][col] == rem) {
                for (int i = 0; i <= index; i++) {
                    result.add(X[i] + " " + Y[i]);
                    sum += pascal[X[i] - 1][Y[i] - 1];
                }
//            DebugUtils.debug(sum);
                return;
            }
            int dx[] = {-1, -1, 0, 0, 1, 1};
            int dy[] = {-1, 0, -1, 1, 0, 1};
            for (int i = 0; i < dx.length; i++) {

                int newX = row + dx[i], newY = col + dy[i];
                if (newX >= 0 && newY >= 0 && newX <= L && newY <= L && pascal[newX][newY] != 0 && pascal[newX][newY] <= rem - pascal[row][col]) {
                    if (!visited[newX][newY]) {
                        visited[newX][newY] = true;
                        recur(newX, newY, rem - pascal[row][col], X, Y, index + 1);
                        visited[newX][newY] = false;
                    }
                }
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

