import java.util.*;
import java.io.*;

public class Solution {
    public static final boolean DEBUG = false;

    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(System.out);
        FastScan sc = new FastScan();

        int t = sc.nextInt();
        int n = sc.nextInt();
        int c = sc.nextInt();
        double target = 1.0 * c / t;

        TestCase[] testCases = new TestCase[t];
        for (int i = 0; i < t; i++) {
            testCases[i] = new TestCase(n);
        }

        for (int i = 0; i < n * (n + 1) / 2; i++) {
            int[] choices = new int[t];

            for (int j = 0; j < t; j++) {
                TestCase testCase = testCases[j];
                if (testCase.probability() >= target) {
                    choices[j] = 0;
                } else {
                    choices[j] = (int) Math.ceil(Math.random() * 15);
                }
            }

            for (int choice : choices) {
                pw.printf("%d ", choice);
            }
            pw.println();
            pw.flush();

            for (int j = 0; j < t; j++) {
                int r = sc.nextInt();
                if (choices[j] > 0) {
                    if (r > 0) {
                        testCases[j].pens[choices[j] - 1].used++;
                    } else {
                        testCases[j].pens[choices[j] - 1].done = true;
                    }
                }
            }
        }

        for (int i = 0; i < t; i++) {
            pw.print("0 ");
        }
        pw.println();

        for (TestCase testCase : testCases) {
            testCase.choose(pw);
        }
        pw.println();
        pw.flush();

        pw.close();
        sc.close();
    }

    static class TestCase {
        Pen[] pens;
        boolean[] used;
        int n;

        public TestCase(int n) {
            this.n = n;
            pens = new Pen[n];
            for (int i = 0; i < n; i++) {
                pens[i] = new Pen();
            }
            used = new boolean[n];
        }

        public double probability() {
            int count = 0;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (used[i] || used[j]) {
                        continue;
                    }
                    count++;
                    for (int k = 0; k < n; k++) {
                        if (pens[k].done || pens[k].used > i) {
                            continue;
                        }
                        for (int l = k + 1; l < n; l++) {
                            if (pens[l].done || pens[l].used > j) {
                                continue;
                            }
                            if (i - pens[k].used + j - pens[l].used >= n) {
                                sum++;
                            }
                        }
                    }
                }
            }
            return 1.0 * count / sum;
        }

        public void choose(PrintWriter pw) {
            int a = -1;
            int b = -1;

            for (int i = 0; i < n; i++) {
                if ((a < 0) || (!pens[i].done && pens[i].used < pens[a].used)) {
                    b = a;
                    a = i;
                } else if ((b < 0) || (!pens[i].done && pens[i].used < pens[b].used)) {
                    b = i;
                }
            }
            pw.printf("%d %d ", a + 1, b + 1);
        }
    }

    static class Pen {
        int used;
        boolean done;

        public Pen() {
            used = 0;
            done = false;
        }
    }

    public static void debug(Object obj, String end) {
        if (DEBUG) {
            if (obj instanceof boolean[]) {
                System.out.print(Arrays.toString((boolean[]) obj));
            } else if (obj instanceof byte[]) {
                System.out.print(Arrays.toString((byte[]) obj));
            } else if (obj instanceof short[]) {
                System.out.print(Arrays.toString((short[]) obj));
            } else if (obj instanceof char[]) {
                System.out.print(Arrays.toString((char[]) obj));
            } else if (obj instanceof int[]) {
                System.out.print(Arrays.toString((int[]) obj));
            } else if (obj instanceof long[]) {
                System.out.print(Arrays.toString((long[]) obj));
            } else if (obj instanceof float[]) {
                System.out.print(Arrays.toString((float[]) obj));
            } else if (obj instanceof double[]) {
                System.out.print(Arrays.toString((double[]) obj));
            } else if (obj instanceof Object[]) {
                debug((Object[]) obj);
            } else {
                System.out.print(obj);
            }
            System.out.print(end);
        }
    }

    public static void debug(Object... args) {
        if (DEBUG) {
            System.out.print("#");
            for (Object arg : args) {
                debug(arg, " ");
            }
            System.out.println();
        }
    }

    public static void debug(Suspended sus) {
        if (DEBUG) {
            debug(sus.eval());
        }
    }

    public static void debugGrid(int[][] grid) {
        if (DEBUG) {
            for (int[] row : grid) {
                System.out.print("#");
                for (int cell : row) {
                    System.out.print(String.format("%3d ", cell));
                }
                System.out.println();
            }
        }
    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;

        public FastScan() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public String nextToken() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine(), " ");
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(nextToken());
        }

        public void close() throws IOException {
            br.close();
        }
    }
}

interface Suspended {
    Object eval();
}