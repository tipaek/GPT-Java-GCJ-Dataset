import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static class Result {
        int k;
        int r;
        int c;

        @Override
        public String toString() {
            return k + " " + r + " " + c;
        }
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            short testCases = scanner.nextShort();
            for (int i = 0; i < testCases; i++) {
                short matrixSize = scanner.nextShort();
                short[][] matrix = new short[matrixSize][matrixSize];
                for (int row = 0; row < matrixSize; row++) {
                    for (int col = 0; col < matrixSize; col++) {
                        matrix[row][col] = scanner.nextShort();
                    }
                }
                Result result = analyzeMatrix(matrix, matrixSize);
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }

    private static Result analyzeMatrix(short[][] matrix, short size) {
        Result result = new Result();
        result.k = calculateDiagonalSum(matrix, size);
        result.r = countRowRepeats(matrix, size);
        result.c = countColumnRepeats(matrix, size);
        return result;
    }

    private static int countRowRepeats(short[][] matrix, short size) {
        int repeatCount = 0;
        Set<Short> uniqueElements = new HashSet<>();
        for (int row = 0; row < size; row++) {
            uniqueElements.clear();
            for (int col = 0; col < size; col++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    repeatCount++;
                    break;
                }
            }
        }
        return repeatCount;
    }

    private static int countColumnRepeats(short[][] matrix, short size) {
        int repeatCount = 0;
        Set<Short> uniqueElements = new HashSet<>();
        for (int col = 0; col < size; col++) {
            uniqueElements.clear();
            for (int row = 0; row < size; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    repeatCount++;
                    break;
                }
            }
        }
        return repeatCount;
    }

    private static int calculateDiagonalSum(short[][] matrix, short size) {
        int diagonalSum = 0;
        for (int i = 0; i < size; i++) {
            diagonalSum += matrix[i][i];
        }
        return diagonalSum;
    }
}