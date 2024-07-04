import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int r = 0, c = 0;
            int indexTrace = 0;

            for (int j = 0; j < n * n; ++j) {
                int value = in.nextInt();
                if (j == indexTrace) {
                    trace += value;
                    indexTrace += (n + 1);
                }
                matrix[r][c] = value;
                c++;
                if (c == n) {
                    c = 0;
                    r++;
                }
            }

            int duplicateRows = 0, duplicateColumns = 0;
            boolean[] rowCheck = new boolean[n];
            boolean[] colCheck = new boolean[n];

            for (int j = 0; j < n; ++j) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();

                for (int k = 0; k < n; ++k) {
                    if (!rowSet.add(matrix[j][k])) {
                        if (!rowCheck[j]) {
                            duplicateRows++;
                            rowCheck[j] = true;
                        }
                    }
                    if (!colSet.add(matrix[k][j])) {
                        if (!colCheck[j]) {
                            duplicateColumns++;
                            colCheck[j] = true;
                        }
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
        in.close();
    }
}