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
        TaskD solver = new TaskD();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int T = in.nextInt(), B = in.nextInt();
            while (T-- > 0) {
                int a[] = new int[B];
                for (int i = 0; i < B; i++) {
                    a[i] = query(out, i + 1, in);
                }
                boolean allSamePairings = true, allDifferentPairings = true;
                int x = 0, y = 0;
                for (int i = 0; i < B / 2; i++) {
                    if (a[i] == a[B - i - 1]) {
                        allDifferentPairings = false;
                        x = i;
                    } else {
                        allSamePairings = false;
                        y = i;
                    }
                }
                if (allSamePairings || allDifferentPairings) {
                    int n = query(out, 1, in);
                    if (a[0] != n) {
                        flipArray(a);
                    }
                } else {
                    int p[] = new int[4], q[] = new int[4];
                    p[0] = a[x];
                    p[1] = a[y];
                    p[2] = a[B - y - 1];
                    p[3] = a[B - x - 1];
                    q[0] = query(out, x + 1, in);
                    q[1] = query(out, y + 1, in);
                    q[2] = query(out, B - y, in);
                    q[3] = query(out, B - x, in);
                    if (compare(flip(p), q)) {
                        a = flip(a);
                    } else if (compare(reverse(p), q)) {
                        a = reverse(a);
                    } else if (compare(both(p), q)) {
                        a = both(a);
                    }
                }

                for (int i = 0; i < B; i++) {
                    System.out.print(a[i]);
                }
                System.out.println();
                char verdict = in.nextLine().charAt(0);
                if (verdict == 'N') {
                    return;
                }
            }
        }

        public int[] flip(int a[]) {
            int b[] = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                b[i] = 1 - a[i];
            }
            return b;
        }

        public int[] reverse(int a[]) {
            int N = a.length, b[] = new int[N];
            for (int i = 0; i < N; i++) {
                b[N - i - 1] = a[i];
            }
            return b;
        }

        public int[] both(int a[]) {
            int b[] = flip(a);
            b = reverse(b);
            return b;
        }

        public boolean compare(int a[], int b[]) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    return false;
                }
            }
            return true;
        }

        public void flipArray(int a[]) {
            for (int i = 1; i < a.length; i++) {
                a[i] = 1 - a[i];
            }
        }

        public int query(OutputWriter out, int position, InputReader in) {
            System.out.println(position);
            String s = in.nextLine();
            if (s.charAt(0) == 'N') {
                System.exit(0);
            }
            return s.charAt(0) - '0';
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

        public String nextLine() {
            try {
                return in.readLine();
            } catch (IOException e) {
                return null;
            }
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

        public void flush() {
            writer.flush();
        }

    }
}

