import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    private FastReader in;
    private PrintWriter out;
    private int[][] skills;
    private boolean[][] eliminated;

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        in = new FastReader(System.in);
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    private void solve() {
        int testCases = in.nextInt();

        for (int tc = 1; tc <= testCases; tc++) {
            int rows = in.nextInt();
            int cols = in.nextInt();

            skills = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    skills[i][j] = in.nextInt();
                }
            }

            eliminated = new boolean[rows][cols];
            boolean hasEliminations = true;
            int totalInterest = 0;
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            while (hasEliminations) {
                List<Integer> elimRows = new ArrayList<>();
                List<Integer> elimCols = new ArrayList<>();
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (!eliminated[i][j]) {
                            totalInterest += skills[i][j];
                            int opponentSkillsSum = 0;
                            int numOpponents = 0;
                            for (int k = 0; k < 4; k++) {
                                int neighborSkill = getNeighbor(i, j, dx[k], dy[k]);
                                if (neighborSkill > -1) {
                                    opponentSkillsSum += neighborSkill;
                                    numOpponents++;
                                }
                            }
                            if (numOpponents > 0 && skills[i][j] * numOpponents < opponentSkillsSum) {
                                elimRows.add(i);
                                elimCols.add(j);
                            }
                        }
                    }
                }
                hasEliminations = !elimRows.isEmpty();
                for (int i = 0; i < elimRows.size(); i++) {
                    eliminated[elimRows.get(i)][elimCols.get(i)] = true;
                }
            }
            out.println("Case #" + tc + ": " + totalInterest);
        }
    }

    private int getNeighbor(int row, int col, int dRow, int dCol) {
        int numRows = skills.length, numCols = skills[0].length;
        row += dRow;
        col += dCol;
        while (row >= 0 && row < numRows && col >= 0 && col < numCols) {
            if (!eliminated[row][col]) {
                return skills[row][col];
            }
            row += dRow;
            col += dCol;
        }
        return -1;
    }

    private void runWithFiles() {
        in = new FastReader(new File("input.txt"));
        try {
            out = new PrintWriter(new File("output.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        solve();
        out.close();
    }

    private static class FastReader {
        private BufferedReader br;
        private StringTokenizer tokenizer;

        public FastReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        public FastReader(File file) {
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        private String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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

        public BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

        public BigDecimal nextBigDecimal() {
            return new BigDecimal(next());
        }
    }
}