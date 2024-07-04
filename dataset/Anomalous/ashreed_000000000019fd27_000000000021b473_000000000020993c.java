import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        List<int[]> results = new ArrayList<>();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;

            Set<Integer>[] columnSets = new HashSet[n];
            for (int i = 0; i < n; i++) {
                columnSets[i] = new HashSet<>();
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    rowSet.add(value);
                    columnSets[j].add(value);
                    if (i == j) {
                        trace += value;
                    }
                }
                if (rowSet.size() < n) {
                    repeatedRows++;
                }
            }

            for (Set<Integer> columnSet : columnSets) {
                if (columnSet.size() < n) {
                    repeatedColumns++;
                }
            }

            results.add(new int[]{trace, repeatedRows, repeatedColumns});
        }

        for (int i = 0; i < results.size(); i++) {
            int[] result = results.get(i);
            System.out.printf("Case #%d: %d %d %d\n", i + 1, result[0], result[1], result[2]);
        }

        scanner.close();
    }
}