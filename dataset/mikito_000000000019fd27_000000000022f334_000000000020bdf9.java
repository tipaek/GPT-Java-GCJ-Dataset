import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.io.UncheckedIOException;
import java.util.Objects;
import java.nio.charset.Charset;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.util.Comparator;
import java.io.InputStream;
import java.util.function.IntFunction;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author mikit
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        LightScanner in = new LightScanner(inputStream);
        LightWriter out = new LightWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        solver.solve(1, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        private static final int INF = 200000;
        private static Comparator<ParentingPartneringReturns.Task> START_INC = Comparator.comparing(task -> task.s);
        private static Comparator<ParentingPartneringReturns.Task> END_INC = Comparator.comparing(task -> task.e);

        public void solve(int testNumber, LightScanner in, LightWriter out) {
            out.setCaseLabel(LightWriter.CaseLabel.GCJ);
            int testCases = in.ints();
            loop:
            for (int testCase = 1; testCase <= testCases; testCase++) {
                out.cases(testCase);
                int n = in.ints();
                ParentingPartneringReturns.Task[] ans = new ParentingPartneringReturns.Task[n];
                for (int i = 0; i < n; i++) ans[i] = new ParentingPartneringReturns.Task(in.ints(), in.ints());
                ParentingPartneringReturns.Task[] tasks = ans.clone();
                IntroSort.sort(tasks, END_INC.thenComparing(START_INC));

                int[] dp = new int[n];
                Arrays.fill(dp, INF);
                dp[0] = 0;
                tasks[0].ans = 'C';

                for (int i = 1; i < n; i++) {
                    if (tasks[i - 1].e <= tasks[i].s) dp[i] = Math.min(dp[i], dp[i - 1]);
                    if (dp[i - 1] <= tasks[i].s) dp[i] = Math.min(dp[i], tasks[i - 1].e);
                    if (dp[i] == INF) {
                        out.ans("IMPOSSIBLE").ln();
                        continue loop;
                    }
                }

                for (int i = 1; i < n; i++) {
                    if (dp[i] == dp[i - 1]) tasks[i].ans = tasks[i - 1].ans;
                    else tasks[i].ans = not(tasks[i - 1].ans);
                }
                for (int i = 0; i < n; i++) out.print(ans[i].ans);
                out.ln();
            }
        }

        private static char not(char c) {
            return c == 'C' ? 'J' : 'C';
        }

        private static class Task {
            int s;
            int e;
            char ans;

            Task(int s, int e) {
                this.s = s;
                this.e = e;
            }

        }

    }

    static class LightScanner {
        private BufferedReader reader = null;
        private StringTokenizer tokenizer = null;

        public LightScanner(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public String string() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int ints() {
            return Integer.parseInt(string());
        }

    }

    static class LightWriter implements AutoCloseable {
        private final Writer out;
        private boolean autoflush = false;
        private boolean breaked = true;
        private LightWriter.CaseLabel caseLabel = LightWriter.CaseLabel.NONE;

        public LightWriter(Writer out) {
            this.out = out;
        }

        public LightWriter(OutputStream out) {
            this(new OutputStreamWriter(new BufferedOutputStream(out), Charset.defaultCharset()));
        }

        public void setCaseLabel(LightWriter.CaseLabel label) {
            this.caseLabel = Objects.requireNonNull(label);
        }

        public LightWriter print(char c) {
            try {
                out.write(c);
                breaked = false;
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
            return this;
        }

        public LightWriter print(String s) {
            try {
                out.write(s, 0, s.length());
                breaked = false;
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
            return this;
        }

        public LightWriter cases(int x) {
            if (!breaked) ln();
            print(caseLabel.format.apply(x));
            breaked = true;
            return this;
        }

        public LightWriter ans(String s) {
            if (!breaked) {
                print(' ');
            }
            return print(s);
        }

        public LightWriter ln() {
            print(System.lineSeparator());
            breaked = true;
            if (autoflush) {
                try {
                    out.flush();
                } catch (IOException ex) {
                    throw new UncheckedIOException(ex);
                }
            }
            return this;
        }

        public void close() {
            try {
                out.close();
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
        }

        public enum CaseLabel {
            NONE(x -> ""),
            GCJ(x -> "Case #" + x + ": "),
            ;
            private final IntFunction<String> format;

            CaseLabel(IntFunction<String> format) {
                this.format = format;
            }

        }

    }

    static class HeapSort {
        private HeapSort() {
        }

        private static <T> void heapfy(T[] a, int low, int high, int i, T val, Comparator<? super T> comparator) {
            int child = 2 * i - low + 1;
            while (child < high) {
                if (child + 1 < high && comparator.compare(a[child], a[child + 1]) < 0) {
                    child++;
                }
                if (comparator.compare(val, a[child]) >= 0) {
                    break;
                }
                a[i] = a[child];
                i = child;
                child = 2 * i - low + 1;
            }
            a[i] = val;
        }

        static <T> void sort(T[] a, int low, int high, Comparator<T> comparator) {
            for (int p = (high + low) / 2 - 1; p >= low; p--) {
                heapfy(a, low, high, p, a[p], comparator);
            }
            while (high > low) {
                high--;
                T pval = a[high];
                a[high] = a[low];
                heapfy(a, low, high, low, pval, comparator);
            }
        }

    }

    static final class BitMath {
        private BitMath() {
        }

        public static int count(int v) {
            return Integer.bitCount(v);
        }

        public static int msb(int v) {
            if (v == 0) {
                throw new IllegalArgumentException("Bit not found");
            }
            v |= (v >> 1);
            v |= (v >> 2);
            v |= (v >> 4);
            v |= (v >> 8);
            v |= (v >> 16);
            return count(v) - 1;
        }

    }

    static final class ArrayUtil {
        private ArrayUtil() {
        }

        public static <T> void swap(T[] a, int x, int y) {
            T t = a[x];
            a[x] = a[y];
            a[y] = t;
        }

    }

    static class QuickSort {
        private QuickSort() {
        }

        private static <T> void med(T[] a, int low, int x, int y, int z, Comparator<? super T> comparator) {
            if (comparator.compare(a[z], a[x]) < 0) {
                ArrayUtil.swap(a, low, x);
            } else if (comparator.compare(a[y], a[z]) < 0) {
                ArrayUtil.swap(a, low, y);
            } else {
                ArrayUtil.swap(a, low, z);
            }
        }

        static <T> int step(T[] a, int low, int high, Comparator<? super T> comparator) {
            int x = low + 1, y = low + (high - low) / 2, z = high - 1;
            if (comparator.compare(a[x], a[y]) < 0) {
                med(a, low, x, y, z, comparator);
            } else {
                med(a, low, y, x, z, comparator);
            }

            int lb = low + 1, ub = high;
            while (true) {
                while (comparator.compare(a[lb], a[low]) < 0) {
                    lb++;
                }
                ub--;
                while (comparator.compare(a[low], a[ub]) < 0) {
                    ub--;
                }
                if (lb >= ub) {
                    return lb;
                }
                ArrayUtil.swap(a, lb, ub);
                lb++;
            }
        }

    }

    static interface Verified {
    }

    static class InsertionSort {
        private InsertionSort() {
        }

        static <T> void sort(T[] a, int low, int high, Comparator<? super T> comparator) {
            for (int i = low; i < high; i++) {
                for (int j = i; j > low && comparator.compare(a[j - 1], a[j]) > 0; j--) {
                    ArrayUtil.swap(a, j - 1, j);
                }
            }
        }

    }

    static class IntroSort {
        private static int INSERTIONSORT_THRESHOLD = 16;

        private IntroSort() {
        }

        static <T> void sort(T[] a, int low, int high, int maxDepth, Comparator<T> comparator) {
            while (high - low > INSERTIONSORT_THRESHOLD) {
                if (maxDepth-- == 0) {
                    HeapSort.sort(a, low, high, comparator);
                    return;
                }
                int cut = QuickSort.step(a, low, high, comparator);
                sort(a, cut, high, maxDepth, comparator);
                high = cut;
            }
            InsertionSort.sort(a, low, high, comparator);
        }

        public static <T> void sort(T[] a, Comparator<T> comparator) {
            if (a.length <= INSERTIONSORT_THRESHOLD) {
                InsertionSort.sort(a, 0, a.length, comparator);
            } else {
                sort(a, 0, a.length, 2 * BitMath.msb(a.length), comparator);
            }
        }

    }
}

