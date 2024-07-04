import java.util.*;
import java.io.IOException;

class Solution {
    public static void main(String[] args) throws IOException {
        executeAlgorithm();
    }
    
    static void executeAlgorithm() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase < testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            HashSet<Integer>[] columnSets = new HashSet[matrixSize];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < matrixSize; i++) {
                columnSets[i] = new HashSet<>();
            }

            for (int row = 0; row < matrixSize; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    if (row == col) trace += value;

                    if (rowSet.contains(value) && !rowHasDuplicate) {
                        rowHasDuplicate = true;
                        duplicateRows++;
                    } else {
                        rowSet.add(value);
                    }

                    HashSet<Integer> colSet = columnSets[col];
                    if (colSet != null && colSet.contains(value)) {
                        duplicateCols++;
                        columnSets[col] = null;
                    } else if (colSet != null) {
                        colSet.add(value);
                    }
                }
            }
            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, duplicateRows, duplicateCols);
        }
    }
}