import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        solve();
    }
    
    public static void solve() {
        int t = readInt();
        for (int ti = 1; ti <= t; ti++) {
            int n = readInt(), trace = 0, duplicateRows = 0, duplicateCols = 0;
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = readInt();
                    if (i == j) trace += matrix[i][j];
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != n) duplicateRows++;
            }
            
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    colSet.add(matrix[j][i]);
                }
                if (colSet.size() != n) duplicateCols++;
            }
            
            System.out.printf("Case #%d: %d %d %d%n", ti, trace, duplicateRows, duplicateCols);
        }
    }
    
    static int readInt() {
        return Integer.parseInt(nextToken());
    }
    
    static long readLong() {
        return Long.parseLong(nextToken());
    }
    
    static double readDouble() {
        return Double.parseDouble(nextToken());
    }
    
    static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    
    static String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
}