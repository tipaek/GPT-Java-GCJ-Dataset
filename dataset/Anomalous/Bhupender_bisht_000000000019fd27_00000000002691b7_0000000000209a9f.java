import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int[][] matrix = new int[n][n];

            // Reading matrix and calculating trace
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    rowSet.add(matrix[i][j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                if (rowSet.size() != n) {
                    rowDuplicates++;
                }
            }

            // Checking for column duplicates
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != n) {
                    colDuplicates++;
                }
            }

            sb.append("Case #").append(caseNumber).append(": ")
              .append(trace).append(" ")
              .append(rowDuplicates).append(" ")
              .append(colDuplicates).append("\n");

            caseNumber++;
        }

        System.out.print(sb.toString());
        sc.close();
    }
}