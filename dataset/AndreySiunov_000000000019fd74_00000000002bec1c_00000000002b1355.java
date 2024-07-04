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

    private static class A {
        int i;
        int j;
        int val;

        public A(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    private void run() {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
            }
        }
        int[][] left = new int[n][m];
        int[][] right = new int[n][m];
        int[][] up = new int[n][m];
        int[][] down = new int[n][m];
        int[][] d = new int[n][m];
        TreeSet<A> t = new TreeSet<>(new Comparator<A>() {
            @Override
            public int compare(A o1, A o2) {
                int c = Integer.compare(o1.val, o2.val);
                if (c != 0) return c;
                c = Integer.compare(o1.i, o2.i);
                if (c != 0) return c;
                return Integer.compare(o1.j, o2.j);
            }
        });
        long current = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                left[i][j] = j - 1;
                right[i][j] = j + 1;
                up[i][j] = i - 1;
                down[i][j] = i + 1;

                d[i][j] = 0;
                if (j > 0) d[i][j] += a[i][j] - a[i][j - 1];
                if (j + 1 < m) d[i][j] += a[i][j] - a[i][j + 1];
                if (i > 0) d[i][j] += a[i][j] - a[i - 1][j];
                if (i + 1 < n) d[i][j] += a[i][j] - a[i + 1][j];
                t.add(new A(i, j, d[i][j]));

                current += a[i][j];
            }
        }
        long result = 0;
        while (true) {
            result += current;
            ArrayList<A> toRemove = new ArrayList<>();
            for (A r : t) {
                if (r.val < 0) {
                    toRemove.add(r);
                } else {
                    break;
                }
            }
            if (toRemove.isEmpty()) break;
            for (A r : toRemove) {
                t.remove(r);
                int i = r.i;
                int j = r.j;
                current -= a[i][j];
                {
                    int _leftIdx = left[i][j];
                    if (_leftIdx >= 0) {
                        t.remove(new A(i, _leftIdx, d[i][_leftIdx]));
                        right[i][_leftIdx] = right[i][j];
                        d[i][_leftIdx] -= a[i][_leftIdx] - a[i][j];
                        if (right[i][_leftIdx] < m) {
                            d[i][_leftIdx] += a[i][_leftIdx] - a[i][right[i][_leftIdx]];
                        }
                        t.add(new A(i, _leftIdx, d[i][_leftIdx]));
                    }
                }
                {
                    int _rightIdx = right[i][j];
                    if (_rightIdx < m) {
                        t.remove(new A(i, _rightIdx, d[i][_rightIdx]));
                        left[i][_rightIdx] = left[i][j];
                        d[i][_rightIdx] -= a[i][_rightIdx] - a[i][j];
                        if (left[i][_rightIdx] >= 0) {
                            d[i][_rightIdx] += a[i][_rightIdx] - a[i][left[i][_rightIdx]];
                        }
                        t.add(new A(i, _rightIdx, d[i][_rightIdx]));
                    }
                }
                {
                    int _upIdx = up[i][j];
                    if (_upIdx >= 0) {
                        t.remove(new A(_upIdx, j, d[_upIdx][j]));
                        down[_upIdx][j] = down[i][j];
                        d[_upIdx][j] -= a[_upIdx][j] - a[i][j];
                        if (down[_upIdx][j] < n) {
                            d[_upIdx][j] += a[_upIdx][j] - a[down[_upIdx][j]][j];
                        }
                        t.add(new A(_upIdx, j, d[_upIdx][j]));
                    }
                }
                {
                    int _downIdx = down[i][j];
                    if (_downIdx < n) {
                        t.remove(new A(_downIdx, j, d[_downIdx][j]));
                        up[_downIdx][j] = up[i][j];
                        d[_downIdx][j] -= a[_downIdx][j] - a[i][j];
                        if (up[_downIdx][j] >= 0) {
                            d[_downIdx][j] += a[_downIdx][j] - a[up[_downIdx][j]][j];
                        }
                        t.add(new A(_downIdx, j, d[_downIdx][j]));
                    }
                }
            }
        }
        out.println(result);
    }
}
