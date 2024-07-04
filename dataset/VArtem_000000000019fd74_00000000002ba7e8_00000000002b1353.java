import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
        PascalWalk solver = new PascalWalk();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class PascalWalk {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            out.printf("Case #%d: ", testNumber);
            int n = in.nextInt();
            List<String> result = get(n);
            for (String s : result) {
                out.println(s);
            }
        }

        private List<String> get(int n) {
            for (int choose = 1; ; choose++) {
                long rem = n - choose;

                boolean[] walk = new boolean[choose];
                for (int i = choose - 1; i >= 0; i--) {
                    if (rem >= ((1L << i) - 1)) {
                        rem -= (1L << i) - 1;
                        walk[i] = true;
                    }
                }

                if (rem == 0) {
                    List<String> result = new ArrayList<>();
                    boolean left = true;
                    for (int i = 0; i < choose; i++) {
                        if (!walk[i]) {
                            if (left) {
                                result.add((i + 1) + " " + 1);
                            } else {
                                result.add((i + 1) + " " + (i + 1));
                            }
                        } else {
                            int start = 1;
                            int dir = 1;
                            if (!left) {
                                start = i + 1;
                                dir = -1;
                            }
                            for (int t = 0; t <= i; t++) {
                                result.add((i + 1) + " " + (start + dir * t));
                            }
                            left = !left;
                        }
                    }
                    return result;
                }
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

