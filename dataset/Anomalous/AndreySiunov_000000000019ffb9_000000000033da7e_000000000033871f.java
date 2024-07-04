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
            process = Runtime.getRuntime().exec("python3 testing_tool.py 2");
        }

        try (Reader reader = getReader(isInteractiveMode, isDebugMode, process);
             OutputStreamWriter writer = getWriter(isInteractiveMode, process)) {

            long startTime = System.nanoTime();
            try (Scanner scanner = new Scanner(new BufferedReader(reader));
                 PrintWriter out = new PrintWriter(new BufferedWriter(writer))) {

                int testCases = scanner.nextInt();
                JavaSolution solution = new JavaSolution(scanner, out);

                for (int i = 0; i < testCases; i++) {
                    out.printf("Case #%d: ", i + 1);
                    solution.run();
                }
            } finally {
                if (isDebugMode) {
                    long endTime = System.nanoTime();
                    System.out.printf(">> Execution time: %.6f\n", (endTime - startTime) / 1_000_000_000.0);
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

    private static class Pii {
        int key;
        int value;

        Pii(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pii{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private void run() {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] xx = new int[n];
        Pii[] x = new Pii[n];
        xx[0] = 0;
        x[0] = new Pii(0, 0);

        for (int i = 1; i < n; i++) {
            xx[i] = -in.nextInt();
            x[i] = new Pii(xx[i], i);
        }

        List<Pii>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        int[] results = new int[m];
        for (int i = 0; i < m; i++) {
            int t1 = in.nextInt() - 1;
            int t2 = in.nextInt() - 1;
            adjacencyList[t1].add(new Pii(t2, i));
            adjacencyList[t2].add(new Pii(t1, i));
        }

        Arrays.sort(x, Comparator.comparingInt(o -> o.key));

        for (int i = 1; i < n; i++) {
            int idx = x[i].value;
            for (Pii to : adjacencyList[idx]) {
                if (xx[to.key] <= xx[idx]) {
                    results[to.value] = Math.max(1, xx[idx] - xx[to.key]);
                }
            }
        }

        for (int result : results) {
            out.print(result + " ");
        }
        out.println();
    }
}