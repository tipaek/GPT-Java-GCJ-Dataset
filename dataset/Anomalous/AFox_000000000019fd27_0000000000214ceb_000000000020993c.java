import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, matrixSize);
            int rowRepeats = countRowRepeats(matrix, matrixSize);
            int colRepeats = countColRepeats(matrix, matrixSize);

            System.out.printf("Case #%d: %d %d %d\n", i, trace, rowRepeats, colRepeats);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowRepeats(int[][] matrix, int size) {
        int repeatCount = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[i][j])) {
                    repeatCount++;
                    break;
                }
            }
        }
        return repeatCount;
    }

    private static int countColRepeats(int[][] matrix, int size) {
        int repeatCount = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[j][i])) {
                    repeatCount++;
                    break;
                }
            }
        }
        return repeatCount;
    }
}