import java.util.*;
import java.io.*;
import java.awt.Point;

class SolutionGCJ {
    private static final int MAXL = 30;

    public void solve(FastReader in, PrintWriter out) {
        int testCases = in.nextInt();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int N = in.nextInt();
            int current = 0;
            List<Integer> rows = new ArrayList<>();

            for (int log = MAXL; log >= 0; log--) {
                int x = (1 << log);
                if (current + x + log <= N) {
                    rows.add(log);
                    current += x;
                } else if (!rows.isEmpty()) {
                    current += 1;
                }
            }

            Point p = new Point(0, 0);
            List<Point> output = new ArrayList<>();
            int total = 0;

            for (int i = rows.size() - 1; i >= 0; i--) {
                int row = rows.get(i);
                while (p.x < row) {
                    output.add(new Point(p));
                    total++;
                    p.x++;
                    if (p.y != 0) p.y++;
                }

                if (p.y == 0) {
                    while (p.y <= p.x) {
                        output.add(new Point(p));
                        p.y++;
                    }
                    p.y--;
                    total += (1 << row);
                    p.y++;
                    p.x++;
                } else {
                    while (p.y >= 0) {
                        output.add(new Point(p));
                        p.y--;
                    }
                    p.y++;
                    total += (1 << row);
                    p.x++;
                }
            }

            while (total < N) {
                output.add(new Point(p));
                total++;
                p.x++;
                if (p.y != 0) p.y++;
            }

            out.println("Case #" + (testCase + 1) + ":");
            for (Point q : output) {
                out.println((q.x + 1) + " " + (q.y + 1));
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        new SolutionGCJ().solve(in, out);
        out.flush();
        out.close();
    }
}

class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
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

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return str;
    }
}