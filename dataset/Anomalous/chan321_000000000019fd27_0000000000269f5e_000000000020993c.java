import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CJ1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        
        for (int k = 1; k <= t; k++) {
            int n = Integer.parseInt(bf.readLine().trim());
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                String[] row = bf.readLine().trim().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }
            
            solveForAns(k, matrix);
        }
    }

    private static void solveForAns(int testCaseNo, int[][] matrix) {
        int trace = calculateTrace(matrix);
        int duplicateRows = getDuplicateRowsNo(matrix);
        int duplicateColumns = getDuplicateColumnsNo(matrix);
        
        System.out.println("Case #" + testCaseNo + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int getDuplicateRowsNo(int[][] matrix) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                uniqueElements.add(element);
            }
            if (uniqueElements.size() != matrix.length) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int getDuplicateColumnsNo(int[][] matrix) {
        int duplicateColumns = 0;
        int n = matrix.length;
        
        for (int j = 0; j < n; j++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < n; i++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != n) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }
}