import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static class Task {
        List<Set<Integer>> rows;
        List<Set<Integer>> cols;

        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            int T = sc.nextInt();
            int t = 0;
            while (T-- > 0) {
                t++;
                int n = sc.nextInt();
                rows = new ArrayList<>();
                cols = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    rows.add(new HashSet<>());
                    cols.add(new HashSet<>());
                }
                int trace = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int cur = sc.nextInt();
                        if (i == j) {
                            trace += cur;
                        }
                        rows.get(i).add(cur);
                        cols.get(j).add(cur);
                    }
                }
                int countRow = 0;
                for (Set r : rows) {
                    if (r.size() < n) {
                        countRow++;
                    }
                }
                int countCol = 0;
                for (Set c : cols) {
                    if (c.size() < n) {
                        countCol++;
                    }
                }

                pw.println("Case #" + t + ": " + trace + " " + countRow + " " + countCol);
            }

        }
    }

    static long TIME_START, TIME_END;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // Scanner sc = new Scanner(new FileInputStream("nondec.in"));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        // PrintWriter pw = new PrintWriter(new FileOutputStream("nondec.out"));

        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        TIME_START = System.currentTimeMillis();
        Task t = new Task();
        t.solve(sc, pw);
        TIME_END = System.currentTimeMillis();
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        pw.close();
        System.err.println("Memory increased: " + (usedMemoryAfter - usedMemoryBefore) / 1000000);
        System.err.println("Time used: " + (TIME_END - TIME_START) + ".");
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader s) throws FileNotFoundException {
            br = new BufferedReader(s);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}