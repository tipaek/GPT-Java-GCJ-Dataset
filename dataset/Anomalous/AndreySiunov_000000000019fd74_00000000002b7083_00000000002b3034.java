import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class JavaSolution {
    public static void main(String[] args) throws IOException {
        boolean isDebugMode = Arrays.asList(args).contains("DEBUG_MODE");
        boolean isInteractiveMode = Arrays.asList(args).contains("INTERACTIVE_MODE");

        Process process = null;
        if (isInteractiveMode) {
            process = Runtime.getRuntime().exec("python3 local_testing_tool.py 2");
        }

        try (Reader reader = getReader(isInteractiveMode, isDebugMode, process);
             Writer writer = getWriter(isInteractiveMode, process)) {

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
                System.out.printf(">> Execution time: %.6f seconds\n", (endTime - startTime) / 1_000_000_000.0);
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

    private static Writer getWriter(boolean isInteractiveMode, Process process) throws IOException {
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

    private void run() {
        out.println(solve());
    }

    private String solve() {
        int n = in.nextInt();
        String[] patterns = new String[n];
        for (int i = 0; i < n; i++) {
            patterns[i] = in.next();
        }

        String prefix = "";
        String suffix = "";
        StringBuilder middle = new StringBuilder();

        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*");
            int from = 0;
            int to = parts.length - 1;

            if (!pattern.startsWith("*")) {
                if (!prefix.startsWith(parts[0])) {
                    return "*";
                }
                prefix = getLongerString(prefix, parts[from]);
                from++;
            }

            if (!pattern.endsWith("*")) {
                if (!suffix.endsWith(parts[parts.length - 1])) {
                    return "*";
                }
                suffix = getLongerString(suffix, parts[to]);
                to--;
            }

            for (int j = from; j <= to; j++) {
                middle.append(parts[j]);
            }
        }

        return prefix + middle + suffix;
    }

    private String getLongerString(String s1, String s2) {
        return s1.length() > s2.length() ? s1 : s2;
    }
}