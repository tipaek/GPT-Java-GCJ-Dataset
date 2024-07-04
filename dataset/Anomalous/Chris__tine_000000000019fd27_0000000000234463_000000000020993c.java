import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            
            int[] result = analyzeMatrix(N, matrix);
            System.out.printf("Case #%d: %d %d %d\n", i + 1, result[0], result[1], result[2]);
        }
    }
    
    private static int[] analyzeMatrix(int N, int[][] matrix) {
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;
        
        for (int i = 0; i < N; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean rowHasDuplicate = false;
            
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!rowSet.add(matrix[i][j])) {
                    rowHasDuplicate = true;
                }
            }
            if (rowHasDuplicate) {
                rowRepeats++;
            }
        }
        
        for (int i = 0; i < N; i++) {
            Set<Integer> colSet = new HashSet<>();
            boolean colHasDuplicate = false;
            
            for (int j = 0; j < N; j++) {
                if (!colSet.add(matrix[j][i])) {
                    colHasDuplicate = true;
                }
            }
            if (colHasDuplicate) {
                colRepeats++;
            }
        }
        
        return new int[]{trace, rowRepeats, colRepeats};
    }
}