import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                String[] sRowItems = scanner.nextLine().split(" ");
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(sRowItems[j]);
                }
            }

            result.append("Case #").append(testCase).append(":").append(getResult(matrix)).append("\n");
        }

        System.out.print(result.toString());
    }

    public static String getResult(int[][] matrix) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> rowVals = new HashSet<>();
            boolean rowHasDuplicate = false;

            for (int j = 0; j < matrix[0].length; j++) {
                int value = matrix[i][j];
                if (i == j) {
                    trace += value;
                }
                if (!rowVals.add(value) && !rowHasDuplicate) {
                    rowHasDuplicate = true;
                    rowDuplicates++;
                }
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            HashSet<Integer> colVals = new HashSet<>();
            for (int i = 0; i < matrix.length; i++) {
                int value = matrix[i][j];
                if (!colVals.add(value)) {
                    colDuplicates++;
                    break;
                }
            }
        }

        return " " + trace + " " + rowDuplicates + " " + colDuplicates;
    }
}