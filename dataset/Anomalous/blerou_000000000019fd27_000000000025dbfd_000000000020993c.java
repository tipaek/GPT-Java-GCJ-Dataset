import java.util.Scanner;
import java.util.HashSet;

class MatrixAnalysis {

    static String analyzeMatrix(int n, int[][] matrix) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];

            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();

            for (int j = 0; j < n; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }

            if (rowSet.size() != n) {
                rowDuplicates++;
            }
            if (colSet.size() != n) {
                colDuplicates++;
            }
        }

        return String.format("%d %d %d", trace, rowDuplicates, colDuplicates);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            String result = analyzeMatrix(matrixSize, matrix);
            System.out.printf("Case #%d: %s\n", caseNumber, result);
        }

        scanner.close();
    }
}