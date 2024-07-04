import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    
    private static void vestigium(int[][] matrix, int testNo) {
        long trace = 0;
        int N = matrix.length;
        int rowCount = 0;
        int colCount = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
            // i-th row
            set.clear();
            for (int j = 0; j < N; j++) {
                if (set.contains(matrix[i][j])) {
                    rowCount++;
                    break;
                } else {
                    set.add(matrix[i][j]);
                }
            }
            // i-th col
            set.clear();
            for (int j = 0; j < N; j++) {
                if (set.contains(matrix[j][i])) {
                    colCount++;
                    break;
                } else {
                    set.add(matrix[j][i]);
                }
            }
        }
        System.out.printf("Case #%d: %d %d %d\n", testNo, trace, rowCount, colCount);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test = 1; test <= T; test++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            vestigium(matrix, test);
        }
        sc.close();
    }
}