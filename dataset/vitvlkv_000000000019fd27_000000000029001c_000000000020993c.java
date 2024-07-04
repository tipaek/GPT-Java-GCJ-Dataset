import java.lang.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Matrix[] ms = null;
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            ms = new Matrix[T];
            for (int t = 0; t < T; ++t) {
                int N = sc.nextInt();
                int[][] m = new int[N][N];
                for (int r = 0; r < N; ++r) {
                    for (int c = 0; c < N; ++c) {
                        m[r][c] = sc.nextInt();
                    }
                }
                ms[t] = new Matrix(m);
            }
        }
        
        for (int i = 0; i < ms.length; ++i) {
            Matrix m = ms[i];
            System.out.println("Case #" + (i + 1) + m.trace() + " " + m.repeatedRows() + 
                " " + m.repeatedCols());    
        }
        
    }
    
    private static class Matrix {
        private int[][] m;
        
        public Matrix(int[][] m) {
            this.m = m;
        }
        
        public int trace() {
            int result = 0;
            for (int i = 0; i < m.length; ++i) {
                result += m[i][i];
            }
            return result;
        }
        
        public int repeatedRows() {
            return -1;
        }
        
        public int repeatedCols() {
            return -1;
        }
    }
}