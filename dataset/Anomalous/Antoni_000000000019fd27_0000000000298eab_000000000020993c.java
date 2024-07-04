import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        try {
            codeJam();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void codeJam() {
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processMatrix(int[][] matrix, int size, FileWriter writer, int caseNumber) throws IOException {
        int diagonalSum = calculateDiagonalSum(matrix);
        int rowDuplicates = countDuplicateRows(matrix);
        int columnDuplicates = countDuplicateColumns(matrix);

        String result = String.format("Case #%d: %d %d %d%n", caseNumber, diagonalSum, rowDuplicates, columnDuplicates);
        System.out.println(result);
        writer.write(result);
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicates = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicates++;
            }
        }
        return duplicates;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicates = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                duplicates++;
            }
        }
        return duplicates;
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