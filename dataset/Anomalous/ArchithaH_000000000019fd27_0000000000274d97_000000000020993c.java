import java.util.HashSet;
import java.util.Scanner;

public class Codejam {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }

            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateColumns = countDuplicateColumns(matrix, n);
            int diagonalSum = calculateDiagonalSum(matrix, n);

            System.out.println("Case #" + t + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (rowSet.contains(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
                rowSet.add(matrix[i][j]);
            }
        }

        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int n) {
        int duplicateColumns = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (colSet.contains(matrix[j][i])) {
                    duplicateColumns++;
                    break;
                }
                colSet.add(matrix[j][i]);
            }
        }

        return duplicateColumns;
    }

    private static int calculateDiagonalSum(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}