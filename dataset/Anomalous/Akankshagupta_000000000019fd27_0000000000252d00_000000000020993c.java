import java.util.Scanner;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 0; caseNumber < cases; caseNumber++) {
            int arraySize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[arraySize][arraySize];

            for (int i = 0; i < arraySize; i++) {
                String[] values = scanner.nextLine().split(" ");
                for (int j = 0; j < arraySize; j++) {
                    matrix[i][j] = Integer.parseInt(values[j]);
                }
            }

            int trace = 0;
            int rowCount = 0;
            int columnCount = 0;

            for (int i = 0; i < arraySize; i++) {
                HashMap<Integer, Boolean> rowMap = new HashMap<>();
                boolean rowDuplicate = false;

                for (int j = 0; j < arraySize; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowDuplicate && rowMap.get(matrix[i][j]) != null) {
                        rowCount++;
                        rowDuplicate = true;
                    } else {
                        rowMap.put(matrix[i][j], true);
                    }
                }
            }

            for (int j = 0; j < arraySize; j++) {
                HashMap<Integer, Boolean> columnMap = new HashMap<>();
                for (int i = 0; i < arraySize; i++) {
                    if (columnMap.get(matrix[i][j]) != null) {
                        columnCount++;
                        break;
                    } else {
                        columnMap.put(matrix[i][j], true);
                    }
                }
            }

            System.out.println("Case #" + (caseNumber + 1) + ": " + trace + " " + rowCount + " " + columnCount);
        }
    }
}