import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    private FastReader in;
    private PrintWriter out;
    
    public static void main(String[] args) {
        new Solution().run();
    }
    
    private void run() {
        in = new FastReader(System.in);
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }
    
    private int[][] skills;
    private boolean[][] eliminated;
    
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
            long totalInterest = 0;
            int[] dx = { 0, 0, 1, -1 };
            int[] dy = { 1, -1, 0, 0 };
            
            while (hasEliminations) {
                List<Integer> elimRows = new ArrayList<>();
                List<Integer> elimCols = new ArrayList<>();
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (!eliminated[i][j]) {
                            totalInterest += skills[i][j];
                            int opponentSkillSum = 0;
                            int opponentCount = 0;
                            for (int k = 0; k < 4; k++) {
                                int neighborSkill = getNeighborSkill(i, j, dx[k], dy[k]);
                                if (neighborSkill > -1) {
                                    opponentSkillSum += neighborSkill;
                                    opponentCount++;
                                }
                            }
                            if (opponentCount > 0 && skills[i][j] * opponentCount < opponentSkillSum) {
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
    
    private int getNeighborSkill(int row, int col, int rowDelta, int colDelta) {
        int rows = skills.length;
        int cols = skills[0].length;
        row += rowDelta;
        col += colDelta;
        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (!eliminated[row][col]) {
                return skills[row][col];
            }
            row += rowDelta;
            col += colDelta;
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
    
    private class FastReader {
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