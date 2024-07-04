import java.io.*;
import java.util.Arrays;
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

        Process process = null;
        if (isInteractiveMode) {
            process = Runtime.getRuntime().exec("python3 local_testing_tool.py 2");
        }
        
        try (Reader reader = getReader(isInteractiveMode, isDebugMode, process);
             OutputStreamWriter writer = getWriter(isInteractiveMode, process)) {
            
            long startTime = System.nanoTime();
            
            try (Scanner in = new Scanner(new BufferedReader(reader));
                 PrintWriter out = new PrintWriter(new BufferedWriter(writer))) {
                
                int testCaseCount = in.nextInt();
                JavaSolution solution = new JavaSolution(in, out);
                
                for (int i = 0; i < testCaseCount; i++) {
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

    private void run() {
        out.println(_run());
    }

    private boolean equalPrefix(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        return s1.startsWith(s2.substring(0, len));
    }

    private boolean equalSuffix(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        return s1.endsWith(s2.substring(s2.length() - len));
    }

    private String longest(String s1, String s2) {
        return (s1.length() > s2.length()) ? s1 : s2;
    }

    private String _run() {
        int n = in.nextInt();
        String prefix = "";
        String suffix = "";
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            String s = in.next();
            String[] parts = s.split("[*]");
            int from = 0;
            int to = parts.length - 1;
            
            if (s.charAt(0) != '*') {
                if (!equalPrefix(prefix, parts[0])) {
                    return "*";
                }
                prefix = longest(prefix, parts[from]);
                from++;
            }
            if (s.charAt(s.length() - 1) != '*') {
                if (!equalSuffix(suffix, parts[parts.length - 1])) {
                    return "*";
                }
                suffix = longest(suffix, parts[to]);
                to--;
            }
            for (int j = from; j <= to; j++) {
                sb.append(parts[j]);
            }
        }
        
        return prefix + sb + suffix;
    }
}