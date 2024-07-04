import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc;
        if (System.getProperty("user.name").equals("Alexey")) {
            sc = new Scanner(new FileInputStream("input.txt"));
            System.err.println("development mode, reading from file");
        } else {
            sc = new Scanner(System.in);
        }

        int testCases = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= testCases; i++) {
            String[] nk = sc.nextLine().split(" ");
            String result = solveCase(Integer.parseInt(nk[0]), Integer.parseInt(nk[1]));
            System.out.println("Case #" + i + ": " + result);
            System.out.flush();
        }
        sc.close();
    }

    private static String solveCase(int N, int K) {
        StringBuilder result = new StringBuilder();
        int[][] matrix = new int[N][N];
        initializeMatrix(matrix);
        printMatrix(matrix);
        int currentDiagSum = getDiagonalSum(matrix);

        while (currentDiagSum < K) {
            int minIncrement = N * N + N;
            int swap1 = 0, swap2 = 0;
            boolean swapColumns = false, swapValues = false;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    int increment = getRowSwapIncrement(matrix, i, j);
                    if (increment > 0 && increment < minIncrement) {
                        minIncrement = increment;
                        swap1 = i;
                        swap2 = j;
                        swapColumns = false;
                    }
                    increment = getColumnSwapIncrement(matrix, i, j);
                    if (increment > 0 && increment < minIncrement) {
                        minIncrement = increment;
                        swap1 = i;
                        swap2 = j;
                        swapColumns = true;
                    }
                }
            }

            for (int i = 1; i < N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    int increment = getValueSwapIncrement(matrix, i, j);
                    if (increment > 0 && increment < minIncrement) {
                        minIncrement = increment;
                        swap1 = i;
                        swap2 = j;
                        swapValues = true;
                    }
                }
            }

            if (minIncrement == N * N + N) break;

            if (!swapColumns && !swapValues) {
                swapRows(matrix, swap1, swap2);
            } else if (swapColumns) {
                swapColumns(matrix, swap1, swap2);
            } else {
                swapValues(matrix, swap1, swap2);
            }

            printMatrix(matrix);
            currentDiagSum = getDiagonalSum(matrix);
        }

        if (currentDiagSum == K) {
            result.append("POSSIBLE").append(System.lineSeparator());
            for (int[] row : matrix) {
                for (int j = 0; j < row.length; j++) {
                    result.append(row[j]).append(j == row.length - 1 ? "" : " ");
                }
                result.append(System.lineSeparator());
            }
        } else {
            result.append("IMPOSSIBLE");
        }

        if (result.toString().equals("IMPOSSIBLE")) {
            result = new StringBuilder();
            initializeMatrix(matrix);
            currentDiagSum = getDiagonalSum(matrix);

            while (currentDiagSum < K) {
                int minIncrement = N * N + N;
                int swap1 = 0, swap2 = 0;
                boolean swapColumns = false;

                for (int i = 0; i < N - 1; i++) {
                    for (int j = i + 1; j < N; j++) {
                        int increment = getRowSwapIncrement(matrix, i, j);
                        if (increment > 0 && increment <= minIncrement) {
                            minIncrement = increment;
                            swap1 = i;
                            swap2 = j;
                            swapColumns = false;
                        }
                    }
                }

                if (minIncrement == N * N + N) break;

                if (!swapColumns) {
                    swapRows(matrix, swap1, swap2);
                } else {
                    swapColumns(matrix, swap1, swap2);
                }

                printMatrix(matrix);
                currentDiagSum = getDiagonalSum(matrix);
            }

            if (currentDiagSum == K) {
                result.append("POSSIBLE").append(System.lineSeparator());
                for (int[] row : matrix) {
                    for (int j = 0; j < row.length; j++) {
                        result.append(row[j]).append(j == row.length - 1 ? "" : " ");
                    }
                    result.append(System.lineSeparator());
                }
            } else {
                result.append("IMPOSSIBLE");
            }
        }

        return result.toString();
    }

    private static void swapValues(int[][] matrix, int val1, int val2) {
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                if (row[j] == val1) {
                    row[j] = val2;
                } else if (row[j] == val2) {
                    row[j] = val1;
                }
            }
        }
    }

    private static int getValueSwapIncrement(int[][] matrix, int val1, int val2) {
        int originalSum = getDiagonalSum(matrix);
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

        return newSum - originalSum;
    }

    private static void swapColumns(int[][] matrix, int col1, int col2) {
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }
    }

    private static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    private static int getDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int getRowSwapIncrement(int[][] matrix, int row1, int row2) {
        int oldSum = matrix[row1][row1] + matrix[row2][row2];
        int newSum = matrix[row2][row1] + matrix[row1][row2];
        return newSum - oldSum;
    }

    private static int getColumnSwapIncrement(int[][] matrix, int col1, int col2) {
        int oldSum = matrix[col1][col1] + matrix[col2][col2];
        int newSum = matrix[col1][col2] + matrix[col2][col1];
        return newSum - oldSum;
    }

    private static void initializeMatrix(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][N - 1 - j] = N - ((j + i) % N);
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------------");
    }
}