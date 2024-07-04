import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int testCase = 1;

        while (t-- > 0) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            Map<String, Set<Integer>> map = new HashMap<>();
            int trace = 0;

            // Reading matrix and calculating trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    map.computeIfAbsent("row" + i, k -> new HashSet<>()).add(matrix[i][j]);
                    map.computeIfAbsent("col" + j, k -> new HashSet<>()).add(matrix[i][j]);
                }
            }

            // Counting rows with duplicates
            int rowDuplicates = 0;
            for (int i = 0; i < n; i++) {
                if (map.get("row" + i).size() != n) {
                    rowDuplicates++;
                }
            }

            // Counting columns with duplicates
            int colDuplicates = 0;
            for (int j = 0; j < n; j++) {
                if (map.get("col" + j).size() != n) {
                    colDuplicates++;
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
            testCase++;
        }

        in.close();
    }
}