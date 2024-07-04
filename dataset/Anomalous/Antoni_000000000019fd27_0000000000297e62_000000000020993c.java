import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MatrixProcessor {

    public static void main(String[] args) throws Exception {
        processMatrices();
    }

    public static void processMatrices() throws Exception {
        String inputFilePath = "G:\\dev\\input.txt";
        String outputFilePath = "G:\\dev\\output.txt";

        try {
            File inputFile = new File(inputFilePath);
            File outputFile = new File(outputFilePath);
            Scanner scanner = new Scanner(inputFile);
            FileWriter writer = new FileWriter(outputFile);
            int numberOfCases = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < numberOfCases; i++) {
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

            scanner.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void processMatrix(int[][] matrix, int size, FileWriter writer, int caseNumber) throws IOException {
        writer.write("Case #" + caseNumber + ": " + calculateDiagonalSum(matrix) + " " + countDuplicateRows(matrix) + " " + countDuplicateColumns(matrix) + "\n");
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean hasDuplicates = hasDuplicates(matrix[i]);
            if (hasDuplicates) {
                count++;
            }
        }
        return count;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] column = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }
            boolean hasDuplicates = hasDuplicates(column);
            if (hasDuplicates) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}