import java.util.*;

public class Solution {

    public static int[] getResult(int[][] matrix) {
        int n = matrix.length;
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;

        // Calculate trace
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Check for duplicate values in rows
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowDuplicates++;
                    break;
                }
            }
        }

        // Check for duplicate values in columns
        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!colSet.add(matrix[i][j])) {
                    colDuplicates++;
                    break;
                }
            }
        }

        return new int[]{trace, rowDuplicates, colDuplicates};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int[] result = getResult(matrix);
            System.out.printf("Case #%d: %d %d %d%n", t + 1, result[0], result[1], result[2]);
        }
        
        scanner.close();
    }
}