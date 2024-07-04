import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            int trace = 0, rowRepeats = 0, colRepeats = 0;
            Map<Integer, Set<Integer>> columnMap = new HashMap<>();
            int[] colFlags = new int[matrixSize];
            int[] rowFlags = new int[matrixSize];
            scanner.nextLine();

            for (int i = 0; i < matrixSize; i++) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(tokens[j]);

                    // Column checking
                    columnMap.putIfAbsent(j, new HashSet<>());
                    if (columnMap.get(j).contains(matrix[i][j])) {
                        colFlags[j] = 1;
                    } else {
                        columnMap.get(j).add(matrix[i][j]);
                    }

                    // Row checking
                    if (rowSet.contains(matrix[i][j])) {
                        rowFlags[i] = 1;
                    } else {
                        rowSet.add(matrix[i][j]);
                    }
                }
                trace += matrix[i][i];
            }

            colRepeats = Arrays.stream(colFlags).sum();
            rowRepeats = Arrays.stream(rowFlags).sum();
            result.append("Case #").append(caseIndex + 1).append(": ").append(trace).append(" ").append(rowRepeats).append(" ").append(colRepeats).append("\n");
        }
        System.out.println(result.toString());
        scanner.close();
    }
}