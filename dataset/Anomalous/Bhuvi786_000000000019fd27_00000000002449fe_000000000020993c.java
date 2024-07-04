import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;

            // Read the matrix and calculate the diagonal sum
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }

            int rowRepeats = 0;
            int colRepeats = 0;

            // Check for row duplicates
            for (int row = 0; row < size; row++) {
                List<Integer> rowList = new ArrayList<>();
                for (int col = 0; col < size; col++) {
                    rowList.add(matrix[row][col]);
                }
                for (int num = 1; num <= size; num++) {
                    if (!rowList.contains(num)) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check for column duplicates
            for (int col = 0; col < size; col++) {
                List<Integer> colList = new ArrayList<>();
                for (int row = 0; row < size; row++) {
                    colList.add(matrix[row][col]);
                }
                for (int num = 1; num <= size; num++) {
                    if (!colList.contains(num)) {
                        colRepeats++;
                        break;
                    }
                }
            }

            // Output the result for the current test case
            System.out.println("Case #" + (testCase + 1) + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }
    }
}