import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        JavaSolution.main(args);
    }
}

/*
Interactive run:
============================================================================
python3 interactive_runner.py \
python3 local_testing_tool.py 1 -- \
java -Xms896m -Xmx896m -Xss64m -XX:+UseSerialGC \
-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005,quiet=y \
-classpath out/production/ScalaContest JavaSolution
============================================================================
*/
class JavaSolution {
    public static void main(String[] args) throws IOException {
        boolean isDebugMode = Arrays.asList(args).contains("DEBUG_MODE");
        boolean isInteractiveMode = Arrays.asList(args).contains("INTERACTIVE_MODE");

        Process p = null;
        if (isInteractiveMode) {
            p = Runtime.getRuntime().exec("python3 local_testing_tool.py 2");
        }
        try {
            Reader reader;
            if (isInteractiveMode) {
                reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            } else if (isDebugMode) {
                reader = new FileReader("input.txt");
            } else {
                reader = new InputStreamReader(System.in);
            }

            OutputStreamWriter writer;
            if (isInteractiveMode) {
                writer = new OutputStreamWriter(p.getOutputStream());
            } else {
                writer = new OutputStreamWriter(System.out);
//                writer = new FileWriter("output.txt");
            }

            long startTime = System.nanoTime();
            try {
                try (Scanner in = new Scanner(new BufferedReader(reader))) {
                    try (PrintWriter out = new PrintWriter(new BufferedWriter(writer))) {
                        int to = in.nextInt();
                        JavaSolution solution = new JavaSolution(in, out);
                        for (int i = 0; i < to; i++) {
                            out.printf("Case #%d: ", i + 1);
                            solution.run();
                        }
                    }
                }
            } finally {
                if (isDebugMode) {
                    long endTime = System.nanoTime();
                    System.out.printf(">> Execution time: %.6f\n", (endTime - startTime) / 1000000000.0);
                    System.out.flush();
                }
            }
        } finally {
            if (p != null) {
                p.destroy();
            }
        }
    }

    private Scanner in;
    private PrintWriter out;

    private JavaSolution(Scanner in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    static class Fenwick {
        int[] t;
        int n;

        public Fenwick(int n) {
            this.n = n;
            t = new int[n];
        }

        int sum(int r) {
            int result = 0;
            for (; r >= 0; r = (r & (r + 1)) - 1) {
                result += t[r];
            }
            return result;
        }

        void inc(int i, int delta) {
            for (; i < n; i = (i | (i + 1))) {
                t[i] += delta;
            }
        }

        int sum(int l, int r) {
            return sum(r) - sum(l - 1);
        }
    }

    private void run() {
        int r = in.nextInt();
        int s = in.nextInt();
        Fenwick f = new Fenwick(r * s);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                f.inc(i * s + j, 1);
            }
        }
        int[][] res = new int[r * s][2];
        int cres = 0;

        for (int from = 0, to = r * s - 1; ; ) {
            if (to - from + 1 == r) {
                break;
            }
            if (to - from == r) {
                res[cres][0] = f.sum(from, from);
                res[cres][1] = f.sum(from + 1, to);
                cres++;
                break;
            }
            int t1 = f.sum(from, from);
            int t2 = f.sum(from + 1, from + 1);
            res[cres][0] = t1 + t2;
            res[cres][1] = f.sum(from + 2, from + r);
            cres++;
            f.inc(from, -t1);
            f.inc(from + 1, -t2);
            f.inc(from + r, t1);
            f.inc(from + r + 1, t2);
            from += 2;
        }

        out.println(cres);
        for (int i = 0; i < cres; i++) {
            out.println(res[i][0] + " " + res[i][1]);
        }
    }
}

