import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCases = Integer.parseInt(scanner.nextLine());

            for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
                int matrixSize = Integer.parseInt(scanner.nextLine());
                int trace = 0, duplicateRows = 0, duplicateColumns = 0;

                int[][] matrix = new int[matrixSize][matrixSize];
                boolean[] rowAlreadyCounted = new boolean[matrixSize];
                boolean[] columnAlreadyCounted = new boolean[matrixSize];
                Map<Integer, Set<Integer>> numbersSeenInColumn = new HashMap<>();

                for (int col = 0; col < matrixSize; col++) {
                    numbersSeenInColumn.put(col, new HashSet<>());
                }

                for (int row = 0; row < matrixSize; row++) {
                    Set<Integer> numbersSeenInRow = new HashSet<>();
                    String[] lineParts = scanner.nextLine().split(" ");

                    for (int col = 0; col < matrixSize; col++) {
                        int value = Integer.parseInt(lineParts[col]);
                        matrix[row][col] = value;

                        if (row == col) {
                            trace += value;
                        }

                        if (!rowAlreadyCounted[row] && !numbersSeenInRow.add(value)) {
                            duplicateRows++;
                            rowAlreadyCounted[row] = true;
                        }

                        if (!columnAlreadyCounted[col] && !numbersSeenInColumn.get(col).add(value)) {
                            duplicateColumns++;
                            columnAlreadyCounted[col] = true;
                        }
                    }
                }

                System.out.printf("Case #%d: %d %d %d%n", testCase, trace, duplicateRows, duplicateColumns);
            }
        }
    }
}