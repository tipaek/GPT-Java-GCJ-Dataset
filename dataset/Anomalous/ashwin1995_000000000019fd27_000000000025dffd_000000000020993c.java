import java.util.HashSet;
import java.util.Scanner;

class MatrixDemo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int noOfTestCases = Integer.parseInt(in.next());

        for (int i = 0; i < noOfTestCases; i++) {
            int matrixOrder = Integer.parseInt(in.next());
            int[][] matrix = new int[matrixOrder][matrixOrder];

            int diagonalSum = 0;
            int duplicateInRow = 0;
            int duplicateInColumn = 0;

            // Read matrix and calculate diagonal sum
            for (int row = 0; row < matrixOrder; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean hasDuplicateInRow = false;

                for (int col = 0; col < matrixOrder; col++) {
                    int value = Integer.parseInt(in.next());
                    matrix[row][col] = value;

                    if (row == col) {
                        diagonalSum += value;
                    }

                    if (!rowSet.add(value)) {
                        hasDuplicateInRow = true;
                    }
                }

                if (hasDuplicateInRow) {
                    duplicateInRow++;
                }
            }

            // Check for duplicates in columns
            for (int col = 0; col < matrixOrder; col++) {
                HashSet<Integer> colSet = new HashSet<>();

                for (int row = 0; row < matrixOrder; row++) {
                    colSet.add(matrix[row][col]);
                }

                if (colSet.size() != matrixOrder) {
                    duplicateInColumn++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + duplicateInRow + " " + duplicateInColumn);
        }

        in.close();
    }
}