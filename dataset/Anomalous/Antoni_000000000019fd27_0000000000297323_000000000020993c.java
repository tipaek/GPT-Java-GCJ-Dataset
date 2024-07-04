import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        processCodeJam();
    }

    public static void processCodeJam() throws Exception {
        String inputPath = "G:\\dev\\input.txt";
        String outputPath = "G:\\dev\\output.txt";

        try (Scanner scanner = new Scanner(new File(inputPath));
             FileWriter writer = new FileWriter(new File(outputPath))) {

            int numCases = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < numCases; i++) {
                int size = Integer.parseInt(scanner.nextLine());
                int[][] matrix = new int[size][size];

                for (int j = 0; j < size; j++) {
                    String[] line = scanner.nextLine().split(" ");
                    for (int k = 0; k < size; k++) {
                        matrix[j][k] = Integer.parseInt(line[k]);
                    }
                }

                writeResults(matrix, size, writer, i + 1);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeResults(int[][] matrix, int size, FileWriter writer, int caseNumber) throws IOException {
        writer.write(String.format("Case #%d: %d %d %d%n", caseNumber, calculateDiagonalSum(matrix), calculateDuplicateRows(matrix), calculateDuplicateColumns(matrix)));
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int calculateDuplicateRows(int[][] matrix) {
        int duplicatesCount = 0;

        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicatesCount++;
            }
        }

        return duplicatesCount;
    }

    private static int calculateDuplicateColumns(int[][] matrix) {
        int duplicatesCount = 0;

        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
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
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}