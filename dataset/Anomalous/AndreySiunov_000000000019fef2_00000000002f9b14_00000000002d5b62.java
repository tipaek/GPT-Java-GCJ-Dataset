import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class JavaSolution {
    private Scanner in;
    private PrintWriter out;

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
            try (Scanner in = new Scanner(new BufferedReader(reader));
                 PrintWriter out = new PrintWriter(new BufferedWriter(writer))) {

                int testCases = in.nextInt();
                JavaSolution solution = new JavaSolution(in, out);

                for (int i = 0; i < testCases; i++) {
                    out.printf("Case #%d: ", i + 1);
                    solution.run();
                }

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

    private static OutputStreamWriter getWriter(boolean isInteractiveMode, Process process) {
        if (isInteractiveMode) {
            return new OutputStreamWriter(process.getOutputStream());
        } else {
            return new OutputStreamWriter(System.out);
        }
    }

    private JavaSolution(Scanner in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    private String run(long x, long y) {
        int bits = 33;
        boolean[] xx = new boolean[bits];
        boolean[] yy = new boolean[bits];
        int maxBit = 0;

        for (int i = 0; i < bits; i++) {
            xx[i] = (x & 1) != 0;
            x >>= 1;
            yy[i] = (y & 1) != 0;
            y >>= 1;
            if (xx[i] || yy[i]) maxBit = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= maxBit; ) {
            if (xx[i] && yy[i]) {
                return null;
            }
            if (xx[i]) {
                while (i + 1 <= maxBit && !xx[i + 1] && !yy[i + 1]) {
                    sb.append('W');
                    i++;
                }
                sb.append('E');
                i++;
            } else {
                if (!yy[i]) {
                    throw new RuntimeException();
                }
                while (i + 1 <= maxBit && !xx[i + 1] && !yy[i + 1]) {
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
            result = result.replace('W', 'T').replace('E', 'W').replace('T', 'E') + 'E';
        } else {
            result = run(x, t - y);
            if (result != null) {
                result = result.replace('N', 'T').replace('S', 'N').replace('T', 'S') + 'N';
            }
        }

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
                result = result.replace('W', 'T').replace('E', 'W').replace('T', 'E');
            }
            if (revY) {
                result = result.replace('N', 'T').replace('S', 'N').replace('T', 'S');
            }
        }
        out.println(result);
    }
}