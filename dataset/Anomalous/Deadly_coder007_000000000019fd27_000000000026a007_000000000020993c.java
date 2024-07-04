import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            Map<Integer, Set<Integer>> rowMap = new HashMap<>();
            Map<Integer, Set<Integer>> columnMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    rowMap.computeIfAbsent(i, k -> new HashSet<>()).add(matrix[i][j]);
                    columnMap.computeIfAbsent(j, k -> new HashSet<>()).add(matrix[i][j]);
                }
            }

            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (Set<Integer> rowSet : rowMap.values()) {
                if (rowSet.size() != n) {
                    duplicateRows++;
                }
            }

            for (Set<Integer> columnSet : columnMap.values()) {
                if (columnSet.size() != n) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + (testCase + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}