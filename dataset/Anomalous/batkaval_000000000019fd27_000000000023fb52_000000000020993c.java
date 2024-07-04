import java.util.*;

public class Main {

    public static void main(String[] args) {
        int caseNumber = 1;
        int index = 1;

        while (index < args.length) {
            int n = Integer.parseInt(args[index]);
            TC testCase = new TC(args, index);
            System.out.println("Case #" + caseNumber + ": " + testCase.krc());
            index += n + 1;
            caseNumber++;
        }
    }

    public static class TC {
        private final int[][] matrix;
        private final int n;

        public TC(String[] args, int start) {
            n = Integer.parseInt(args[start]);
            matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] rowValues = args[start + 1 + i].split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }
        }

        public String krc() {
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                trace += matrix[i][i];

                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }

                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            return trace + " " + rowRepeats + " " + colRepeats;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int[] row : matrix) {
                for (int val : row) {
                    sb.append(val).append(" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }
}