import java.util.*;

public class CODEJAM1_2020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int[] traceResults = new int[t];
        int[] rowDuplicates = new int[t];
        int[] columnDuplicates = new int[t];

        for (int g = 0; g < t; g++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowDuplicateCount = 0;
            int columnDuplicateCount = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                }
                if (rowHasDuplicate) {
                    rowDuplicateCount++;
                }
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> columnSet = new HashSet<>();
                boolean columnHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!columnSet.add(matrix[j][i])) {
                        columnHasDuplicate = true;
                    }
                }
                if (columnHasDuplicate) {
                    columnDuplicateCount++;
                }
            }

            traceResults[g] = trace;
            rowDuplicates[g] = rowDuplicateCount;
            columnDuplicates[g] = columnDuplicateCount;
        }

        for (int i = 0; i < t; i++) {
            System.out.printf("Case #%d: %d %d %d%n", i + 1, traceResults[i], rowDuplicates[i], columnDuplicates[i]);
        }
    }
}