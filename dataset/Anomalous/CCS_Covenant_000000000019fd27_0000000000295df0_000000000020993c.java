import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        for (int i = 0; i < input; i++) {
            int[] output = processMatrix(sc);
            System.out.println("Case #" + (i + 1) + ": " + output[2] + " " + output[1] + " " + output[0]);
        }
        sc.close();
    }

    public static int[] processMatrix(Scanner sc) {
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[] output = { countDuplicateRows(matrix), countDuplicateColumns(matrix), calculateDiagonalSum(matrix) };
        return output;
    }

    public static int countDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean hasDuplicate = false;
            for (int j = 0; j < matrix.length; j++) {
                for (int z = j + 1; z < matrix.length; z++) {
                    if (matrix[i][j] == matrix[i][z]) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) break;
            }
            if (hasDuplicate) {
                duplicateRowCount++;
            }
        }
        return duplicateRowCount;
    }

    public static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumnCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean hasDuplicate = false;
            for (int j = 0; j < matrix.length; j++) {
                for (int z = j + 1; z < matrix.length; z++) {
                    if (matrix[j][i] == matrix[z][i]) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) break;
            }
            if (hasDuplicate) {
                duplicateColumnCount++;
            }
        }
        return duplicateColumnCount;
    }

    public static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}