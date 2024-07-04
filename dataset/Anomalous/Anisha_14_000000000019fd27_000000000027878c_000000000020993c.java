import java.util.Scanner;

class Ques {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int t = 1; t <= testCaseCount; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0;

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }

            int maxRowCount = 0;
            int maxColCount = 0;

            for (int i = 0; i < matrixSize; i++) {
                boolean[] rowSeen = new boolean[matrixSize + 1];
                boolean[] colSeen = new boolean[matrixSize + 1];
                int rowCount = 0;
                int colCount = 0;

                for (int j = 0; j < matrixSize; j++) {
                    if (!rowSeen[matrix[i][j]]) {
                        rowSeen[matrix[i][j]] = true;
                        rowCount++;
                    }
                    if (!colSeen[matrix[j][i]]) {
                        colSeen[matrix[j][i]] = true;
                        colCount++;
                    }
                }

                maxRowCount = Math.max(maxRowCount, matrixSize - rowCount);
                maxColCount = Math.max(maxColCount, matrixSize - colCount);
            }

            System.out.printf("Case #%d: %d %d %d%n", t, diagonalSum, maxRowCount, maxColCount);
        }
    }
}