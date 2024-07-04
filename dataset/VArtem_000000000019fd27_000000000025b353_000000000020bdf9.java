import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            out.printf("Case #%d: ", testNumber);
            int n = in.nextInt();
            Segment[] s = new Segment[n + 1];
            for (int i = 0; i < n; i++) {
                s[i] = new Segment(in.nextInt(), in.nextInt(), i);
            }
            s[n] = new Segment(-1, -1, n);

            Arrays.sort(s);
            boolean[][] can = new boolean[n + 1][n + 1];
            int[][] prev = new int[n + 1][n + 1];
            can[0][0] = true;
            for (int max = 0; max < n; max++) {
                Segment put = s[max + 1];
                for (int i = 0; i <= max; i++) {
                    if (can[max][i] && put.left >= s[max].right) {
                        can[max + 1][i] = true;
                        prev[max + 1][i] = max;
                    }
                    if (can[max][i] && put.left >= s[i].right) {
                        can[max][max + 1] = true;
                        prev[max][max + 1] = i;
                    }
                }
                for (int j = 0; j <= max; j++) {
                    if (can[j][max] && put.left >= s[max].right) {
                        can[j][max + 1] = true;
                        prev[j][max + 1] = max;
                    }
                    if (can[j][max] && put.left >= s[j].right) {
                        can[max + 1][max] = true;
                        prev[max + 1][max] = j;
                    }
                }
            }
            int curI = -1, curJ = -1;
            for (int i = 0; i <= n; i++) {
                if (can[i][n]) {
                    curI = i;
                    curJ = n;
                }
                if (can[n][i]) {
                    curI = n;
                    curJ = i;
                }
            }
            if (curI == -1) {
                out.println("IMPOSSIBLE");
            } else {
                char[] result = new char[n];
                while (curI + curJ > 0) {
                    if (curI > curJ) {
                        result[s[curI].id] = 'J';
                        curI = prev[curI][curJ];
                    } else {
                        result[s[curJ].id] = 'C';
                        curJ = prev[curI][curJ];
                    }
                }
                out.println(new String(result));
            }
        }

        class Segment implements Comparable<Segment> {
            int left;
            int right;
            int id;

            public Segment(int left, int right, int id) {
                this.left = left;
                this.right = right;
                this.id = id;
            }

            public int compareTo(Segment segment) {
                return right - segment.right;
            }

        }

    }

    static class FastScanner {
        public BufferedReader br;
        public StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public FastScanner(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

    }
}

