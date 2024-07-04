import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        List<Integer[][]> results = new ArrayList<>();
        
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            results.add(solve(n, s));
        }

        for (int i = 0; i < results.size(); i++) {
            Integer[][] result = results.get(i);
            if (result == null) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                printMatrix(result);
            }
        }
    }

    private static void printMatrix(Integer[][] matrix) {
        for (Integer[] row : matrix) {
            System.out.println(IntStream.range(0, row.length)
                                        .mapToObj(j -> row[j].toString())
                                        .reduce((a, b) -> a + " " + b)
                                        .orElse(""));
        }
    }

    private static Integer[][] solve(int n, int s) {
        Integer[][] matrix = initializeMatrix(n);

        for (int i = 0; i < n; i++) {
            matrix = shiftTop(matrix);
            for (int j = 0; j < n; j++) {
                matrix = shiftLeft(matrix);
                if (diagonalSum(matrix) == s) {
                    return matrix;
                }
            }
            matrix = mirrorLeft(matrix);
            for (int j = 0; j < n; j++) {
                matrix = shiftLeft(matrix);
                if (diagonalSum(matrix) == s) {
                    return matrix;
                }
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

    private static int diagonalSum(Integer[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static Integer[][] shiftLeft(Integer[][] matrix) {
        int n = matrix.length;
        Integer[][] newMatrix = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[i][(j + 1) % n] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    private static Integer[][] mirrorLeft(Integer[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                matrix[i][n - 1 - j] = matrix[i][j];
            }
        }
        return matrix;
    }

    private static Integer[][] shiftTop(Integer[][] matrix) {
        int n = matrix.length;
        Integer[][] newMatrix = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[(i + 1) % n][j] = matrix[i][j];
            }
        }
        return newMatrix;
    }
}