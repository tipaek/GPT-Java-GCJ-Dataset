import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        JavaSolution.main(args);
    }
}

class JavaSolution {
    private Scanner in;
    private PrintWriter out;
    private Random random = new Random(13);
    private boolean found;
    private static final int MIN_COORD = -1000000000;
    private static final int MAX_COORD = 1000000000;

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
                in.nextInt(); // Skip the next two integers
                in.nextInt();

                JavaSolution solution = new JavaSolution(in, out);
                for (int i = 0; i < testCases; i++) {
                    out.printf("Case #%d: ", i + 1);
                    solution.run();
                }
            }

            if (isDebugMode) {
                long endTime = System.nanoTime();
                System.out.printf(">> Execution time: %.6f\n", (endTime - startTime) / 1e9);
                System.out.flush();
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

    private static OutputStreamWriter getWriter(boolean isInteractiveMode, Process process) throws IOException {
        if (isInteractiveMode) {
            return new OutputStreamWriter(process.getOutputStream());
        } else {
            return new OutputStreamWriter(System.out);
        }
    }

    private int nextRand(int from, int to) {
        return random.nextInt(to - from + 1) + from;
    }

    private int check(int x, int y) {
        out.println(x + " " + y);
        out.flush();
        String response = in.next();
        switch (response) {
            case "CENTER":
                found = true;
                return 0;
            case "HIT":
                return 1;
            case "MISS":
                return -1;
            default:
                throw new RuntimeException("Unexpected response: " + response);
        }
    }

    private int findBoundary(int x, int y, boolean isX, boolean isIncreasing) {
        int from = isIncreasing ? x : MIN_COORD;
        int to = isIncreasing ? MAX_COORD : x;
        while (from + 1 < to) {
            int mid = (from + to) / 2;
            int res = isX ? check(mid, y) : check(x, mid);
            if (found) return mid;
            if (res == 1) {
                if (isIncreasing) {
                    from = mid;
                } else {
                    to = mid;
                }
            } else {
                if (isIncreasing) {
                    to = mid;
                } else {
                    from = mid;
                }
            }
        }
        return isIncreasing ? from : to;
    }

    private void find(int x, int y) {
        int leftX = findBoundary(x, y, true, false);
        if (found) return;
        int rightX = findBoundary(x, y, true, true);
        if (found) return;
        x = (leftX + rightX) / 2;

        int upY = findBoundary(x, y, false, true);
        if (found) return;
        int downY = findBoundary(x, y, false, false);
        if (found) return;
        y = (downY + upY) / 2;

        if (check(x, y) != 0) {
            throw new RuntimeException("Failed to locate the center.");
        }
    }

    private void run() {
        found = false;
        while (!found) {
            int x = nextRand(MIN_COORD + 1, MAX_COORD - 1);
            int y = nextRand(MIN_COORD + 1, MAX_COORD - 1);
            if (check(x, y) == 1) {
                find(x, y);
            }
        }
    }
}