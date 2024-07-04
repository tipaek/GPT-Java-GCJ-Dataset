import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {
    private static int traceSum = 0, rowRepeats = 0, colRepeats = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            calculateVestigium(matrix, t);
            resetCounters();
        }

        scanner.close();
    }

    private static void calculateVestigium(int[][] matrix, int testCaseNumber) {
        calculateTrace(matrix);
        calculateRepeats(matrix, true);  // Check row repeats
        calculateRepeats(matrix, false); // Check column repeats

        System.out.printf("Case #%d: %d %d %d%n", testCaseNumber + 1, traceSum, rowRepeats, colRepeats);
    }

    private static void calculateTrace(int[][] matrix) {
        traceSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            traceSum += matrix[i][i];
        }
    }

    private static void calculateRepeats(int[][] matrix, boolean checkRows) {
        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                int element = checkRows ? matrix[i][j] : matrix[j][i];
                uniqueElements.add(element);
            }
            if (uniqueElements.size() < matrix.length) {
                if (checkRows) {
                    rowRepeats++;
                } else {
                    colRepeats++;
                }
            }
        }
    }

    private static void resetCounters() {
        traceSum = 0;
        rowRepeats = 0;
        colRepeats = 0;
    }
}