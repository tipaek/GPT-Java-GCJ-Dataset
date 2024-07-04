import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;

            // Reading the matrix and calculating the diagonal sum
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int expectedSum = size * (size + 1) / 2;
            int rowIssues = 0, colIssues = 0;

            // Checking each row for issues
            for (int i = 0; i < size; i++) {
                List<Integer> rowList = new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    rowList.add(matrix[i][j]);
                }
                for (int k = 1; k <= size; k++) {
                    if (!rowList.contains(k)) {
                        rowIssues++;
                        break;
                    }
                }
            }

            // Checking each column for issues
            for (int j = 0; j < size; j++) {
                List<Integer> colList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    colList.add(matrix[i][j]);
                }
                for (int k = 1; k <= size; k++) {
                    if (!colList.contains(k)) {
                        colIssues++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + diagonalSum + " " + rowIssues + " " + colIssues);
        }

        scanner.close();
    }
}