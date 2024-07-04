import java.util.*;
import java.io.*;

public class Solution {
    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = nextInt();
        
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int gridSize = nextInt();
            int[][] grid = new int[gridSize][gridSize];
            
            for (int row = 0; row < gridSize; row++) {
                for (int col = 0; col < gridSize; col++) {
                    grid[row][col] = nextInt();
                }
            }
            
            int trace = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;
            
            for (int i = 0; i < gridSize; i++) {
                trace += grid[i][i];
                
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;
                
                for (int j = 0; j < gridSize; j++) {
                    if (!rowHasDuplicate && !rowSet.add(grid[i][j])) {
                        repeatedRows++;
                        rowHasDuplicate = true;
                    }
                    
                    if (!colHasDuplicate && !colSet.add(grid[j][i])) {
                        repeatedCols++;
                        colHasDuplicate = true;
                    }
                    
                    if (rowHasDuplicate && colHasDuplicate) {
                        break;
                    }
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, repeatedRows, repeatedCols);
        }
    }

    private static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                throw new IOException();
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}