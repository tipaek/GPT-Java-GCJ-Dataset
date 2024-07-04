import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = reader.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = reader.nextInt();
                }
            }
            
            int duplicateRows = 0;
            int duplicateCols = 0;
            int trace = 0;
            
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                
                if (rowSet.size() != n) {
                    duplicateRows++;
                }
                
                if (colSet.size() != n) {
                    duplicateCols++;
                }
                
                trace += matrix[i][i];
            }
            
            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, duplicateRows, duplicateCols);
        }
    }
}

class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private String next() {
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
        }
        return str;
    }
}