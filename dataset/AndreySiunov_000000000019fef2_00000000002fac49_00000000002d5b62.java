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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

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

    private String run(long x, long y) {
        int b = 33;
        boolean[] xx = new boolean[b];
        boolean[] yy = new boolean[b];
        int mx = 0;
        for (int i = 0; i < b; i++) {
            xx[i] = (x & 1) != 0;
            x >>= 1;
            yy[i] = (y & 1) != 0;
            y >>= 1;
            if (xx[i] || yy[i]) mx = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= mx; ) {
            if (xx[i] && yy[i]) {
                return null;
            }
            if (xx[i]) {
                while (i + 1 <= mx && !xx[i + 1] && !yy[i + 1]) {
                    sb.append('W');
                    i++;
                }
                sb.append('E');
                i++;
            } else {
                if (!yy[i]) {
                    return null;
                }
                while (i + 1 <= mx && !xx[i + 1] && !yy[i + 1]) {
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
        String res = run(x, y);
        if (res != null) return res;
        long t = 1;
        while (t <= x || t <= y) {
            t <<= 1;
        }
        res = run(t - x, y);
        if (res != null) {
            res = res.replace('W', 'T');
            res = res.replace('E', 'W');
            res = res.replace('T', 'E');
            res += 'E';
        } else {
            res = run(x, t - y);
            if (res != null) {
                res = res.replace('N', 'T');
                res = res.replace('S', 'N');
                res = res.replace('T', 'S');
                res += 'N';
            }
        }
        return res;
    }

    String g(String s1, String s2) {
        if (s1 == null) return s2;
        if (s2 == null) return s1;
        if (s1.length() > s2.length()) return s2;
        return s1;
    }

    String gg(String s, char ch) {
        if (s == null) return s;
        return s + ch;
    }

    String brun(long x, long y, int st) {
        if (x == 0 && y == 0) {
            return "";
        }
        if (st > 8) {
            return null;
        }
        return g(
                g(
                        gg(brun(x + (1 << st), y, st + 1), 'W'),
                        gg(brun(x - (1 << st), y, st + 1), 'E')
                ),
                g(
                        gg(brun(x, y + (1 << st), st + 1), 'N'),
                        gg(brun(x, y - (1 << st), st + 1), 'S')
                )
        );
    }

    private void run() {
        int x = in.nextInt();
        int y = in.nextInt();
//        out.println(brun(x, y, 0));
        boolean revX = x < 0;
        x = Math.abs(x);
        boolean revY = y < 0;
        y = Math.abs(y);
        String res = run2(x, y);
        if (res == null) {
            res = "IMPOSSIBLE";
        } else {
            if (revX) {
                res = res.replace('W', 'T');
                res = res.replace('E', 'W');
                res = res.replace('T', 'E');
            }
            if (revY) {
                res = res.replace('N', 'T');
                res = res.replace('S', 'N');
                res = res.replace('T', 'S');
            }
        }
        out.println(res);
    }
}

