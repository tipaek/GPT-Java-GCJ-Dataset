import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int duplicateRows = 0;
            Map<Integer, Integer>[] columnCounts = new Map[matrixSize];

            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                Map<Integer, Integer> rowCounts = new HashMap<>();

                for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                    int value = scanner.nextInt();
                    if (rowIndex == colIndex) {
                        trace += value;
                    }

                    if (columnCounts[colIndex] == null) {
                        columnCounts[colIndex] = new HashMap<>();
                    }
                    columnCounts[colIndex].put(value, columnCounts[colIndex].getOrDefault(value, 0) + 1);
                    rowCounts.put(value, rowCounts.getOrDefault(value, 0) + 1);
                }

                for (int key : rowCounts.keySet()) {
                    if (rowCounts.get(key) > 1) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            int duplicateColumns = 0;
            for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                for (int key : columnCounts[colIndex].keySet()) {
                    if (columnCounts[colIndex].get(key) > 1) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseIndex + 1, trace, duplicateRows, duplicateColumns);
        }
    }
}