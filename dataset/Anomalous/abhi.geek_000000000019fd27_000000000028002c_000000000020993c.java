import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalTestCases = Integer.parseInt(scanner.nextLine().trim());
        
        for (int testCase = 1; testCase <= totalTestCases; testCase++) {
            int matrixSize = Integer.parseInt(scanner.nextLine().trim());
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                String[] rowInput = scanner.nextLine().trim().split(" ");
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(rowInput[j]);
                }
            }
            
            int[] result = evaluateMatrixForLatinMatrix(matrix);
            System.out.println("Case #" + testCase + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }

    private static int[] evaluateMatrixForLatinMatrix(int[][] matrix) {
        int trace = 0, rowDuplicates = 0, columnDuplicates = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
            boolean[] rowCheck = new boolean[size];
            boolean[] columnCheck = new boolean[size];
            boolean isRowDup = false, isColDup = false;

            for (int j = 0; j < size; j++) {
                if (rowCheck[matrix[i][j] - 1]) {
                    isRowDup = true;
                } else {
                    rowCheck[matrix[i][j] - 1] = true;
                }

                if (columnCheck[matrix[j][i] - 1]) {
                    isColDup = true;
                } else {
                    columnCheck[matrix[j][i] - 1] = true;
                }
            }

            if (isRowDup) rowDuplicates++;
            if (isColDup) columnDuplicates++;
        }

        return new int[]{trace, rowDuplicates, columnDuplicates};
    }
}