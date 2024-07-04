import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[] traces = new int[testCases];
        
        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int dimension = scanner.nextInt();
            int[][] matrix = new int[dimension][dimension];
            int rowDuplicates = 0, colDuplicates = 0;
            
            // Read matrix and calculate trace
            for (int row = 0; row < dimension; row++) {
                boolean[] rowCheck = new boolean[dimension];
                boolean hasRowDuplicate = false;
                for (int col = 0; col < dimension; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        traces[caseIndex] += matrix[row][col];
                    }
                    if (rowCheck[matrix[row][col] - 1]) {
                        hasRowDuplicate = true;
                    } else {
                        rowCheck[matrix[row][col] - 1] = true;
                    }
                }
                if (hasRowDuplicate) {
                    rowDuplicates++;
                }
            }
            
            // Check for column duplicates
            for (int col = 0; col < dimension; col++) {
                boolean[] colCheck = new boolean[dimension];
                boolean hasColDuplicate = false;
                for (int row = 0; row < dimension; row++) {
                    if (colCheck[matrix[row][col] - 1]) {
                        hasColDuplicate = true;
                    } else {
                        colCheck[matrix[row][col] - 1] = true;
                    }
                }
                if (hasColDuplicate) {
                    colDuplicates++;
                }
            }
            
            System.out.println("Case #" + (caseIndex + 1) + ": " + traces[caseIndex] + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
}