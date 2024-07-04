import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; i++) {
            scheduler.solve(i, in, out);
        }
        out.close();
    }

    static class Scheduler {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] intervals = readIntervals(in, n);
            Arrays.sort(intervals, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
            char[] result = new char[n];
            Arrays.fill(result, 'C');

            int cEnd = intervals[0][1], jEnd = -1;
            boolean possible = true;
            for (int i = 1; i < n; i++) {
                if (cEnd > intervals[i][0]) {
                    if (jEnd <= intervals[i][0]) {
                        jEnd = intervals[i][1];
                        result[intervals[i][2]] = 'J';
                    } else {
                        possible = false;
                        break;
                    }
                } else {
                    cEnd = intervals[i][1];
                }
            }

            if (!possible) {
                out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            } else {
                out.printf("Case #%d: %s\n", testNumber, new String(result));
            }
        }

        private int[][] readIntervals(InputReader in, int n) {
            int[][] intervals = new int[n][3];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = in.nextInt();
                intervals[i][1] = in.nextInt();
                intervals[i][2] = i;
            }
            return intervals;
        }
    }

    static class NestingDepth {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String s = in.next();
            StringBuilder sb = new StringBuilder();
            int currentDepth = 0;
            for (char c : s.toCharArray()) {
                int num = c - '0';
                while (num < currentDepth) {
                    sb.append(')');
                    currentDepth--;
                }
                while (num > currentDepth) {
                    sb.append('(');
                    currentDepth++;
                }
                sb.append(c);
            }
            while (currentDepth > 0) {
                sb.append(')');
                currentDepth--;
            }
            out.printf("Case #%d: %s\n", testNumber, sb.toString());
        }
    }

    static class Vestigium {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] matrix = readMatrix(in, n);
            boolean[][] rowCheck = new boolean[n][n + 1];
            boolean[][] colCheck = new boolean[n][n + 1];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) trace += matrix[i][j];
                    int value = matrix[i][j];
                    if (rowCheck[i][value] && !rowCheck[i][0]) {
                        rowRepeats++;
                        rowCheck[i][0] = true;
                    }
                    if (colCheck[j][value] && !colCheck[j][0]) {
                        colRepeats++;
                        colCheck[j][0] = true;
                    }
                    rowCheck[i][value] = true;
                    colCheck[j][value] = true;
                }
            }
            out.printf("Case #%d: %d %d %d\n", testNumber, trace, rowRepeats, colRepeats);
        }

        private int[][] readMatrix(InputReader in, int n) {
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                matrix[i] = in.readArray(n);
            }
            return matrix;
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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

        public int[] readArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }
    }
}