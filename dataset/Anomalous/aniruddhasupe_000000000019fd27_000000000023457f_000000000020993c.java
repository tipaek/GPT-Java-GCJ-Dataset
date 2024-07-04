import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean hasDuplicateInRow(int[][] matrix, int size, int row) {
        for (int col = 0; col < size; col++) {
            int num = matrix[row][col];
            for (int nextCol = col + 1; nextCol < size; nextCol++) {
                if (num == matrix[row][nextCol]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasDuplicateInColumn(int[][] matrix, int size, int col) {
        for (int row = 0; row < size; row++) {
            int num = matrix[row][col];
            for (int nextRow = row + 1; nextRow < size; nextRow++) {
                if (num == matrix[nextRow][col]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int duplicateRows = 0;
            int duplicateColumns = 0;
            int trace = 0;

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            for (int row = 0; row < size; row++) {
                if (hasDuplicateInRow(matrix, size, row)) {
                    duplicateRows++;
                }
            }

            for (int col = 0; col < size; col++) {
                if (hasDuplicateInColumn(matrix, size, col)) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }
}