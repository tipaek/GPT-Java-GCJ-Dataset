import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + processTestCase(scanner));
        }
    }

    private static String processTestCase(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[] matrixData = new int[dimension * dimension];

        // Populate the matrix data
        for (int i = 0; i < dimension * dimension; i++) {
            matrixData[i] = scanner.nextInt();
        }

        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> columnSet = new HashSet<>();

        for (int i = 0; i < dimension; i++) {
            diagonalSum += matrixData[i * dimension + i];

            rowSet.clear();
            columnSet.clear();
            boolean rowHasDuplicate = false;
            boolean columnHasDuplicate = false;

            for (int j = 0; j < dimension; j++) {
                int rowElement = matrixData[i * dimension + j];
                int columnElement = matrixData[j * dimension + i];

                if (!rowSet.add(rowElement)) {
                    rowHasDuplicate = true;
                }
                if (!columnSet.add(columnElement)) {
                    columnHasDuplicate = true;
                }
            }

            if (rowHasDuplicate) duplicateRows++;
            if (columnHasDuplicate) duplicateColumns++;
        }

        return diagonalSum + " " + duplicateRows + " " + duplicateColumns;
    }
}