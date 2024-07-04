import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int caseNumber = 1;
        int index = 1;

        while (index < args.length) {
            int matrixSize = Integer.parseInt(args[index]);
            TC testCase = new TC(args, index);
            System.out.println("Case #" + caseNumber + ": " + testCase.calculateKRC());
            index += matrixSize + 1;
            caseNumber++;
        }
    }

    public static class TC {
        private final int[][] matrix;
        private final int size;

        public TC(String[] args, int start) {
            this.size = Integer.parseInt(args[start]);
            this.matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                String[] rowValues = args[start + 1 + i].split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }
        }

        public String calculateKRC() {
            int trace = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;

            for (int i = 0; i < size; i++) {
                Map<Integer, Integer> rowMap = new HashMap<>();
                Map<Integer, Integer> columnMap = new HashMap<>();
                trace += matrix[i][i];

                for (int j = 0; j < size; j++) {
                    rowMap.merge(matrix[i][j], 1, Integer::sum);
                    columnMap.merge(matrix[j][i], 1, Integer::sum);
                }

                if (rowMap.values().stream().anyMatch(count -> count > 1)) {
                    rowDuplicates++;
                }

                if (columnMap.values().stream().anyMatch(count -> count > 1)) {
                    columnDuplicates++;
                }
            }

            return trace + " " + rowDuplicates + " " + columnDuplicates;
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