import java.io.*;
import java.util.*;

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

            try (Scanner in = new Scanner(new BufferedReader(reader));
                 PrintWriter out = new PrintWriter(new BufferedWriter(writer))) {

                int testCases = in.nextInt();
                JavaSolution solution = new JavaSolution(in, out);

                for (int i = 0; i < testCases; i++) {
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

    private static OutputStreamWriter getWriter(boolean isInteractiveMode, Process process) {
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

    static class Fenwick {
        private final int[] tree;
        private final int size;

        public Fenwick(int size) {
            this.size = size;
            this.tree = new int[size];
        }

        public int sum(int index) {
            int result = 0;
            while (index >= 0) {
                result += tree[index];
                index = (index & (index + 1)) - 1;
            }
            return result;
        }

        public void increment(int index, int delta) {
            while (index < size) {
                tree[index] += delta;
                index = index | (index + 1);
            }
        }

        public int sum(int left, int right) {
            return sum(right) - sum(left - 1);
        }
    }

    private void run() {
        int rows = in.nextInt();
        int columns = in.nextInt();
        Fenwick fenwickTree = new Fenwick(rows * columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                fenwickTree.increment(i * columns + j, 1);
            }
        }

        int[][] results = new int[rows * columns][2];
        int resultCount = 0;

        for (int from = 0, to = rows * columns - 1; ; ) {
            if (to - from + 1 == rows) {
                break;
            }
            if (to - from == rows) {
                results[resultCount][0] = fenwickTree.sum(from, from);
                results[resultCount][1] = fenwickTree.sum(from + 1, to);
                resultCount++;
                break;
            }

            int sum1 = fenwickTree.sum(from, from);
            int sum2 = fenwickTree.sum(from + 1, from + 1);
            results[resultCount][0] = sum1 + sum2;
            results[resultCount][1] = fenwickTree.sum(from + 2, from + rows);
            resultCount++;

            fenwickTree.increment(from, -sum1);
            fenwickTree.increment(from + 1, -sum2);
            fenwickTree.increment(from + rows, sum1);
            fenwickTree.increment(from + rows + 1, sum2);

            from += 2;
        }

        out.println(resultCount);
        for (int i = 0; i < resultCount; i++) {
            out.println(results[i][0] + " " + results[i][1]);
        }
    }
}