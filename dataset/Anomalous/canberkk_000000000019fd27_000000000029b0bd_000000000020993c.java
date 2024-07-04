import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            StringBuilder result = new StringBuilder("Case #").append(caseNumber).append(": ");

            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int[] counts;
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < matrixSize; i++) {
                counts = new int[matrixSize];
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    counts[value - 1]++;
                    if (i == j) {
                        trace += value;
                    }
                }
                if (hasDuplicates(counts)) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < matrixSize; j++) {
                counts = new int[matrixSize];
                for (int i = 0; i < matrixSize; i++) {
                    counts[matrix[i][j] - 1]++;
                }
                if (hasDuplicates(counts)) {
                    duplicateCols++;
                }
            }

            writer.println(result.append(trace).append(" ").append(duplicateRows).append(" ").append(duplicateCols));
        }

        scanner.close();
        writer.close();
    }

    private static boolean hasDuplicates(int[] counts) {
        for (int count : counts) {
            if (count == 0) {
                return true;
            }
        }
        return false;
    }
}