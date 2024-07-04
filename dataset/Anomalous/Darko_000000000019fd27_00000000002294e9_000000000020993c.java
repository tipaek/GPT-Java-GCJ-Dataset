import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private void execute() {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfCases = scanner.nextInt();
            for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
                int matrixSize = scanner.nextInt();
                int[][] matrix = new int[matrixSize][matrixSize];
                int trace = 0;

                for (int i = 0; i < matrixSize; i++) {
                    for (int j = 0; j < matrixSize; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                    trace += matrix[i][i];
                }

                int duplicateRows = 0, duplicateColumns = 0;
                for (int i = 0; i < matrixSize; i++) {
                    Set<Integer> rowSet = new HashSet<>();
                    Set<Integer> columnSet = new HashSet<>();
                    for (int j = 0; j < matrixSize; j++) {
                        rowSet.add(matrix[i][j]);
                        columnSet.add(matrix[j][i]);
                    }
                    if (rowSet.size() < matrixSize) duplicateRows++;
                    if (columnSet.size() < matrixSize) duplicateColumns++;
                }

                System.out.printf("Case #%d: %d %d %d%n", caseIndex, trace, duplicateRows, duplicateColumns);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().execute();
    }
}