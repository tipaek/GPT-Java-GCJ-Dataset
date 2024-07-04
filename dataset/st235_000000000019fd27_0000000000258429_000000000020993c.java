import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static void solve(int[][] matrix, int n, int test) {
        int i = 0;
        int j = 0;

        int trace = 0;

        int rowsDuplicate = 0;
        int columnsDuplicate = 0;

        Map<Integer, Set<Integer>> columns = new HashMap<>();

        for (i = 0; i < n; i++) {
            boolean rd = false;
            Set<Integer> rowInfo = new HashSet<>();

            for (j = 0; j < n; j++) {
                if (i == 0) {
                    columns.put(j, new HashSet<>());
                }

                if (columns.get(j) != null) {
                    if (columns.get(j).contains(matrix[i][j])) {
                        columns.remove(j);
                        columnsDuplicate++;
                    } else {
                        columns.get(j).add(matrix[i][j]);
                    }
                }

                if (i == j) {
                    trace += matrix[i][j];
                }

                if (rowInfo.contains(matrix[i][j])) {
                    rd = true;
                } else {
                    rowInfo.add(matrix[i][j]);
                }
            }

            if (rd) {
                rowsDuplicate++;
            }
        }

        System.out.printf("Case #%d: %d %d %d\n", test, trace, rowsDuplicate, columnsDuplicate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));

        int tests = scanner.nextInt();

        for (int k = 0; k < tests; k++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            solve(matrix, n, k + 1);
        }
    }
}
