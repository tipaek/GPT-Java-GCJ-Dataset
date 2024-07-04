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
        String ans = "";

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            long X = in.nextInt(), Y = in.nextInt();
            long x = Math.abs(X), y = Math.abs(Y);
            ans = "";
            out.print("Case #" + testNumber + ": ");
            if ((x + y) % 2 == 0 || !find(x, y)) {
                out.printLine("IMPOSSIBLE");
            } else {
                char c[] = ans.toCharArray();
                for (int i = 0; i < c.length; i++) {
                    if (X < 0) {
                        if (c[i] == 'E') {
                            c[i] = 'W';
                        } else if (c[i] == 'W') {
                            c[i] = 'E';
                        }
                    }
                    if (Y < 0) {
                        if (c[i] == 'N') {
                            c[i] = 'S';
                        } else if (c[i] == 'S') {
                            c[i] = 'N';
                        }
                    }
                    out.print(c[i]);
                }
                out.printLine();
            }
        }

        public boolean find(long x, long y) {
            int N = 35;
            int a[] = new int[N], b[] = new int[N];
            fillBinary(a, x);
            fillBinary(b, y);
            for (int i = 0; i < N - 1; i++) {
                if (a[i] + b[i] == 2) {
                    if (a[i - 1] + b[i - 1] > 0 || a[i + 1] + b[i + 1] != 1) {
                        return false;
                    }
                    if (a[i + 1] == 1) {
                        a[i + 1] = -1;
                        a[i] = 0;
                        a[i - 1] = 1;
                    } else {
                        b[i + 1] = -1;
                        b[i] = 0;
                        b[i - 1] = 1;
                    }
                }
            }
            long pow = 1;
            for (int i = N - 1; i >= 0; i--) {
                if (a[i] == b[i]) {
                    if (x != 0 && y != 0) {
                        return false;
                    }
                    return true;
                }
                if (a[i] == 1) {
                    ans += "E";
                    x -= pow;
                } else if (a[i] == -1) {
                    ans += "W";
                    x += pow;
                }
                if (b[i] == 1) {
                    ans += "N";
                    y -= pow;
                } else if (b[i] == -1) {
                    ans += "S";
                    y += pow;
                }
                pow *= 2;
            }
            return true;
        }

        public void fillBinary(int a[], long x) {
            int i = a.length - 1;
            while (x > 0) {
                if (x % 2 == 1) {
                    a[i] = 1;
                }
                x /= 2;
                i--;
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

