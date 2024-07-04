import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
            p = Runtime.getRuntime().exec("python3 testing_tool.py 2");
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

    static class Pii {
        int key;
        int value;

        public Pii(int key, int value) {
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
        xx[0] = 0;
        Pii[] x = new Pii[n];
        x[0] = new Pii(0, 0);
        for (int i = 1; i < n; i++) {
            xx[i] = -in.nextInt();
            x[i] = new Pii(xx[i], i);
        }
        ArrayList<Pii>[] a = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            a[i] = new ArrayList<>();
        }
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int t1 = in.nextInt() - 1;
            int t2 = in.nextInt() - 1;
            a[t1].add(new Pii(t2, i));
            a[t2].add(new Pii(t1, i));
        }

        Arrays.sort(x, new Comparator<Pii>() {
            @Override
            public int compare(Pii o1, Pii o2) {
                return o1.key - o2.key;
            }
        });
        for (int i = 1; i < n; i++) {
            int idx = x[i].value;
            for (Pii to : a[idx]) {
                if (xx[to.key] <= xx[idx]) {
                    res[to.value] = Math.max(1, xx[idx] - xx[to.key]);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            out.print(res[i] + " ");
        }
        out.println();

    }
}

