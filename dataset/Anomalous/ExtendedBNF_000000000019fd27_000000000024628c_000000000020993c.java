import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        
        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            System.out.print("Case #" + (testIndex + 1) + ": ");
            processTestCase(scanner);
        }
    }

    public static void processTestCase(Scanner scanner) {
        int trace = 0, rowRepeats = 0, columnRepeats = 0;
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
            for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                matrix[rowIndex][colIndex] = scanner.nextInt();
                if (rowIndex == colIndex) {
                    trace += matrix[rowIndex][colIndex];
                }
            }
        }

        for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                rowSet.add(matrix[rowIndex][colIndex]);
            }
            if (rowSet.size() != matrixSize) {
                rowRepeats++;
            }
        }

        for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                columnSet.add(matrix[rowIndex][colIndex]);
            }
            if (columnSet.size() != matrixSize) {
                columnRepeats++;
            }
        }

        System.out.println(trace + " " + rowRepeats + " " + columnRepeats);
    }
}