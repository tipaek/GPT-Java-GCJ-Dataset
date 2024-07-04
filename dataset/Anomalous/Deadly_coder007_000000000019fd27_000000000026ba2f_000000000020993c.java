import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            HashMap<Integer, HashSet<Integer>> rowMap = new HashMap<>();
            HashMap<Integer, HashSet<Integer>> colMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowMap.computeIfAbsent(i, k -> new HashSet<>()).add(matrix[i][j]);
                    colMap.computeIfAbsent(j, k -> new HashSet<>()).add(matrix[i][j]);
                }
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (HashSet<Integer> rowSet : rowMap.values()) {
                if (rowSet.size() != n) {
                    rowDuplicates++;
                }
            }

            for (HashSet<Integer> colSet : colMap.values()) {
                if (colSet.size() != n) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}