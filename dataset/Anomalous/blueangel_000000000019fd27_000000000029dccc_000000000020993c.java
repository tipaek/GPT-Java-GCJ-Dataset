public class Solution {
    public static void printMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void processMatrix(int[][] matrix, int size) {
        int trace = 0;
        int countRowRepeat = 0;
        int countColumnRepeat = 0;

        for (int i = 0; i < size; i++) {
            boolean rowRepeat = false;
            boolean columnRepeat = false;

            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                // Check for repeated elements in the row
                if (!rowRepeat) {
                    int num = matrix[i][j];
                    for (int k = j + 1; k < size; k++) {
                        if (num == matrix[i][k]) {
                            rowRepeat = true;
                            break;
                        }
                    }
                }

                // Check for repeated elements in the column
                if (!columnRepeat) {
                    int num1 = matrix[j][i];
                    for (int k = j + 1; k < size; k++) {
                        if (num1 == matrix[k][i]) {
                            columnRepeat = true;
                            break;
                        }
                    }
                }
            }

            if (rowRepeat) countRowRepeat++;
            if (columnRepeat) countColumnRepeat++;
        }

        System.out.print(trace + " " + countRowRepeat + " " + countColumnRepeat);
    }

    public static void main(String[] args) {
        int testCases = Integer.parseInt(args[0]);
        int index = 1;

        for (int i = 0; i < testCases; i++) {
            int matrixSize = Integer.parseInt(args[index++]);
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = Integer.parseInt(args[index++]);
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            processMatrix(matrix, matrixSize);
            System.out.println();
        }
    }
}