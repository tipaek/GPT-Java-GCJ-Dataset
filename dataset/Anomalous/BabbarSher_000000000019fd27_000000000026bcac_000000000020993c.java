import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VestigiumSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                String[] elements = scanner.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(elements[col]);
                }
            }

            int[] results = analyzeMatrix(matrix, matrixSize);
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, results[0], results[1], results[2]);
        }
    }

    private static int[] analyzeMatrix(int[][] matrix, int size) {
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
            if (hasRepeats(matrix[i])) {
                rowRepeats++;
            }

            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }
            if (hasRepeats(column)) {
                colRepeats++;
            }
        }

        return new int[]{trace, rowRepeats, colRepeats};
    }

    private static boolean hasRepeats(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}