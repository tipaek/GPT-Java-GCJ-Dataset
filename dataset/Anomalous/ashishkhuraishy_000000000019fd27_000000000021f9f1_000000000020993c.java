import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                diagonalSum += matrix[i][i];

                for (int j = 0; j < size; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                    if (!colSet.add(matrix[j][i])) {
                        colHasDuplicate = true;
                    }
                }

                if (rowHasDuplicate) {
                    duplicateRows++;
                }
                if (colHasDuplicate) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + duplicateColumns + " " + duplicateRows);
        }

        scanner.close();
    }
}