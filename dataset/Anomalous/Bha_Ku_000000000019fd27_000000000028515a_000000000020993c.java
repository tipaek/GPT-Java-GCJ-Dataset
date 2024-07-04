import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int z = 1; z <= T; z++) {
            int size = sc.nextInt();
            int[][] mat = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            
            int traceValue = calculateTrace(mat, size);
            int rowDuplicates = countRowDuplicates(mat, size);
            int colDuplicates = countColDuplicates(mat, size);
            
            System.out.printf("Case #%d: %d %d %d%n", z, traceValue, rowDuplicates, colDuplicates);
        }
    }
    
    private static int calculateTrace(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    
    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }
    
    private static int countColDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }
    
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> elements = new HashSet<>();
        for (int value : array) {
            if (!elements.add(value)) {
                return true;
            }
        }
        return false;
    }
}