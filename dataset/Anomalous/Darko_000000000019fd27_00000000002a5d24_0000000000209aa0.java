import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private Map<Integer, Map<Integer, int[][]>> matrixMap;

    public static void main(String[] args) {
        new Solution().execute();
    }

    private void execute() {
        matrixMap = new HashMap<>();
        for (int i = 2; i <= 5; i++) {
            generateMatrices(i);
        }

        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= numCases; caseNum++) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                if (n > 5 || k < n || k > n * n) {
                    System.out.printf("Case #%d: IMPOSSIBLE\n", caseNum);
                } else {
                    if (!matrixMap.get(n).containsKey(k)) {
                        System.out.printf("Case #%d: IMPOSSIBLE\n", caseNum);
                    } else {
                        System.out.printf("Case #%d: POSSIBLE\n", caseNum);
                        printMatrix(n, matrixMap.get(n).get(k));
                    }
                }
            }
        }
    }

    private void printMatrix(int n, int[][] matrix) {
        for (int[] row : matrix) {
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    System.out.print(" ");
                }
                System.out.print(row[j]);
            }
            System.out.println();
        }
    }

    private void generateMatrices(int size) {
        int[][] matrix = new int[size][size];
        matrixMap.put(size, new HashMap<>());
        fillMatrix(size, 0, 0, matrix);
    }

    private void fillMatrix(int size, int row, int col, int[][] matrix) {
        if (col == size) {
            fillMatrix(size, row + 1, 0, matrix);
            return;
        }

        if (row == size) {
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }
            if (!matrixMap.get(size).containsKey(trace)) {
                int[][] matrixCopy = new int[size][size];
                for (int i = 0; i < size; i++) {
                    System.arraycopy(matrix[i], 0, matrixCopy[i], 0, size);
                }
                matrixMap.get(size).put(trace, matrixCopy);
            }
            return;
        }

        for (int num = 1; num <= size; num++) {
            if (!isUsed(size, row, col, matrix, num)) {
                matrix[row][col] = num;
                fillMatrix(size, row, col + 1, matrix);
            }
        }
    }

    private boolean isUsed(int size, int row, int col, int[][] matrix, int num) {
        for (int j = 0; j < col; j++) {
            if (matrix[row][j] == num) {
                return true;
            }
        }

        for (int i = 0; i < row; i++) {
            if (matrix[i][col] == num) {
                return true;
            }
        }

        return false;
    }
}