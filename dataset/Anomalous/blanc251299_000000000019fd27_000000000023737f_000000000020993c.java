import java.util.*;

public class Codejam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix, n);
            int rowDuplicates = countDuplicateRows(matrix, n);
            int colDuplicates = countDuplicateColumns(matrix, n);
            
            System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
    
    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    private static int countDuplicateRows(int[][] matrix, int n) {
        int rowDuplicates = 0;
        for (int i = 0; i < n; i++) {
            if (containsDuplicates(matrix[i], n)) {
                rowDuplicates++;
            }
        }
        return rowDuplicates;
    }
    
    private static int countDuplicateColumns(int[][] matrix, int n) {
        int colDuplicates = 0;
        for (int i = 0; i < n; i++) {
            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                column[j] = matrix[j][i];
            }
            if (containsDuplicates(column, n)) {
                colDuplicates++;
            }
        }
        return colDuplicates;
    }
    
    private static boolean containsDuplicates(int[] array, int n) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (value > n || !set.add(value)) {
                return true;
            }
        }
        return false;
    }
}