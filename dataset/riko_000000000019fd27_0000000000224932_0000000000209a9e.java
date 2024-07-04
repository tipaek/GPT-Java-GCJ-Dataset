import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Eric
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task2020QD solver = new Task2020QD();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task2020QD {
        static PrintStream errorStream;
        FastReader in;
        MyWriter out;
        int MODE_NORM = 0;
        int MODE_REV = 1;
        int MODE_COMP = 2;
        int MODE_REV_COMP = 3;

        public void solve(int testNumber, FastReader in, PrintWriter out0) {
            try {
                //d("Hello");
                this.in = in;
                out = new MyWriter(out0);
                //d("Waiting for t");
                int t = in.nextInt();
                //d("t = " + t);
                //d("Waiting for b");
                int b = in.nextInt();
                //d("b = " + b);
                for (int tt = 0; tt < t; tt++) {
                    solveMe(in, out, b);
                }
                //d("Done");
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException("RTE");
            }
        }

        private void solveMe(FastReader in, MyWriter out, int b) {
            d("Solve");
            char[] res = new char[b];
            int index = 0;
            int q = 1;
            int index0 = -1;
            int index1 = -1;

            while (index <= (b - 1) / 2) {
                //d("q = " + q);
                if (q % 10 == 1) {
                    int mode = MODE_NORM;
                    int res1 = -1;
                    int res2 = -1;
                    if (index0 >= 0) {
                        out.printlnFlush((index0 + 1));
                        char tmp = (char) (in.nextInt() + '0');
                        q++;
                        res1 = tmp == res[index0] ? 0 : 1;
                    }
                    if (index1 >= 0) {
                        out.printlnFlush((index1 + 1));
                        char tmp = (char) ('0' + in.nextInt());
                        q++;
                        res2 = tmp == res[index1] ? 0 : 1;
                    }

                    // on considere un bit dont son relatif est egal: s'il a change, c'est que l'on a pris le compl ou compl+rev
                    //       - on considere un autre type de bit: s'il a change, c-est que l'on a pris le reversal ou compl
                    if (res1 == -1 && res2 == -1) {
                        mode = MODE_NORM;
                    } else if (res1 == -1) {
                        mode = res2 == 1 ? MODE_COMP : MODE_NORM;
                    } else if (res2 == -1) {
                        mode = res1 == 1 ? MODE_COMP : MODE_NORM;
                    } else {
                        if (res1 == 1 && res2 == 1) {
                            mode = MODE_COMP;
                        } else if (res1 == 1 && res2 == 0) {
                            mode = MODE_REV_COMP;
                        } else if (res1 == 0 && res2 == 0) {
                            mode = MODE_NORM;
                        } else if (res1 == 0 && res2 == 1) {
                            mode = MODE_REV;
                        }
                    }

                    res = apply(res, mode, index);
                }
                if (q % 10 == 0) {
                    out.printlnFlush((index + 1));
                    int tmp = in.nextInt();
                    q++;
                } else {
                    out.printlnFlush((index + 1));
                    int tmp = in.nextInt();
                    q++;
                    res[index] = (char) ('0' + tmp);

                    int revert = b - 1 - index;
                    out.printlnFlush((revert + 1));
                    int tmp2 = in.nextInt();
                    q++;
                    res[revert] = (char) ('0' + tmp2);

                    if (index0 == -1 && res[index] == res[revert]) {
                        index0 = index;
                    }
                    if (index1 == -1 && res[index] != res[revert]) {
                        index1 = index;
                    }
                    //d(s("index0", index0, "index1", index1));
                    index++;
                }
            }
            out.printlnFlush(new String(res));
            //d("Read Y");
            assertTrue(in.next().equals("Y"));
        }

        private char[] apply(char[] res, int mode, int index) {
            //d(s("index", index, "mode", mode));
            //d("Befor apply: " + stringMe(res));
            char[] res2 = new char[res.length];
            if (mode == MODE_NORM)
                return res;
            if (mode == MODE_REV_COMP || mode == MODE_REV) {
                for (int i = 0; i < res.length; i++) {
                    if (res[i] == '0' || res[i] == '1')
                        res2[res.length - 1 - i] = res[i];
                }
                res = arraysCopyOf(res2);
            }
            if (mode == MODE_REV_COMP || mode == MODE_COMP) {
                for (int i = 0; i < res.length; i++) {
                    if (res[i] == '0') {
                        res2[i] = '1';
                    } else if (res[i] == '1') {
                        res2[i] = '0';
                    }
                }
            }
            //d("After apply : " + stringMe(res2));
            return res2;
        }

        public static char[] arraysCopyOf(char[] a) {
            return Arrays.copyOf(a, a.length);
        }

        public static void d(String message) {
            if (errorStream == null)
                errorStream = System.err;
            errorStream.println(message);
            errorStream.flush();
        }

        public static void assertTrue(boolean shouldBeTrue) {
            assertTrue(shouldBeTrue, "");
        }

        public static void assertTrue(boolean shouldBeTrue, String message) {
            if (!shouldBeTrue)
                throw new RuntimeException(message);
        }

    }

    static class MyWriter extends PrintWriter {
        boolean isFlushing = false;
        private final Object lock;

        public MyWriter(Writer out) {
            super(out);
            this.lock = this;
        }

        public MyWriter(OutputStream out) {
            super(out);
            this.lock = this;
        }

        public void close() {
            super.close();
        }

        public void print(int x) {
            if (!isFlushing)
                System.err.println("Use printFlush() or printlnFlush() instead!");
            super.print(x);
        }

        public void println(int x) {
            super.println(x);
        }

        public void print(long x) {
            if (!isFlushing)
                System.err.println("Use printFlush instead!");
            super.print(x);
        }

        public void println(long x) {
            if (!isFlushing)
                System.err.println("Use printlnFlush instead!");
            super.println(x);
        }

        public void print(String x) {
            if (!isFlushing)
                System.err.println("Use printFlush instead!");
            super.print(x);
        }

        public void println(String x) {
            if (!isFlushing)
                System.err.println("Use printlnFlush instead!");
            super.println(x);
        }

        public void printlnFlush(Object s) {
            synchronized (lock) {
                isFlushing = true;
                super.println(s);
                flush();
                isFlushing = false;
            }
        }

    }

    static class FastReader {
        public BufferedReader br;
        public StringTokenizer st;
        String context = null;

        public FastReader(InputStream in) {
            this(new InputStreamReader(in));
        }

        public FastReader(InputStreamReader input) {
            br = new BufferedReader(input);
        }

        public String next() {
            if (context != null) {
                System.err.print("[" + context + "] Wait for input ...");
            }
            while (st == null || !st.hasMoreElements()) {
                try {
                    String s = br.readLine();
                    if (s == null)
                        return null;
                    st = new StringTokenizer(s);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Could not read");
                }
            }
            String res = st.nextToken();
            if (context != null) {
                System.err.println("[" + context + "] ... received : " + res);
            }
            return res;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

