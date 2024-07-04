import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int trace = 0, rowDuplicates = 0, columnDuplicates = 0;

            List<Set<Integer>> columnSets = new ArrayList<>(matrixSize);
            for (int i = 0; i < matrixSize; i++) {
                columnSets.add(new HashSet<>());
            }

            boolean[] columnHasDuplicates = new boolean[matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();

                    if (row == col) {
                        trace += value;
                    }

                    if (!rowSet.add(value)) {
                        rowHasDuplicate = true;
                    }

                    if (!columnSets.get(col).add(value)) {
                        columnHasDuplicates[col] = true;
                    }
                }

                if (rowHasDuplicate) {
                    rowDuplicates++;
                }
            }

            for (boolean hasDuplicate : columnHasDuplicates) {
                if (hasDuplicate) {
                    columnDuplicates++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}