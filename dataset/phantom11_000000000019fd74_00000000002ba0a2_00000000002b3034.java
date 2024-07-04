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
        TaskA solver = new TaskA();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            String strings[] = new String[N];
            int index[] = new int[N];
            int lengths[] = new int[N];
            for (int i = 0; i < N; i++) {
                strings[i] = in.next();
                lengths[i] = strings[i].length();
            }
            StringBuilder ans = new StringBuilder();
            String starts = "", ends = "";
            boolean impossible = false;
            for (int i = 0; i < N; i++) {
                int j = 0, k = lengths[i] - 1;
                String currentStart = "", currentEnd = "";
                while (j < lengths[i] && strings[i].charAt(j) != '*') {
                    currentStart += strings[i].charAt(j);
                    j++;
                }
                while (k >= 0 && strings[i].charAt(k) != '*') {
                    currentEnd = strings[i].charAt(k) + currentEnd;
                    k--;
                }
                for (int p = j + 1; p < k; p++) {
                    if (strings[i].charAt(p) != '*') {
                        ans.append(strings[i].charAt(p));
                    }
                }
                int p = starts.length(), q = currentStart.length();
                if (p >= q) {
                    if (!starts.substring(0, q).equals(currentStart)) {
                        impossible = true;
                    }
                } else {
                    if (!currentStart.substring(0, p).equals(starts)) {
                        impossible = true;
                    }
                    starts = currentStart;
                }
                p = ends.length();
                q = currentEnd.length();
                if (p >= q) {
                    if (!ends.substring(p - q).equals(currentEnd)) {
                        impossible = true;
                    }
                } else {
                    if (!currentEnd.substring(q - p).equals(ends)) {
                        impossible = true;
                    }
                    ends = currentEnd;
                }
                if (impossible) {
                    break;
                }
            }
            if (impossible) {
                ans = new StringBuilder("*");
            } else {
                ans = new StringBuilder(starts).append(ans).append(ends);
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

