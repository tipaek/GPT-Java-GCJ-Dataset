import java.util.Scanner;
import java.io.PrintWriter;

public class Vestigium {
    private static int sentinel = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = scanner.nextInt();
        int[] seenNumbers = new int[101];

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, matrixSize);
            int rowRepetitions = calculateRowRepetitions(matrix, matrixSize, seenNumbers);
            int colRepetitions = calculateColRepetitions(matrix, matrixSize, seenNumbers);

            writer.printf("Case #%d: %d %d %d%n", testCase, trace, rowRepetitions, colRepetitions);
        }

        writer.flush();
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int calculateRowRepetitions(int[][] matrix, int size, int[] seenNumbers) {
        int rowRepetitions = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (seenNumbers[matrix[i][j]] == sentinel) {
                    rowRepetitions++;
                    break;
                }
                seenNumbers[matrix[i][j]] = sentinel;
            }
            sentinel++;
        }
        return rowRepetitions;
    }

    private static int calculateColRepetitions(int[][] matrix, int size, int[] seenNumbers) {
        int colRepetitions = 0;
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                if (seenNumbers[matrix[i][j]] == sentinel) {
                    colRepetitions++;
                    break;
                }
                seenNumbers[matrix[i][j]] = sentinel;
            }
            sentinel++;
        }
        return colRepetitions;
    }
}