import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br;
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = nextInt();
        int caseNumber = 1;
        
        while (t-- > 0) {
            int rows = nextInt();
            int cols = nextInt();
            int[][] values = new int[rows][cols];
            Contestant[][] contestants = new Contestant[rows][cols];
            long sum = 0;
            long total = 0;
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    values[i][j] = nextInt();
                    total += values[i][j];
                }
            }
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    contestants[i][j] = new Contestant(values[i][j], i, j, contestants);
                }
            }
            
            sum += total;
            boolean hasDied;
            
            do {
                hasDied = false;
                List<Contestant> toEliminate = new ArrayList<>();
                
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (contestants[i][j] != null && contestants[i][j].shouldDie()) {
                            hasDied = true;
                            total -= values[i][j];
                            toEliminate.add(contestants[i][j]);
                        }
                    }
                }
                
                for (Contestant contestant : toEliminate) {
                    contestant.propagate(contestants);
                    contestants[contestant.row][contestant.col] = null;
                }
                
                if (hasDied) {
                    sum += total;
                }
                
            } while (hasDied);
            
            System.out.println("Case #" + caseNumber++ + ": " + sum);
        }
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                throw new IOException();
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}

class Contestant {
    int row, col, value;
    Contestant[] neighbors;

    public Contestant(int value, int row, int col, Contestant[][] contestants) {
        this.row = row;
        this.col = col;
        this.value = value;
        this.neighbors = new Contestant[4];
        
        if (row > 0) {
            neighbors[0] = contestants[row - 1][col];
            contestants[row - 1][col].neighbors[1] = this;
        }
        if (col > 0) {
            neighbors[2] = contestants[row][col - 1];
            contestants[row][col - 1].neighbors[3] = this;
        }
    }

    public boolean shouldDie() {
        long sum = 0;
        int count = 0;
        
        for (Contestant neighbor : neighbors) {
            if (neighbor != null) {
                sum += neighbor.value;
                count++;
            }
        }
        
        return sum > value * count;
    }

    public void propagate(Contestant[][] contestants) {
        if (neighbors[0] != null) {
            neighbors[0].neighbors[1] = neighbors[1];
        }
        if (neighbors[1] != null) {
            neighbors[1].neighbors[0] = neighbors[0];
        }
        if (neighbors[2] != null) {
            neighbors[2].neighbors[3] = neighbors[3];
        }
        if (neighbors[3] != null) {
            neighbors[3].neighbors[2] = neighbors[2];
        }
    }
}