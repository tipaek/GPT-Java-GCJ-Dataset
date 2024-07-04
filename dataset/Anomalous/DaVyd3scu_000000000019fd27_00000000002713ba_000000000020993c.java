import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[] traceArray = new int[testCases];
        int[] rowRepeats = new int[testCases];
        int[] colRepeats = new int[testCases];

        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int[] repeats = findRepeatingRowsAndColumns(matrix, matrixSize);
            traceArray[t] = trace;
            rowRepeats[t] = repeats[0];
            colRepeats[t] = repeats[1];
        }

        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + traceArray[t] + " " + rowRepeats[t] + " " + colRepeats[t]);
        }
    }

    static int[] findRepeatingRowsAndColumns(int[][] matrix, int size) {
        int repeatRows = 0;
        int repeatCols = 0;

        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                repeatRows++;
            }
            if (hasDuplicates(getColumn(matrix, i))) {
                repeatCols++;
            }
        }

        return new int[]{repeatRows, repeatCols};
    }

    static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}