import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        codeJam();
    }

    public static void codeJam() throws Exception {
        String inputPath = "G:\\dev\\input.txt";
        String outputPath = "G:\\dev\\output.txt";

        try (Scanner scanner = new Scanner(new File(inputPath));
             FileWriter writer = new FileWriter(new File(outputPath))) {

            int cases = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < cases; i++) {
                int size = Integer.parseInt(scanner.nextLine());
                int[][] matrix = new int[size][size];

                for (int j = 0; j < size; j++) {
                    String[] line = scanner.nextLine().split(" ");
                    for (int k = 0; k < size; k++) {
                        matrix[j][k] = Integer.parseInt(line[k]);
                    }
                }

                processMatrix(matrix, size, writer, i + 1);
            }
        }
    }

    private static void processMatrix(int[][] matrix, int size, FileWriter writer, int caseNumber) throws IOException {
        int diagonalSum = calculateDiagonal(matrix);
        int lineDuplicates = countLineDuplicates(matrix);
        int columnDuplicates = countColumnDuplicates(matrix);

        String result = String.format("Case #%d: %d %d %d%n", caseNumber, diagonalSum, lineDuplicates, columnDuplicates);
        writer.write(result);
        System.out.print(result);
    }

    private static int calculateDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countLineDuplicates(int[][] matrix) {
        int duplicatesCount = 0;

        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicatesCount++;
            }
        }

        return duplicatesCount;
    }

    private static int countColumnDuplicates(int[][] matrix) {
        int duplicatesCount = 0;
        int size = matrix.length;

        for (int col = 0; col < size; col++) {
            int[] column = new int[size];
            for (int row = 0; row < size; row++) {
                column[row] = matrix[row][col];
            }

            if (hasDuplicates(column)) {
                duplicatesCount++;
            }
        }

        return duplicatesCount;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int num : array) {
            if (seen[num]) {
                return true;
            }
            seen[num] = true;
        }
        return false;
    }
}