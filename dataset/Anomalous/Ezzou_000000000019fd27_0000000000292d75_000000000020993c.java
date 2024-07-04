import java.util.*;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        runAlgorithm();
    }

    static void runAlgorithm() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            Set<Integer>[] columnSets = new HashSet[matrixSize];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int i = 0; i < matrixSize; i++) {
                columnSets[i] = new HashSet<>();
            }

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicates = false;

                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    if (row == col) {
                        trace += value;
                    }

                    if (!rowHasDuplicates && !rowSet.add(value)) {
                        rowHasDuplicates = true;
                        duplicateRows++;
                    }

                    if (columnSets[col] != null) {
                        if (!columnSets[col].add(value)) {
                            duplicateColumns++;
                            columnSets[col] = null;
                        }
                    }
                }
            }
            System.out.printf("Case #%d: %d %d %d%n", t, trace, duplicateRows, duplicateColumns);
        }
    }
}