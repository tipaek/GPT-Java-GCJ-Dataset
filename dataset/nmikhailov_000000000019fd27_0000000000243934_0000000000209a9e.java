import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Nikita Mikhailov
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        private int B;
        FastScanner in;
        PrintWriter out;

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            this.in = in;
            this.out = out;

            int T = in.readInt();
            this.B = in.readInt();

            for (int i = 0; i < T; i++) {
                this.proceed();
            }
        }

        private void proceed() {
            LinkedList<TaskD.Sequence> seqs = new LinkedList<>();

            // Up to 10 segments
            for (int i = 0; i < this.B / 10; i++) {
                seqs.add(new TaskD.Sequence(this.in, this.out, i * 5, this.B));
                seqs.getLast().print();
            }

            while (seqs.size() > 1) {
                // Refresh up to 5
                TaskD.Sequence start = seqs.pollFirst();
                start.refresh();
                for (int i = 1; i < 5 && seqs.size() > 0; i++) {
                    seqs.getFirst().refresh();
                    start = start.merge(seqs.pollFirst());
                }

                start.print();
                seqs.addFirst(start);
            }

            System.err.println("Result: ");
            seqs.getFirst().print();
            seqs.getFirst().printReal();

            System.err.println("Check: " + in.readToken());
            System.err.flush();
        }

        static class Sequence {
            FastScanner in;
            PrintWriter out;
            int total;
            int originalIndex;
            int[] fromStart;
            int[] fromEnd;

            public Sequence(FastScanner in, PrintWriter out, int total) {
                this.in = in;
                this.out = out;
                this.total = total;
            }

            public Sequence(FastScanner in, PrintWriter out, int originalIndex, int total) {
                this.in = in;
                this.out = out;
                this.originalIndex = originalIndex;
                this.total = total;
                this.init();
            }

            private void init() {
                this.fromStart = new int[5];
                this.fromEnd = new int[5];

                for (int i = 0; i < 5; i++) {
                    this.fromStart[i] = this.readSeqStart(i);
                    this.fromEnd[i] = this.readSeqEnd(i);
                }
            }

            void refresh() {
                int n = fromStart.length;
                int catSame = -1;
                int catDiff = -1;

                for (int i = 0; i < n; i++) {
                    if (fromStart[i] == fromEnd[i]) {
                        catSame = i;
                    } else {
                        catDiff = i;
                    }
                }

                boolean hasInv = false;
                boolean hasRev = false;

                // Check inversion
                if (catSame != -1) {
                    int nVal = this.readSeqStart(catSame);
                    hasInv = nVal != this.fromStart[catSame];
                } else {
                    this.readSeqStart(0);
                    System.err.println("Warning no catSame");
                    System.err.flush();
                }
                // Check reverse
                if (catDiff != -1) {
                    int nVal = this.readSeqStart(catDiff);
                    hasRev = nVal != (this.fromStart[catDiff] ^ (hasInv ? 1 : 0));
                } else {
                    this.readSeqStart(0);
                    System.err.println("Warning no catDiff");
                    System.err.flush();
                }

                if (hasInv) {
                    for (int i = 0; i < n; i++) {
                        this.fromStart[i] = 1 - this.fromStart[i];
                        this.fromEnd[i] = 1 - this.fromEnd[i];
                    }
                }

                if (hasRev) {
                    int[] tmp = this.fromStart;
                    this.fromStart = this.fromEnd;
                    this.fromEnd = tmp;
                }
            }

            int readSeqStart(int pos) {
                out.println(this.originalIndex + pos + 1);
                out.flush();
                return in.readInt();
            }

            int readSeqEnd(int pos) {
                out.println(this.total - 1 - this.originalIndex - pos + 1);
                out.flush();
                return in.readInt();
            }

            TaskD.Sequence merge(TaskD.Sequence b) {
                TaskD.Sequence n = new TaskD.Sequence(this.in, this.out, this.total);

                TaskD.Sequence a1, a2;

                if (this.originalIndex < b.originalIndex) {
                    a1 = this;
                    a2 = b;
                } else {
                    a1 = b;
                    a2 = this;
                }

                n.originalIndex = a1.originalIndex;
                n.fromStart = Arrays.copyOf(a1.fromStart, a1.fromStart.length + a2.fromStart.length);
                System.arraycopy(a2.fromStart, 0, n.fromStart, a1.fromStart.length, a2.fromStart.length);

                n.fromEnd = Arrays.copyOf(a1.fromEnd, a1.fromEnd.length + a2.fromEnd.length);
                System.arraycopy(a2.fromEnd, 0, n.fromEnd, a1.fromEnd.length, a2.fromEnd.length);

                return n;
            }

            String toStr(int[] arr) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < this.total / 2; i++) {
                    if (i < this.originalIndex) {
                        sb.append('.');
                    } else if (i < this.originalIndex + this.fromStart.length) {
                        sb.append(arr[i - this.originalIndex]);
                    } else {
                        sb.append('.');
                    }
                }
                return sb.toString();
            }

            void print() {
                System.err.println(this.toStr(this.fromStart) + Utils.reverseString(this.toStr(this.fromEnd)));
                System.err.flush();
            }

            void printReal() {
                this.out.println(this.toStr(this.fromStart) + Utils.reverseString(this.toStr(this.fromEnd)));
                this.out.flush();
            }

        }

    }

    static final class Utils {
        private Utils() {
        }

        public static String reverseString(String str) {
            return new StringBuilder(str).reverse().toString();
        }

    }

    static class FastScanner {
        private StringTokenizer st;
        private BufferedReader in;

        public FastScanner(final InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        public String readToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (final IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int readInt() {
            return Integer.parseInt(readToken());
        }

    }
}

