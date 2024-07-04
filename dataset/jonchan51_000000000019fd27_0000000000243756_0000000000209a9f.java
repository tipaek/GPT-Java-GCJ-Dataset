import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static class Task {
        public class Interval {
            public int bracketsLeft;
            public String s;
            public int left; // inclusive
            public int right;
            public boolean absorbed = false;

            public Interval(char c, int index) {
                s = "" + c;
                bracketsLeft = Character.getNumericValue(c);
                left = index;
                right = index;
            }
        }

        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            int T = sc.nextInt();
            int t = 0;
            while (T-- > 0) {
                t++;
                // Each number is initially by itself
                // During each iteration, each largest number will look left and right,
                // and join with them if the number of brackets left is the same
                // repeat until no more
                String s = sc.next();
                PriorityQueue<Interval> intervals = new PriorityQueue<>(s.length(),
                        (a, b) -> b.bracketsLeft - a.bracketsLeft);
                Interval[] edges = new Interval[s.length()];
                for (int i = 0; i < s.length(); i++) {
                    Interval in = new Interval(s.charAt(i), i);
                    edges[i] = in;
                    intervals.add(in);
                }
                while (!intervals.isEmpty()) {
                    Interval i = intervals.poll();
                    if (i.absorbed) {
                        continue;
                    }
                    int brackets = i.bracketsLeft;
                    while (i.left > 0) {
                        Interval leftIn = edges[i.left - 1];
                        if (leftIn.absorbed || leftIn.bracketsLeft != brackets) {
                            break;
                        }
                        // merge
                        i.s = leftIn.s + i.s;
                        i.left = leftIn.left;
                        leftIn.absorbed = true;
                        edges[i.left] = i;
                    }
                    while (i.right < s.length() - 1) {
                        Interval rightIn = edges[i.right + 1];
                        if (rightIn.absorbed || rightIn.bracketsLeft != brackets) {
                            break;
                        }
                        // merge
                        i.s = i.s + rightIn.s;
                        i.right = rightIn.right;
                        rightIn.absorbed = true;
                        edges[i.right] = i;
                    }

                    if (i.bracketsLeft != 0) {
                        i.s = "(" + i.s + ")";
                        i.bracketsLeft--;
                    }
                    if (i.bracketsLeft > 0) {
                        intervals.add(i);
                    }
                }

                pw.println("Case #" + t + ": " + edges[0].s);
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