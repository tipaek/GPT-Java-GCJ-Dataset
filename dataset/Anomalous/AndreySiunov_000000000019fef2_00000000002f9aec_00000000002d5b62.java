import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        JavaSolution.main(args);
    }
}

class JavaSolution {
    public static void main(String[] args) throws IOException {
        boolean isDebugMode = Arrays.asList(args).contains("DEBUG_MODE");
        boolean isInteractiveMode = Arrays.asList(args).contains("INTERACTIVE_MODE");

        Process process = null;
        if (isInteractiveMode) {
            process = Runtime.getRuntime().exec("python3 local_testing_tool.py 2");
        }

        try (Reader reader = getReader(isInteractiveMode, isDebugMode, process);
             PrintWriter writer = getWriter(isInteractiveMode, process)) {

            long startTime = System.nanoTime();

            try (Scanner scanner = new Scanner(new BufferedReader(reader));
                 PrintWriter out = new PrintWriter(new BufferedWriter(writer))) {

                int testCaseCount = scanner.nextInt();
                JavaSolution solution = new JavaSolution(scanner, out);

                for (int i = 0; i < testCaseCount; i++) {
                    out.printf("Case #%d: ", i + 1);
                    solution.run();
                }
            }

            if (isDebugMode) {
                long endTime = System.nanoTime();
                System.out.printf(">> Execution time: %.6f\n", (endTime - startTime) / 1_000_000_000.0);
                System.out.flush();
            }
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
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

    private static PrintWriter getWriter(boolean isInteractiveMode, Process process) throws IOException {
        if (isInteractiveMode) {
            return new PrintWriter(new OutputStreamWriter(process.getOutputStream()));
        } else {
            return new PrintWriter(new OutputStreamWriter(System.out));
        }
    }

    private final Scanner in;
    private final PrintWriter out;

    private JavaSolution(Scanner in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    private String run(long x, long y) {
        final int bitCount = 33;
        boolean[] xBits = new boolean[bitCount];
        boolean[] yBits = new boolean[bitCount];
        int maxIndex = 0;

        for (int i = 0; i < bitCount; i++) {
            xBits[i] = (x & 1) != 0;
            yBits[i] = (y & 1) != 0;
            x >>= 1;
            y >>= 1;
            if (xBits[i] || yBits[i]) maxIndex = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= maxIndex; ) {
            if (xBits[i] && yBits[i]) {
                return null;
            }
            if (xBits[i]) {
                while (i + 1 <= maxIndex && !xBits[i + 1] && !yBits[i + 1]) {
                    sb.append('W');
                    i++;
                }
                sb.append('E');
                i++;
            } else {
                if (!yBits[i]) {
                    throw new RuntimeException();
                }
                while (i + 1 <= maxIndex && !xBits[i + 1] && !yBits[i + 1]) {
                    sb.append('S');
                    i++;
                }
                sb.append('N');
                i++;
            }
        }
        return sb.toString();
    }

    private String run2(long x, long y) {
        String result = run(x, y);
        if (result != null) return result;

        long threshold = 1;
        while (threshold <= x || threshold <= y) {
            threshold <<= 1;
        }

        result = run(threshold - x, y);
        if (result != null) {
            result = result.replace('W', 'T').replace('E', 'W').replace('T', 'E') + 'E';
            return result;
        }

        result = run(x, threshold - y);
        if (result != null) {
            result = result.replace('N', 'T').replace('S', 'N').replace('T', 'S') + 'N';
        }

        return result;
    }

    private void run() {
        int x = in.nextInt();
        int y = in.nextInt();
        boolean isXNegative = x < 0;
        boolean isYNegative = y < 0;

        x = Math.abs(x);
        y = Math.abs(y);

        String result = run2(x, y);
        if (result == null) {
            result = "IMPOSSIBLE";
        } else {
            if (isXNegative) {
                result = result.replace('W', 'T').replace('E', 'W').replace('T', 'E');
            }
            if (isYNegative) {
                result = result.replace('N', 'T').replace('S', 'N').replace('T', 'S');
            }
        }
        out.println(result);
    }
}