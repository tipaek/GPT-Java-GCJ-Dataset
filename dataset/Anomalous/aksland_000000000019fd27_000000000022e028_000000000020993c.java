import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            Map<Integer, Integer>[] columnMaps = new Map[matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                Map<Integer, Integer> rowMap = new HashMap<>();
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    if (row == col) {
                        trace += value;
                    }

                    if (columnMaps[col] == null) {
                        columnMaps[col] = new HashMap<>();
                    }
                    columnMaps[col].put(value, columnMaps[col].getOrDefault(value, 0) + 1);
                    rowMap.put(value, rowMap.getOrDefault(value, 0) + 1);
                }

                if (rowMap.values().stream().anyMatch(count -> count > 1)) {
                    duplicateRows++;
                }
            }

            for (Map<Integer, Integer> columnMap : columnMaps) {
                if (columnMap.values().stream().anyMatch(count -> count > 1)) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }
}