import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();
        if (numOfCases <= 0) {
            return;
        }

        StringBuilder output = new StringBuilder();
        for (int c = 0; c < numOfCases; c++) {
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

            output.append("Case #").append(c + 1).append(": ").append(trace).append(" ").append(duplicateRows).append(" ").append(duplicateColumns).append("\n");
        }
        System.out.print(output.toString());
    }
}