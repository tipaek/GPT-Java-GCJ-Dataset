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
                        int b = in.nextInt();
                        JavaSolution solution = new JavaSolution(in, out, b);
                        for (int i = 0; i < to; i++) {
//                        out.printf("Case #%d: ", i + 1);
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

    private JavaSolution(Scanner in, PrintWriter out, int b) {
        this.in = in;
        this.out = out;
        this.b = b;
    }

    private int b;
//    private int requested;

    private boolean checkBit(int i) {
//        requested++;
        out.println(i + 1);
        out.flush();
        return in.next().equals("0");
    }

    private void run() {
//        requested = 0;
        int b2 = b / 2;
        boolean[] prefix = new boolean[b2];
        boolean[] suffix = new boolean[b2];
        int cnt = 0;
        int eIdx = -1;
        int neIdx = -1;
        for (; cnt < 5; cnt++) {
            prefix[cnt] = checkBit(cnt);
            suffix[cnt] = checkBit(b - 1 - cnt);
            if (prefix[cnt] == suffix[cnt]) {
                eIdx = cnt;
            } else {
                neIdx = cnt;
            }
        }
        while (cnt < b2) {
            if (eIdx != -1) {
                if (checkBit(eIdx) != prefix[eIdx]) {
                    for (int i = 0; i < cnt; i++) {
                        prefix[i] = !prefix[i];
                        suffix[i] = !suffix[i];
                    }
                }
            } else {
                checkBit(0);
            }
            if (neIdx != -1) {
                if (checkBit(neIdx) != prefix[neIdx]) {
                    boolean[] tmp = prefix;
                    prefix = suffix;
                    suffix = tmp;
                }
            } else {
                checkBit(0);
            }
            for (int i = 0; i < 4 && cnt < b2; i++, cnt++) {
                prefix[cnt] = checkBit(cnt);
                suffix[cnt] = checkBit(b - 1 - cnt);
                if (prefix[cnt] == suffix[cnt]) {
                    eIdx = cnt;
                } else {
                    neIdx = cnt;
                }
            }
        }
//        System.err.println(requested);

        for (int i = 0; i < b2; i++) {
            out.print(prefix[i] ? '0' : '1');
        }
        for (int i = 0; i < b2; i++) {
            out.print(suffix[b2 - 1 - i] ? '0' : '1');
        }
        out.println();
        out.flush();
        String result = in.next();
        if (result.equals("N")) {
            throw new IllegalArgumentException();
        }
    }
}
