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
             OutputStreamWriter writer = getWriter(isInteractiveMode, process)) {

            long startTime = System.nanoTime();

            try (Scanner scanner = new Scanner(new BufferedReader(reader));
                 PrintWriter printWriter = new PrintWriter(new BufferedWriter(writer))) {

                int testCases = scanner.nextInt();
                JavaSolution solution = new JavaSolution(scanner, printWriter);

                for (int i = 0; i < testCases; i++) {
                    printWriter.printf("Case #%d: ", i + 1);
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

    private static Reader getReader(boolean isInteractiveMode, boolean isDebugMode, Process process) throws IOException {
        if (isInteractiveMode) {
            return new BufferedReader(new InputStreamReader(process.getInputStream()));
        } else if (isDebugMode) {
            return new FileReader("input.txt");
        } else {
            return new InputStreamReader(System.in);
        }
    }

    private static OutputStreamWriter getWriter(boolean isInteractiveMode, Process process) throws IOException {
        if (isInteractiveMode) {
            return new OutputStreamWriter(process.getOutputStream());
        } else {
            return new OutputStreamWriter(System.out);
        }
    }

    private final Scanner in;
    private final PrintWriter out;

    private JavaSolution(Scanner in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    private String run(long x, long y) {
        final int bitLength = 33;
        boolean[] xx = new boolean[bitLength];
        boolean[] yy = new boolean[bitLength];
        int maxIndex = 0;

        for (int i = 0; i < bitLength; i++) {
            xx[i] = (x & 1) != 0;
            x >>= 1;
            yy[i] = (y & 1) != 0;
            y >>= 1;
            if (xx[i] || yy[i]) maxIndex = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= maxIndex; ) {
            if (xx[i] && yy[i]) {
                return null;
            }
            if (xx[i]) {
                while (i + 1 <= maxIndex && !xx[i + 1] && !yy[i + 1]) {
                    sb.append('W');
                    i++;
                }
                sb.append('E');
                i++;
            } else {
                if (!yy[i]) {
                    return null;
                }
                while (i + 1 <= maxIndex && !xx[i + 1] && !yy[i + 1]) {
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

        long t = 1;
        while (t <= x || t <= y) {
            t <<= 1;
        }

        result = run(t - x, y);
        if (result != null) {
            result = replaceDirections(result, 'W', 'E');
            result += 'E';
        }

        result = run(x, t - y);
        if (result != null) {
            result = replaceDirections(result, 'N', 'S');
            result += 'N';
        }

        return result;
    }

    private String replaceDirections(String result, char from, char to) {
        result = result.replace(from, 'T');
        result = result.replace(to, from);
        result = result.replace('T', to);
        return result;
    }

    private void run() {
        int x = in.nextInt();
        int y = in.nextInt();
        boolean revX = x < 0;
        x = Math.abs(x);
        boolean revY = y < 0;
        y = Math.abs(y);

        String result = run2(x, y);
        if (result == null) {
            result = "IMPOSSIBLE";
        } else {
            if (revX) {
                result = replaceDirections(result, 'W', 'E');
            }
            if (revY) {
                result = replaceDirections(result, 'N', 'S');
            }
        }
        out.println(result);
    }
}