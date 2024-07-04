import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SquareDance solver = new SquareDance();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class SquareDance {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            SquareDance.Cell[][] cells = new SquareDance.Cell[n][m];
            long rSum = 0;
            for (int i = 0; i < n; i++) {
                for (int h = 0; h < m; h++) {
                    cells[i][h] = new SquareDance.Cell();
                    cells[i][h].skill = in.nextInt();
                    cells[i][h].removed = false;
                    rSum += cells[i][h].skill;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int h = 0; h < m; h++) {
                    if (i != 0) {
                        cells[i][h].top = cells[i - 1][h];
                    }
                    if (i != n - 1) {
                        cells[i][h].bot = cells[i + 1][h];
                    }
                    if (h != 0) {
                        cells[i][h].left = cells[i][h - 1];
                    }
                    if (h != m - 1) {
                        cells[i][h].right = cells[i][h + 1];
                    }
                }
            }

            List<SquareDance.Cell> cands = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int h = 0; h < m; h++) {
                    if (cells[i][h].isCand()) {
                        cands.add(cells[i][h]);
                    }
                }
            }
            long total = 0;
            List<SquareDance.Cell> newCands = new ArrayList<>();
            List<SquareDance.Cell> toCheck = new ArrayList<>();

            while (true) {
                total += rSum;
                if (cands.isEmpty()) {
                    break;
                }
                newCands.clear();
                toCheck.clear();
                for (SquareDance.Cell cand : cands) {
                    rSum -= cand.skill;
                    if (cand.top != null) {
                        cand.top.bot = cand.bot;
                        if (!cand.top.removed) {
                            toCheck.add(cand.top);
                        }
                    }
                    if (cand.bot != null) {
                        cand.bot.top = cand.top;
                        if (!cand.bot.removed) {
                            toCheck.add(cand.bot);
                        }
                    }
                    if (cand.left != null) {
                        cand.left.right = cand.right;
                        if (!cand.left.removed) {
                            toCheck.add(cand.left);
                        }
                    }
                    if (cand.right != null) {
                        cand.right.left = cand.left;
                        if (!cand.right.removed) {
                            toCheck.add(cand.right);
                        }
                    }
                }
                for (SquareDance.Cell cand : toCheck) {
                    if (!cand.removed && cand.isCand()) {
                        newCands.add(cand);
                    }
                }
                cands.clear();
                cands.addAll(newCands);
            }
            out.println(String.format("Case #%d: %d", testNumber, total));
        }

        public static class Cell {

            int skill;
            boolean removed;
            SquareDance.Cell top;
            SquareDance.Cell bot;
            SquareDance.Cell left;
            SquareDance.Cell right;

            boolean isCand() {
                int sum = 0;
                int ct = 0;
                if (top != null) {
                    ct++;
                    sum += top.skill;
                }
                if (bot != null) {
                    ct++;
                    sum += bot.skill;
                }
                if (left != null) {
                    ct++;
                    sum += left.skill;
                }
                if (right != null) {
                    ct++;
                    sum += right.skill;
                }
                removed = skill * ct < sum;
                return removed;
            }
        }
    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

