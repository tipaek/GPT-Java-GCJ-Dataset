import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

            int sum = 0;
            int duplicateRow = 0;
            int duplicateColumn = 0;

            for (int i = 0; i < size; i++) {
                Set<Integer> setRow = new HashSet<>();
                Set<Integer> setColumn = new HashSet<>();
                boolean hasDuplicateRow = false;
                boolean hasDuplicateColumn = false;

                for (int j = 0; j < size; j++) {
                    if (i == j) {
                        sum += matrix[i][j];
                    }
                    if (!setRow.add(matrix[i][j])) {
                        hasDuplicateRow = true;
                    }
                    if (!setColumn.add(matrix[j][i])) {
                        hasDuplicateColumn = true;
                    }
                }
                if (hasDuplicateRow) duplicateRow++;
                if (hasDuplicateColumn) duplicateColumn++;
            }
            output.append("Case #").append(c + 1).append(": ").append(sum).append(" ").append(duplicateRow).append(" ").append(duplicateColumn).append("\n");
        }
        System.out.print(output.toString());
    }
}