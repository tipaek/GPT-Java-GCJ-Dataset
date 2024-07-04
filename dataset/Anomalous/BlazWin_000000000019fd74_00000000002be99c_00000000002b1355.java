import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SquareDance solver = new SquareDance();
        int testCount = in.nextInt();
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class SquareDance {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            Cell[][] cells = new Cell[n][m];
            long rSum = 0;

            // Initialize cells with skills and calculate initial total skill sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    cells[i][j] = new Cell(in.nextInt());
                    rSum += cells[i][j].skill;
                }
            }

            // Link neighboring cells
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i > 0) cells[i][j].top = cells[i - 1][j];
                    if (i < n - 1) cells[i][j].bot = cells[i + 1][j];
                    if (j > 0) cells[i][j].left = cells[i][j - 1];
                    if (j < m - 1) cells[i][j].right = cells[i][j + 1];
                }
            }

            List<Cell> candidates = new ArrayList<>();
            // Collect initial candidates
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (cells[i][j].isCandidate()) {
                        candidates.add(cells[i][j]);
                    }
                }
            }

            long total = 0;
            List<Cell> newCandidates = new ArrayList<>();

            while (!candidates.isEmpty()) {
                total += rSum;
                newCandidates.clear();
                for (Cell candidate : candidates) {
                    rSum -= candidate.skill;
                    candidate.remove(newCandidates);
                }
                candidates.clear();
                candidates.addAll(newCandidates);
            }

            out.printf("Case #%d: %d%n", testNumber, total);
        }

        static class Cell {
            int skill;
            boolean removed;
            Cell top, bot, left, right;

            Cell(int skill) {
                this.skill = skill;
            }

            boolean isCandidate() {
                int sum = 0, count = 0;
                if (top != null) { sum += top.skill; count++; }
                if (bot != null) { sum += bot.skill; count++; }
                if (left != null) { sum += left.skill; count++; }
                if (right != null) { sum += right.skill; count++; }
                return removed = skill * count < sum;
            }

            void remove(List<Cell> newCandidates) {
                if (top != null) {
                    top.bot = bot;
                    if (!top.removed && top.isCandidate()) newCandidates.add(top);
                }
                if (bot != null) {
                    bot.top = top;
                    if (!bot.removed && bot.isCandidate()) newCandidates.add(bot);
                }
                if (left != null) {
                    left.right = right;
                    if (!left.removed && left.isCandidate()) newCandidates.add(left);
                }
                if (right != null) {
                    right.left = left;
                    if (!right.removed && right.isCandidate()) newCandidates.add(right);
                }
            }
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}