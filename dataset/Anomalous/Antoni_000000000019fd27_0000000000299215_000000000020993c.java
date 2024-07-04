import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        codeJam();
    }

    public static void codeJam() throws Exception {
        String inputFilePath = "G:\\dev\\input.txt";
        String outputFilePath = "G:\\dev\\output.txt";
        
        try (Scanner scanner = new Scanner(new File(inputFilePath));
             FileWriter writer = new FileWriter(new File(outputFilePath))) {
             
            int caseCount = Integer.parseInt(scanner.nextLine());
            
            for (int i = 0; i < caseCount; i++) {
                int matrixSize = Integer.parseInt(scanner.nextLine());
                int[][] matrix = new int[matrixSize][matrixSize];
                
                for (int j = 0; j < matrixSize; j++) {
                    String[] line = scanner.nextLine().split(" ");
                    for (int k = 0; k < matrixSize; k++) {
                        matrix[j][k] = Integer.parseInt(line[k]);
                    }
                }
                
                processMatrix(matrix, matrixSize, writer, i + 1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void processMatrix(int[][] matrix, int size, FileWriter writer, int caseNumber) throws IOException {
        int diagonalSum = calculateDiagonalSum(matrix);
        int duplicateLines = countDuplicateLines(matrix);
        int duplicateColumns = countDuplicateColumns(matrix);
        
        writer.write("Case #" + caseNumber + ": " + diagonalSum + " " + duplicateLines + " " + duplicateColumns + "\n");
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicateLines(int[][] matrix) {
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
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
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