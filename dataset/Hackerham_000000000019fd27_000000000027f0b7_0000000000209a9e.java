import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Task solver = new Task();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, Scanner in, OutputWriter out) {
            int B = in.nextInt();

            int[] a = new int[B];
            int L = 0, R = B - 1;

            int num = 0;
            int eq = -1, diff = -1;
            while (L < R) {
                if (num % 10 == 9) {
                    num++;
                    out.printLine(0);
                    in.nextInt();
                }
                if (num != 0 && num % 10 == 0) {
                    if (eq >= 0) {
                        num++;
                        out.printLine(eq + 1);
                        int x = in.nextInt();
                        if (x != a[eq]) {
                            for (int i = 0; i < B; i++) {
                                a[i] = 1 - a[i];
                            }
                        }
                    }
                    if (diff >= 0) {
                        num++;
                        out.printLine(diff + 1);
                        int x = in.nextInt();
                        if (x != a[diff]) {
                            for (int i = 0; i < B - i - 1; i++) {
                                int t = a[i];
                                a[i] = a[B - i - 1];
                                a[B - i - 1] = t;
                            }
                        }
                    }
                }
                num++;
                out.printLine(L);
                a[L++] = in.nextInt();
                if (L < R) {
                    num++;
                    out.printLine(R);
                    a[R--] = in.nextInt();
                }
            }

            String s = "";
            for (int i = 0; i < B; i++) {
                s += a[i] + "";
            }
            out.printLine(s);
        }

    }

    static class OutputWriter {
        public final Writer out;

        public OutputWriter(OutputStream outputStream) {
            this.out = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        }

        public OutputWriter(Writer writer) {
            this.out = writer;
        }

        public void print(Object... objects) {
            try {
                for (int i = 0; i < objects.length; ++i) {
                    if (i != 0) {
                        this.out.write(32);
                    }

                    this.out.write(objects[i].toString());
                }

            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        }

        public void printLine(Object... objects) {
            this.print(objects);

            try {
                this.out.write(10);
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        }

        public void close() {
            try {
                this.out.close();
            } catch (IOException var2) {
                throw new RuntimeException(var2);
            }
        }

    }
}

