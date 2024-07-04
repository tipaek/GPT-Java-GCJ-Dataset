import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashSet;
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
            p = Runtime.getRuntime().exec("python3 local_testing_tool.py 2");
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

    private void run() {
        out.println(_run());
    }

    private boolean equalPrefix(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        return s1.substring(0, Math.min(s1.length(), len)).equals(s2.substring(0, Math.min(s2.length(), len)));
    }

    private boolean equalSuffix(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        return s1.substring(s1.length() - len).equals(s2.substring(s2.length() - len));
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
            String[] a = s.split("[*]");
            int from = 0;
            int to = a.length - 1;
            if (s.charAt(0) != '*') {
                if (!equalPrefix(prefix, a[0])) {
                    return "*";
                }
                prefix = longest(prefix, a[from]);
                from++;
            }
            if (s.charAt(s.length() - 1) != '*') {
                if (!equalSuffix(suffix, a[a.length - 1])) {
                    return "*";
                }
                suffix = longest(suffix, a[to]);
                to--;
            }
            for (int j = from; j <= to; j++) sb.append(a[j]);
        }
        String res = prefix + sb + suffix;
        return (res.isEmpty()) ? "A" : res;
    }
}
