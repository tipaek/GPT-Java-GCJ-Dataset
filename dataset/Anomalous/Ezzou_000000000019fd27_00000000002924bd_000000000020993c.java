import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        executeAlgorithm();
    }
    
    static void executeAlgorithm() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            HashSet<Integer>[] columnSets = new HashSet[matrixSize];
            int trace = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            for (int i = 0; i < matrixSize; i++) {
                columnSets[i] = new HashSet<>();
            }

            for (int row = 0; row < matrixSize; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    if (row == col) {
                        trace += value;
                    }

                    if (!rowSet.add(value) && !rowHasDuplicate) {
                        rowHasDuplicate = true;
                        repeatedRows++;
                    }

                    if (columnSets[col] != null && !columnSets[col].add(value)) {
                        repeatedCols++;
                        columnSets[col] = null;
                    }
                }
            }
            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, repeatedRows, repeatedCols);
        }
        scanner.close();
    }
}