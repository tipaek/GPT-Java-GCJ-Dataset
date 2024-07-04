import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = initializeScanner();
        int testCases = Integer.parseInt(sc.nextLine());
        
        for (int i = 1; i <= testCases; i++) {
            String[] nk = sc.nextLine().split(" ");
            int N = Integer.parseInt(nk[0]);
            int K = Integer.parseInt(nk[1]);
            String result = processTestCase(N, K);
            System.out.println("Case #" + i + ": " + result);
        }
        
        sc.close();
    }

    private static Scanner initializeScanner() throws Exception {
        if (System.getProperty("user.name").equals("Alexey")) {
            System.err.println("development mode, reading from file");
            return new Scanner(new FileInputStream("input.txt"));
        } else {
            return new Scanner(System.in);
        }
    }

    private static String processTestCase(int N, int K) {
        int[][] matrix = new int[N][N];
        initializeMatrix(matrix);
        int currentDiagSum = calculateDiagonalSum(matrix);

        while (currentDiagSum < K) {
            int minIncrement = N * N + N;
            int swap1 = 0, swap2 = 0;
            boolean swapColumns = false, swapValues = false;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    int increment = calculateRowSwapIncrement(matrix, i, j);
                    if (increment > 0 && increment < minIncrement) {
                        minIncrement = increment;
                        swap1 = i;
                        swap2 = j;
                        swapColumns = false;
                    }
                    increment = calculateColumnSwapIncrement(matrix, i, j);
                    if (increment > 0 && increment < minIncrement) {
                        minIncrement = increment;
                        swap1 = i;
                        swap2 = j;
                        swapColumns = true;
                    }
                }
            }

            for (int i = 1; i <= N - 1; i++) {
                for (int j = i + 1; j <= N; j++) {
                    int increment = calculateValueSwapIncrement(matrix, i, j);
                    if (increment > 0 && increment <= minIncrement) {
                        minIncrement = increment;
                        swap1 = i;
                        swap2 = j;
                        swapValues = true;
                    }
                }
            }

            if (minIncrement == N * N + N) {
                break;
            }

            if (!swapColumns && !swapValues) {
                swapRows(matrix, swap1, swap2);
            } else if (swapColumns && !swapValues) {
                swapColumns(matrix, swap1, swap2);
            } else if (swapValues) {
                swapValues(matrix, swap1, swap2);
            }

            currentDiagSum = calculateDiagonalSum(matrix);
        }

        return generateResult(matrix, currentDiagSum, K);
    }

    private static void initializeMatrix(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][N - 1 - j] = N - ((j + i) % N);
            }
        }
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int calculateRowSwapIncrement(int[][] matrix, int row1, int row2) {
        int oldSum = matrix[row1][row1] + matrix[row2][row2];
        int newSum = matrix[row2][row1] + matrix[row1][row2];
        return newSum - oldSum;
    }

    private static int calculateColumnSwapIncrement(int[][] matrix, int col1, int col2) {
        int oldSum = matrix[col1][col1] + matrix[col2][col2];
        int newSum = matrix[col1][col2] + matrix[col2][col1];
        return newSum - oldSum;
    }

    private static int calculateValueSwapIncrement(int[][] matrix, int val1, int val2) {
        int oldSum = calculateDiagonalSum(matrix);
        int newSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] == val1) {
                newSum += val2;
            } else if (matrix[i][i] == val2) {
                newSum += val1;
            } else {
                newSum += matrix[i][i];
            }
        }
        return newSum - oldSum;
    }

    private static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    private static void swapColumns(int[][] matrix, int col1, int col2) {
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }
    }

    private static void swapValues(int[][] matrix, int val1, int val2) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == val1) {
                    matrix[i][j] = val2;
                } else if (matrix[i][j] == val2) {
                    matrix[i][j] = val1;
                }
            }
        }
    }

    private static String generateResult(int[][] matrix, int currentDiagSum, int targetSum) {
        StringBuilder result = new StringBuilder();
        if (currentDiagSum == targetSum) {
            result.append("POSSIBLE\n");
            for (int[] row : matrix) {
                for (int j = 0; j < row.length; j++) {
                    result.append(row[j]).append(j == row.length - 1 ? "" : " ");
                }
                result.append("\n");
            }
        } else {
            result.append("IMPOSSIBLE");
        }
        return result.toString();
    }
}