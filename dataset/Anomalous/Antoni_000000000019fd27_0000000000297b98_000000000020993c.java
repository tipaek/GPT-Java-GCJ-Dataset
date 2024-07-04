import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) throws Exception {
        processCodeJam();
    }

    public static void processCodeJam() throws Exception {
        String inputPath = "G:\\dev\\input.txt";
        String outputPath = "G:\\dev\\output.txt";
        
        try (Scanner scanner = new Scanner(new File(inputPath));
             FileWriter writer = new FileWriter(new File(outputPath))) {
            
            int numCases = Integer.parseInt(scanner.nextLine());

            for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
                int size = Integer.parseInt(scanner.nextLine());
                int[][] matrix = new int[size][size];

                for (int rowIndex = 0; rowIndex < size; rowIndex++) {
                    String[] rowValues = scanner.nextLine().split(" ");
                    for (int colIndex = 0; colIndex < size; colIndex++) {
                        matrix[rowIndex][colIndex] = Integer.parseInt(rowValues[colIndex]);
                    }
                }

                processMatrix(matrix, size, writer, caseIndex + 1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void processMatrix(int[][] matrix, int size, FileWriter writer, int caseNumber) throws IOException {
        writer.write("Case #" + caseNumber + ": " + getDiagonalSum(matrix) + " " + countDuplicateRows(matrix) + " " + countDuplicateColumns(matrix) + "\n");
    }

    private static int getDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateCount = 0;
        for (int colIndex = 0; colIndex < matrix.length; colIndex++) {
            int[] column = new int[matrix.length];
            for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
                column[rowIndex] = matrix[rowIndex][colIndex];
            }
            if (hasDuplicates(column)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
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