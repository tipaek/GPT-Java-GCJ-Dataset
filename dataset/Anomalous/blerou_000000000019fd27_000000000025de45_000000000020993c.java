import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

class MatrixSolver {
    
    static String solveMatrix(int size, int[][] matrix) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
            
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            
            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }
            
            if (rowSet.size() != size) rowDuplicates++;
            if (colSet.size() != size) colDuplicates++;
        }
        
        return String.format("%d %d %d", trace, rowDuplicates, colDuplicates);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            System.out.printf("Case #%d: %s\n", caseNumber, solveMatrix(matrixSize, matrix));
        }
        
        scanner.close();
    }
}