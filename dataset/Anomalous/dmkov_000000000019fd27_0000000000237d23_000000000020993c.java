import java.util.*;
import java.io.*;

public class Solution {

    private static int[] compute(int n, int[][] matrix) {
        int[] result = new int[3];
        List<Set<Integer>> columnSets = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            columnSets.add(new HashSet<>());
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    result[0] += matrix[i][j];
                }
                rowSet.add(matrix[i][j]);
                columnSets.get(j).add(matrix[i][j]);
            }
            if (rowSet.size() != n) {
                result[1]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (columnSets.get(i).size() != n) {
                result[2]++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int[] result = compute(n, matrix);
            System.out.println("Case #" + t + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }
}