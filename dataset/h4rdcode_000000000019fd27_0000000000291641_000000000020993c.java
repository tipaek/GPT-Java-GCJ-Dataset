import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            int trace = IntStream.range(0, n).map(q -> matrix[q][q]).sum();

            int repeatedRows = 0;
            int repeateadColumns = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> row = new HashSet<>();
                Set<Integer> column = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    row.add(matrix[j][k]);
                    column.add(matrix[k][j]);
                }
                repeatedRows = row.size() < n ? repeatedRows + 1 : repeatedRows;
                repeateadColumns = column.size() < n ? repeateadColumns + 1 : repeateadColumns;
            }

            System.out.println(String.format("Case #%d: %d %d %d", i + 1, trace, repeatedRows, repeateadColumns));
        }
    }
}
