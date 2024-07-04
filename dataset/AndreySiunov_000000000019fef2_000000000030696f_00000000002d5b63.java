import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Arrays;
import java.util.Random;
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
                        in.nextInt();
                        in.nextInt();
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

    Random r = new Random(13);

    int nextRand(int from, int to) {
        return r.nextInt(to - from + 1) + from;
    }

    boolean found;

    int check(int x, int y) {
        out.println(x + " " + y);
        out.flush();
        String s = in.next();
        if ("CENTER".equals(s)) {
            found = true;
            return 0;
        }
        if ("HIT".equals(s)) {
            return 1;
        }
        if ("MISS".equals(s)) {
            return -1;
        }
        throw new RuntimeException();
    }

    int mn = -1000000000;
    int mx = -mn;


    private int findXleft(int x, int y) {
        int from = mn;
        int to = x;
        while (from + 1 < to) {
            int m = (from + to) / 2;
            int res = check(m, y);
            if (found) return m;
            if (res == 1) {
                to = m;
            } else {
                from = m;
            }
        }
        while (mn <= to) {
            int res = check(to, y);
            if (found) return to;
            if (res == 1) {
                to--;
            } else {
                break;
            }
        }
        return to + 1;
    }

    private int findXright(int x, int y) {
        int from = x;
        int to = mx;
        while (from + 1 < to) {
            int m = (from + to) / 2;
            int res = check(m, y);
            if (found) return m;
            if (res == 1) {
                from = m;
            } else {
                to = m;
            }
        }
        while (from <= mx) {
            int res = check(from, y);
            if (found) return from;
            if (res == 1) {
                from++;
            } else {
                break;
            }
        }
        return from - 1;
    }


    private int findYup(int x, int y) {
        int from = y;
        int to = mx;
        while (from + 1 < to) {
            int m = (from + to) / 2;
            int res = check(x, m);
            if (found) return m;
            if (res == 1) {
                from = m;
            } else {
                to = m;
            }
        }
        while (from <= mx) {
            int res = check(x, from);
            if (found) return from;
            if (res == 1) {
                from++;
            } else {
                break;
            }
        }
        return from - 1;
    }

    private int findYdown(int x, int y) {
        int from = mn;
        int to = y;
        while (from + 1 < to) {
            int m = (from + to) / 2;
            int res = check(x, m);
            if (found) return m;
            if (res == 1) {
                to = m;
            } else {
                from = m;
            }
        }
        while (mn <= to) {
            int res = check(x, to);
            if (found) return to;
            if (res == 1) {
                to--;
            } else {
                break;
            }
        }
        return to + 1;
    }

    private void find(int x, int y) {
        int fromX = findXleft(x, y);
        if (found) return;
        int toX = findXright(x, y);
        if (found) return;
        x = (fromX + toX) / 2;

        int fromY = findYup(x, y);
        if (found) return;
        int toY = findYdown(x, y);
        if (found) return;
        y = (fromY + toY) / 2;

        if (check(x, y) != 0) {
            throw new RuntimeException();
        }
    }

    private void run() {
        found = false;
        while (true) {
            int x = nextRand(mn + 1, mx - 1);
            int y = nextRand(mn + 1, mx - 1);
            int r = check(x, y);
            if (found) return;
            if (r == 1) {
                find(x, y);
            }
        }
    }
}

