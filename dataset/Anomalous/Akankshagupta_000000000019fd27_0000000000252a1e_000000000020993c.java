import java.util.Scanner;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int arraySize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[arraySize][arraySize];

            for (int row = 0; row < arraySize; row++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int column = 0; column < arraySize; column++) {
                    matrix[row][column] = Integer.parseInt(rowValues[column]);
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int row = 0; row < arraySize; row++) {
                HashMap<Integer, Integer> rowMap = new HashMap<>();
                boolean rowHasDuplicate = false;

                for (int column = 0; column < arraySize; column++) {
                    if (row == column) {
                        trace += matrix[row][column];
                    }

                    if (!rowHasDuplicate && rowMap.containsKey(matrix[row][column])) {
                        duplicateRows++;
                        rowHasDuplicate = true;
                    } else {
                        rowMap.put(matrix[row][column], 1);
                    }
                }
            }

            for (int column = 0; column < arraySize; column++) {
                HashMap<Integer, Integer> columnMap = new HashMap<>();
                boolean columnHasDuplicate = false;

                for (int row = 0; row < arraySize; row++) {
                    if (!columnHasDuplicate && columnMap.containsKey(matrix[row][column])) {
                        duplicateColumns++;
                        columnHasDuplicate = true;
                    } else {
                        columnMap.put(matrix[row][column], 1);
                    }
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}