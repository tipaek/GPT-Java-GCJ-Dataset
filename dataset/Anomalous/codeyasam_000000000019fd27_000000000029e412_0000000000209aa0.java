import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int matrixSize = scanner.nextInt();
            int requiredTrace = scanner.nextInt();
            int[][] latinMatrix = createLatinMatrix(matrixSize);
            boolean isPossible = isTracePossible(matrixSize, latinMatrix, requiredTrace);
            if (isPossible) {
                System.out.println("Case #" + caseNum + ": POSSIBLE");
                printMatrix(latinMatrix);
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    static int[][] createLatinMatrix(int size) {
        int[][] matrix = new int[size][size];
        int row = 0;
        int col;
        int k = size + 1;

        for (int i = 1; i <= size; i++) {
            col = 0;
            int temp = k;

            while (temp <= size) {
                matrix[row][col] = temp;
                temp++;
                col++;
            }

            for (int j = 1; j < k; j++) {
                matrix[row][col++] = j;
            }

            row++;
            k--;
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void rotateMatrix(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][size - 1 - j];
                matrix[i][size - 1 - j] = temp;
            }
        }
    }

    public static boolean isTracePossible(int[][] matrix, int trace) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum == trace;
    }

    public static boolean isTracePossible(int size, int[][] matrix, int trace) {
        if (isTracePossible(matrix, trace)) {
            return true;
        }

        if (size == 1) {
            return false;
        } else {
            for (int i = 0; i < size - 1; i++) {
                if (isTracePossible(size - 1, matrix, trace)) {
                    return true;
                }
                if (size % 2 == 0) {
                    swapRows(matrix, i, size - 1);
                } else {
                    swapRows(matrix, 0, size - 1);
                }
            }
            return isTracePossible(size - 1, matrix, trace);
        }
    }

    private static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }
}