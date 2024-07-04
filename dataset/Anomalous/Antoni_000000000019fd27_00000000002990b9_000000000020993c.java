import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        processCodeJam();
    }

    public static void processCodeJam() throws Exception {
        String inputPath = "G:\\dev\\input.txt";
        String outputPath = "G:\\dev\\output.txt";
        
        try (Scanner scanner = new Scanner(new File(inputPath));
             FileWriter writer = new FileWriter(new File(outputPath))) {
             
            int testCases = Integer.parseInt(scanner.nextLine());
            
            for (int i = 0; i < testCases; i++) {
                int size = Integer.parseInt(scanner.nextLine());
                int[][] matrix = new int[size][size];
                
                for (int row = 0; row < size; row++) {
                    String[] line = scanner.nextLine().split(" ");
                    for (int col = 0; col < size; col++) {
                        matrix[row][col] = Integer.parseInt(line[col]);
                    }
                }
                
                writeResult(matrix, size, writer, i + 1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeResult(int[][] matrix, int size, FileWriter writer, int caseNumber) throws IOException {
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
            if (hasDuplicates(matrix[i])) {
                count++;
            }
        }
        return count;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int count = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] columnData = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                columnData[row] = matrix[row][col];
            }
            if (hasDuplicates(columnData)) {
                count++;
            }
        }
        return count;
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