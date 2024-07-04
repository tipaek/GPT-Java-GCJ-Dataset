import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.next());
        List<int[]> results = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            int size = Integer.parseInt(scanner.next());
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            results.add(calculateMatrixMetrics(matrix));
        }

        for (int i = 0; i < results.size(); i++) {
            int[] result = results.get(i);
            System.out.printf("Case #%d: %d %d %d%n", i + 1, result[0], result[1], result[2]);
        }
    }

    private static int[] calculateMatrixMetrics(int[][] matrix) {
        int size = matrix.length;
        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        // Calculate trace
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        // Check for duplicate rows
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
            }
        }

        // Check for duplicate columns
        for (int i = 0; i < size; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!colSet.add(matrix[j][i])) {
                    duplicateCols++;
                    break;
                }
            }
        }

        return new int[]{trace, duplicateRows, duplicateCols};
    }
}