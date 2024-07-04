import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        List<Integer[][]> results = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            Integer[][] matrix = findMatrix(n, s);
            results.add(matrix);
        }

        int caseNumber = 1;
        for (Integer[][] result : results) {
            if (result == null) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                printMatrix(result);
            }
            caseNumber++;
        }
    }

    private static void printMatrix(Integer[][] matrix) {
        int n = matrix.length;
        for (Integer[] row : matrix) {
            System.out.println(IntStream.range(0, n)
                    .mapToObj(col -> row[col].toString())
                    .reduce((a, b) -> a + " " + b)
                    .orElse(""));
        }
    }

    private static Integer[][] findMatrix(int n, int s) {
        Integer[][] matrix = initializeMatrix(n);
        for (int i = 0; i < n; i++) {
            matrix = rotateTop(matrix);
            for (int j = 0; j < n; j++) {
                matrix = shiftLeft(matrix);
                if (calculateDiagonalSum(matrix) == s) return matrix;
                matrix = flipTop(matrix);
                if (calculateDiagonalSum(matrix) == s) return matrix;
                matrix = flipTop(matrix);
                if (calculateDiagonalSum(matrix) == s) return matrix;
                matrix = flipLeft(matrix);
            }
        }
        return null;
    }

    private static Integer[][] initializeMatrix(int n) {
        Integer[][] matrix = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (i + j + 1) % n == 0 ? n : (i + j + 1) % n;
            }
        }
        return matrix;
    }

    private static int calculateDiagonalSum(Integer[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static Integer[][] shiftLeft(Integer[][] matrix) {
        int n = matrix.length;
        Integer[][] shiftedMatrix = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                shiftedMatrix[i][(j + 1) % n] = matrix[i][j];
            }
        }
        return shiftedMatrix;
    }

    private static Integer[][] flipLeft(Integer[][] matrix) {
        int n = matrix.length;
        Integer[][] flippedMatrix = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flippedMatrix[i][n - j - 1] = matrix[i][j];
            }
        }
        return flippedMatrix;
    }

    private static Integer[][] flipTop(Integer[][] matrix) {
        int n = matrix.length;
        Integer[][] flippedMatrix = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flippedMatrix[n - i - 1][j] = matrix[i][j];
            }
        }
        return flippedMatrix;
    }

    private static Integer[][] rotateTop(Integer[][] matrix) {
        int n = matrix.length;
        Integer[][] rotatedMatrix = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[(i + 1) % n][j] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }
}