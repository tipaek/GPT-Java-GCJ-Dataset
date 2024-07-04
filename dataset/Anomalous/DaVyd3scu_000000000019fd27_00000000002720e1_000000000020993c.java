import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[] traces = new int[testCases];
        int[] repeatedRows = new int[testCases];
        int[] repeatedColumns = new int[testCases];

        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            int[] result = countRepeatingRowsAndColumns(matrix, matrixSize);
            traces[t] = trace;
            repeatedRows[t] = result[0];
            repeatedColumns[t] = result[1];
        }

        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + traces[t] + " " + repeatedRows[t] + " " + repeatedColumns[t]);
        }
    }

    static int[] countRepeatingRowsAndColumns(int[][] matrix, int size) {
        int rowCount = 0;
        int colCount = 0;

        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                rowCount++;
            }

            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                colCount++;
            }
        }

        return new int[]{rowCount, colCount};
    }

    static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}