import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        JavaSolution.main(args);
    }
}

class JavaSolution {
    private Scanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        boolean isDebugMode = Arrays.asList(args).contains("DEBUG_MODE");
        boolean isInteractiveMode = Arrays.asList(args).contains("INTERACTIVE_MODE");

        Process process = null;
        if (isInteractiveMode) {
            process = Runtime.getRuntime().exec("python3 testing_tool.py 2");
        }

        try (Reader reader = getReader(isInteractiveMode, isDebugMode, process);
             OutputStreamWriter writer = getWriter(isInteractiveMode, process)) {

            long startTime = System.nanoTime();
            try (Scanner in = new Scanner(new BufferedReader(reader));
                 PrintWriter out = new PrintWriter(new BufferedWriter(writer))) {

                int testCases = in.nextInt();
                JavaSolution solution = new JavaSolution(in, out);
                for (int i = 0; i < testCases; i++) {
                    out.printf("Case #%d: ", i + 1);
                    solution.run();
                }
            } finally {
                if (isDebugMode) {
                    long endTime = System.nanoTime();
                    System.out.printf(">> Execution time: %.6f\n", (endTime - startTime) / 1_000_000_000.0);
                    System.out.flush();
                }
            }
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }

    private JavaSolution(Scanner in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    private static Reader getReader(boolean isInteractiveMode, boolean isDebugMode, Process process) throws IOException {
        if (isInteractiveMode) {
            return new BufferedReader(new InputStreamReader(process.getInputStream()));
        } else if (isDebugMode) {
            return new FileReader("input.txt");
        } else {
            return new InputStreamReader(System.in);
        }
    }

    private static OutputStreamWriter getWriter(boolean isInteractiveMode, Process process) {
        if (isInteractiveMode) {
            return new OutputStreamWriter(process.getOutputStream());
        } else {
            return new OutputStreamWriter(System.out);
        }
    }

    private long find(long n) {
        long res = Math.max(0, (long) Math.sqrt(n));
        while (res * res <= n) res++;
        while (res * res > n) res--;
        return res;
    }

    private long left(long a, long b, long from, long to) {
        long d = to - from;
        long aa = d / 2 + d % 2;
        return a - (from * aa + aa * aa);
    }

    private long right(long a, long b, long from, long to) {
        long d = to - from;
        long bb = d - (d / 2 + d % 2);
        return b - (from * bb + bb * (bb + 1));
    }

    private boolean f(long a, long b, long from, long to) {
        long d = to - from;
        long aa = d / 2 + d % 2;
        long bb = d - aa;
        return a >= from * aa + aa * aa && b >= from * bb + bb * (bb + 1);
    }

    private long find2(long a, long b, long i) {
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

    private void run() {
        long a = in.nextLong();
        long b = in.nextLong();
        boolean rev = false;
        if (a < b) {
            long temp = a;
            a = b;
            b = temp;
            rev = true;
        }
        long i = find(a - b);
        a -= i * i;
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
        out.println(ii + " " + a + " " + b);
    }
}