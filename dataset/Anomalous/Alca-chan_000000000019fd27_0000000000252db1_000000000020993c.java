package codejam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();

        if (numOfCases <= 0) {
            return;
        }

        StringBuilder output = new StringBuilder();

        for (int caseIndex = 1; caseIndex <= numOfCases; caseIndex++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> columnSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                boolean columnHasDuplicate = false;

                for (int j = 0; j < size; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                    if (!columnSet.add(matrix[j][i])) {
                        columnHasDuplicate = true;
                    }
                }

                if (rowHasDuplicate) {
                    duplicateRows++;
                }
                if (columnHasDuplicate) {
                    duplicateColumns++;
                }
            }

            output.append("Case #")
                  .append(caseIndex)
                  .append(": ")
                  .append(trace)
                  .append(" ")
                  .append(duplicateRows)
                  .append(" ")
                  .append(duplicateColumns)
                  .append("\n");
        }

        System.out.print(output.toString());
    }
}