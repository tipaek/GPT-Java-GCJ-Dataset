import java.util.HashSet;
import java.util.Scanner;

public class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            int diagonalSum = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int duplicateRows = 0, duplicateCols = 0;

            for (int i = 0; i < size; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            for (int j = 0; j < size; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber++ + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}