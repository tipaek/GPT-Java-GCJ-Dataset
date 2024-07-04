import java.util.Scanner;
import java.util.TreeSet;

class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int matrixSize = sc.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int[][] transposedMatrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = sc.nextInt();
                    transposedMatrix[col][row] = matrix[row][col];
                }
            }

            int trace = 0, rowCount = 0, colCount = 0;

            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];

                TreeSet<Integer> rowSet = new TreeSet<>();
                TreeSet<Integer> colSet = new TreeSet<>();

                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(transposedMatrix[i][j]);
                }

                if (rowSet.size() != matrixSize) {
                    rowCount++;
                }

                if (colSet.size() != matrixSize) {
                    colCount++;
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }

        sc.close();
    }
}