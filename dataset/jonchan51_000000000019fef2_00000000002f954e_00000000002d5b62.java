import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static class Task {
        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            int T = sc.nextInt();
            int t = 0;
            while (T-- > 0) {
                t++;
                int x = sc.nextInt();
                int y = sc.nextInt();

                String res = "";
                // if both are odd, not possible for sure.
                if (Math.abs(x) % 2 == 1 && Math.abs(y) % 2 == 1) {
                    res = "IMPOSSIBLE";
                } else {
                    Queue<Coord> q = new LinkedList<>();
                    q.add(new Coord(0, 0, ""));
                    while (!q.isEmpty()) {
                        Coord c = q.poll();
                        if (c.x == x && c.y == y) {
                            res = c.path;
                            break;
                        }
                        int step = c.path.length();
                        if (step > 9) { // hard limit, idk how to do ts3
                            res = "IMPOSSIBLE";
                        }
                        q.add(new Coord(c.x + (int) Math.pow(2, step), c.y, c.path + "E"));
                        q.add(new Coord(c.x - (int) Math.pow(2, step), c.y, c.path + "W"));
                        q.add(new Coord(c.x, c.y + (int) Math.pow(2, step), c.path + "N"));
                        q.add(new Coord(c.x, c.y - (int) Math.pow(2, step), c.path + "S"));
                    }
                }

                pw.println("Case #" + t + ": " + res);
            }

        }

        class Coord {
            String path = "";
            int x;
            int y;

            Coord(int x, int y, String p) {
                this.x = x;
                this.y = y;
                path = p;
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