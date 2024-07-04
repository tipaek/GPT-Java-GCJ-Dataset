import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Solution implements Runnable {
    boolean multiple = true;
    long MOD;
    int caseNum = 1;

    @SuppressWarnings({"Duplicates", "ConstantConditions"})
    void solve() throws Exception {
        int n = sc.nextInt();
        char[] ans = new char[n];
        boolean cAvailable = true, jAvailable = true;
        boolean isPossible = true;
        PriorityQueue<Node> events = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            events.add(new Node(true, sc.nextInt(), i));
            events.add(new Node(false, sc.nextInt(), i));
        }

        while (!events.isEmpty()) {
            Node currentEvent = events.poll();
            if (currentEvent.start) {
                if (cAvailable) {
                    cAvailable = false;
                    ans[currentEvent.idx] = 'C';
                } else if (jAvailable) {
                    jAvailable = false;
                    ans[currentEvent.idx] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            } else {
                if (ans[currentEvent.idx] == 'C') {
                    cAvailable = true;
                } else {
                    jAvailable = true;
                }
            }
        }

        System.out.print("Case #" + caseNum + ": ");
        if (!isPossible) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(new String(ans));
        }
        caseNum++;
    }

    class Node implements Comparable<Node> {
        boolean start;
        int time;
        int idx;

        Node(boolean start, int time, int idx) {
            this.start = start;
            this.time = time;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node other) {
            if (this.time != other.time) {
                return Integer.compare(this.time, other.time);
            }
            return Boolean.compare(this.start, other.start);
        }
    }

    StringBuilder resultBuilder = new StringBuilder();

    void append(Object s) {
        resultBuilder.append(s);
    }

    void append(double s) {
        resultBuilder.append(s);
    }

    void append(long s) {
        resultBuilder.append(s);
    }

    void append(char s) {
        resultBuilder.append(s);
    }

    void appendLine(Object s) {
        resultBuilder.append(s).append('\n');
    }

    void appendLine(double s) {
        resultBuilder.append(s).append('\n');
    }

    void appendLine(long s) {
        resultBuilder.append(s).append('\n');
    }

    void appendLine(char s) {
        resultBuilder.append(s).append('\n');
    }

    void appendLine() {
        resultBuilder.append('\n');
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            sc = new FastScanner(in);
            if (multiple) {
                int q = sc.nextInt();
                for (int i = 0; i < q; i++) solve();
            } else {
                solve();
            }
            System.out.print(resultBuilder);
        } catch (Throwable uncaught) {
            Solution.uncaught = uncaught;
        } finally {
            out.close();
        }
    }

    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread(null, new Solution(), "", (1 << 26));
        thread.start();
        thread.join();
        if (Solution.uncaught != null) {
            throw Solution.uncaught;
        }
    }

    static Throwable uncaught;
    BufferedReader in;
    FastScanner sc;
    PrintWriter out;
}

class FastScanner {
    BufferedReader in;
    StringTokenizer st;

    public FastScanner(BufferedReader in) {
        this.in = in;
    }

    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}