import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CodeJam solver = new CodeJam();
        solver.solve(1, in, out);
        out.close();
    }

    static class CodeJam {
        public void solve(int testNumber, FastReader sc, PrintWriter out) {
            int T = sc.nextInt();
            for (int t = 1; t <= T; ++t) {
                int n = sc.nextInt();
                Task[] tasks = new Task[n];
                for (int i = 0; i < n; ++i) {
                    tasks[i] = new Task(sc.nextInt(), sc.nextInt(), i);
                }
                Arrays.sort(tasks, Comparator.comparingInt((Task task) -> task.start)
                                              .thenComparingInt(task -> task.end));

                boolean possible = true;
                char[] schedule = new char[n];
                int lastC = 0, lastJ = 0;

                for (Task task : tasks) {
                    if (lastC <= task.start) {
                        lastC = task.end;
                        schedule[task.index] = 'C';
                    } else if (lastJ <= task.start) {
                        lastJ = task.end;
                        schedule[task.index] = 'J';
                    } else {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    out.printf("Case #%d: %s%n", t, new String(schedule));
                } else {
                    out.printf("Case #%d: IMPOSSIBLE%n", t);
                }
            }
        }

        static class Task {
            int start;
            int end;
            int index;

            Task(int start, int end, int index) {
                this.start = start;
                this.end = end;
                this.index = index;
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream), 32768);
            st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}