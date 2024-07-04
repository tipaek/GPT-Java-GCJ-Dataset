package questions;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            Map<Integer, Set<Integer>> columnMap = new HashMap<>();
            int duplicateRowCount = 0;
            int duplicateColumnCount = 0;
            int traceSum = 0;

            for (int row = 0; row < matrixSize; row++) {
                String[] elements = scanner.nextLine().split(" ");
                Set<Integer> rowSet = new HashSet<>();
                boolean hasRowDuplicates = false;

                for (int col = 0; col < matrixSize; col++) {
                    int value = Integer.parseInt(elements[col]);

                    if (row == col) {
                        traceSum += value;
                    }

                    if (!hasRowDuplicates && rowSet.contains(value)) {
                        hasRowDuplicates = true;
                        duplicateRowCount++;
                    }
                    rowSet.add(value);

                    columnMap.computeIfAbsent(col, k -> new HashSet<>()).add(value);
                }
            }

            for (int col = 0; col < matrixSize; col++) {
                if (columnMap.get(col).size() != matrixSize) {
                    duplicateColumnCount++;
                }
            }

            System.out.println("Case #" + testCase + ": " + traceSum + " " + duplicateRowCount + " " + duplicateColumnCount);
        }
    }
}