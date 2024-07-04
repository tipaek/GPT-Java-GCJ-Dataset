import java.util.Scanner;

class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            // Reading the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            
            // Calculating the trace
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }
            
            // Checking for duplicate elements in rows
            for (int i = 0; i < matrixSize; i++) {
                boolean[] rowCheck = new boolean[matrixSize + 1];
                for (int j = 0; j < matrixSize; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        rowDuplicates++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }
            
            // Checking for duplicate elements in columns
            for (int j = 0; j < matrixSize; j++) {
                boolean[] colCheck = new boolean[matrixSize + 1];
                for (int i = 0; i < matrixSize; i++) {
                    if (colCheck[matrix[i][j]]) {
                        colDuplicates++;
                        break;
                    }
                    colCheck[matrix[i][j]] = true;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
}