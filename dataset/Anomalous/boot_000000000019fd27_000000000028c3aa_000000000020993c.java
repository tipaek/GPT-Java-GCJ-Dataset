import java.util.Scanner;

public class Solution {

    private final Scanner scanner;
    private int[][] matrix;
    private int matrixSize;

    public Solution(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Solution solution = new Solution(scanner);
            int testCases = scanner.nextInt();

            for (int tc = 1; tc <= testCases; tc++) {
                System.out.print("Case #" + tc);
                solution.processInput();
                solution.solve();
                System.out.println();
            }
        }
    }

    private void processInput() {
        matrixSize = scanner.nextInt();
        matrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private void solve() {
        int[][] rowOccurrences = new int[matrixSize][matrixSize + 1];
        int[][] colOccurrences = new int[matrixSize][matrixSize + 1];
        boolean[] rowHasRepeats = new boolean[matrixSize];
        boolean[] colHasRepeats = new boolean[matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (++rowOccurrences[i][matrix[i][j]] > 1) {
                    rowHasRepeats[i] = true;
                }
                if (++colOccurrences[j][matrix[i][j]] > 1) {
                    colHasRepeats[j] = true;
                }
            }
        }

        int trace = 0;
        int rowsWithRepeats = 0;
        int colsWithRepeats = 0;

        for (int i = 0; i < matrixSize; i++) {
            if (rowHasRepeats[i]) {
                rowsWithRepeats++;
            }
            if (colHasRepeats[i]) {
                colsWithRepeats++;
            }
            trace += matrix[i][i];
        }

        System.out.printf(" %d %d %d", trace, rowsWithRepeats, colsWithRepeats);
    }
}