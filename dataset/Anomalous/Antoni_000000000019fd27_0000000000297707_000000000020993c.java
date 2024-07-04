import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            codeJam();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void codeJam() {
        String inputFilePath = "G:\\dev\\input.txt";
        String outputFilePath = "G:\\dev\\output.txt";

        try (Scanner scanner = new Scanner(new File(inputFilePath));
             FileWriter writer = new FileWriter(new File(outputFilePath))) {

            int testCases = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < testCases; i++) {
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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processMatrix(int[][] matrix, int size, FileWriter writer, int caseNumber) throws IOException {
        writer.write(String.format("Case #%d: %d %d %d%n", caseNumber, calculateDiagonalSum(matrix), countDuplicateRows(matrix), countDuplicateColumns(matrix)));
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            if (containsDuplicates(row)) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] column = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }
            if (containsDuplicates(column)) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    private static boolean containsDuplicates(int[] array) {
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