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
            boolean[] rowCheck = new boolean[size + 1];
            boolean[] columnCheck = new boolean[size + 1];
            
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                if (!rowRepeat) {
                    if (rowCheck[matrix[i][j]]) {
                        rowRepeat = true;
                    } else {
                        rowCheck[matrix[i][j]] = true;
                    }
                }

                if (!columnRepeat) {
                    if (columnCheck[matrix[j][i]]) {
                        columnRepeat = true;
                    } else {
                        columnCheck[matrix[j][i]] = true;
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