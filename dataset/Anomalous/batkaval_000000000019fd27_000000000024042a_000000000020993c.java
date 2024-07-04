import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int caseNumber = 1;
        for (int i = 1; i < args.length; ) {
            int n = Integer.parseInt(args[i]);
            TC testCase = new TC(args, i);
            System.out.println("Case #" + caseNumber++ + ": " + testCase.calculateKRC());
            i += n + 1;
        }
    }

    public static class TC {
        private final int[][] matrix;
        private final int n;

        public TC(String[] args, int start) {
            this.n = Integer.parseInt(args[start]);
            this.matrix = new int[n][n];
            for (int x = 0; x < n; x++) {
                String[] rowValues = args[start + 1 + x].split(" ");
                for (int y = 0; y < n; y++) {
                    this.matrix[x][y] = Integer.parseInt(rowValues[y]);
                }
            }
        }

        public String calculateKRC() {
            int k = 0, r = 0, c = 0;

            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> rowMap = new HashMap<>();
                Map<Integer, Integer> colMap = new HashMap<>();
                k += matrix[i][i];

                for (int j = 0; j < n; j++) {
                    rowMap.merge(matrix[i][j], 1, Integer::sum);
                    colMap.merge(matrix[j][i], 1, Integer::sum);
                }

                if (rowMap.values().stream().anyMatch(count -> count > 1)) {
                    r++;
                }
                if (colMap.values().stream().anyMatch(count -> count > 1)) {
                    c++;
                }
            }

            return k + " " + r + " " + c;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int[] row : matrix) {
                for (int value : row) {
                    sb.append(value).append(" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }
}