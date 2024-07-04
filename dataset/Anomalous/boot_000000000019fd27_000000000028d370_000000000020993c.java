import java.util.Scanner;

public class MatrixSolution {

    private final Scanner scanner;
    private int[][] matrix;
    private int matrixSize;

    public MatrixSolution(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            MatrixSolution solution = new MatrixSolution(scanner);
            int testCases = scanner.nextInt();

            for (int tc = 1; tc <= testCases; tc++) {
                System.out.printf("Case #%d:", tc);
                solution.readInput();
                solution.computeSolution();
                System.out.println();
            }
        }
    }

    private void readInput() {
        matrixSize = scanner.nextInt();
        matrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private void computeSolution() {
        int[][] rowCount = new int[matrixSize][matrixSize + 1];
        int[][] colCount = new int[matrixSize][matrixSize + 1];

        boolean[] rowRepeats = new boolean[matrixSize];
        boolean[] colRepeats = new boolean[matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (++rowCount[i][matrix[i][j]] > 1) {
                    rowRepeats[i] = true;
                }
                if (++colCount[j][matrix[i][j]] > 1) {
                    colRepeats[j] = true;
                }
            }
        }

        int trace = 0;
        int repeatedRows = 0;
        int repeatedCols = 0;

        for (int i = 0; i < matrixSize; i++) {
            if (rowRepeats[i]) {
                repeatedRows++;
            }
            if (colRepeats[i]) {
                repeatedCols++;
            }
            trace += matrix[i][i];
        }

        System.out.printf(" %d %d %d", trace, repeatedRows, repeatedCols);
    }
}