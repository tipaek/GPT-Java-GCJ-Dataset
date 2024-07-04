import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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
            p = Runtime.getRuntime().exec("python3 testing_tool.py 2");
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

    long find(long n) {
        long res = Math.max(0, (long) Math.sqrt(2 * n));
        while (res * (res + 1) / 2 <= n) res++;
        while (res * (res + 1) / 2 > n) res--;
        return res;
    }

    long left(long a, long b, long from, long to) {
        long d = to - from;
        long aa = d / 2 + d % 2;
        long bb = d - aa;
        return a - (from * aa + aa * aa);
    }

    long right(long a, long b, long from, long to) {
        long d = to - from;
        long aa = d / 2 + d % 2;
        long bb = d - aa;
        return b - (from * bb + bb * (bb + 1));
    }

    boolean f(long a, long b, long from, long to) {
        long d = to - from;
        long aa = d / 2 + d % 2;
        long bb = d - aa;
        return a >= from * aa + aa * aa && b >= from * bb + bb * (bb + 1);
    }

    long find2(long a, long b, long i) {
        long l = i;
        long r = Math.max(i, a) + 1;
        while (l + 1 < r) {
            long m = (l + r) / 2;
            if (f(a, b, i, m)) {
                l = m;
            } else {
                r = m;
            }
        }
        while (f(a, b, i, l)) {
            l++;
        }
        return l - 1;
    }

    private String brute(long a, long b) {
        long i = 1;
        while (true) {
            if (a >= b) {
                if (a >= i) {
                    a -= i;
                    i++;
                } else {
                    break;
                }
            } else {
                if (b >= i) {
                    b -= i;
                    i++;
                } else {
                    break;
                }
            }
        }
        return i - 1 + " " + a + " " + b;
    }

    private String _run(long a, long b) {
        boolean rev = false;
        if (a < b) {
            long t = a;
            a = b;
            b = t;
            rev = true;
        }
        long i = find(a - b);
        a -= i * (i + 1) / 2;
        if (a == b) rev = false;
        long ii = find2(a, b, i);
        long aa = left(a, b, i, ii);
        long bb = right(a, b, i, ii);
        if (rev) {
            a = bb;
            b = aa;
        } else {
            a = aa;
            b = bb;
        }
        return ii + " " + a + " " + b;
    }


    private void run() {
//        for (int i = 1; i <= 100; i++) {
//            for (int j = 1; j <= 100; j++) {
//                if (!brute(i, j).equals(_run(i, j))) {
//                    out.println(i + " " + j + " " + brute(i, j) + " " + _run(i, j));
//                    return;
//                }
//            }
//        }
        long a = in.nextLong();
        long b = in.nextLong();
        out.println(_run(a, b));
    }
}

