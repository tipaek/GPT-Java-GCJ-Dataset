import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    private static String process(Scanner scanner) {
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        long trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < matrixSize; i++) {
            boolean[] rowCheck = new boolean[matrixSize + 1];
            boolean hasRowDuplicate = false;
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
                if (rowCheck[matrix[i][j]]) {
                    hasRowDuplicate = true;
                }
                rowCheck[matrix[i][j]] = true;
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
            if (hasRowDuplicate) {
                rowDuplicates++;
            }
        }

        for (int j = 0; j < matrixSize; j++) {
            boolean[] colCheck = new boolean[matrixSize + 1];
            boolean hasColDuplicate = false;
            for (int i = 0; i < matrixSize; i++) {
                if (colCheck[matrix[i][j]]) {
                    hasColDuplicate = true;
                }
                colCheck[matrix[i][j]] = true;
            }
            if (hasColDuplicate) {
                colDuplicates++;
            }
        }

        return trace + " " + rowDuplicates + " " + colDuplicates;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in.available() > 0 ? System.in :
            new FileInputStream(Thread.currentThread().getStackTrace()[1].getClassName() + ".practice.in"));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.format("Case #%d: %s\n", i, process(scanner));
        }
    }
}