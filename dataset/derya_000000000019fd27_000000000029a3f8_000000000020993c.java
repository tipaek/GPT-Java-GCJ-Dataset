import java.util.*;
import java.io.*;

public class Solution {
    private static PrintStream o = System.out;

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = Integer.parseInt(in.nextLine());

        for (int testCaseIdx = 0; testCaseIdx < T; ++testCaseIdx) {
            final int N = Integer.parseInt(in.nextLine());
            final int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                final String[] line = in.nextLine().split(" ");
                for (int j = 0; j < line.length; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }

            boolean[] check;
            int trace = 0;
            int failedRows = 0;
            int failedColumns = 0;
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];

                check = new boolean[N];
                for (int j = 0; j < N; j++) {
                    final int matrixValue = matrix[i][j] - 1;

                    if (check[matrixValue]) {
                        failedRows++;
                        break;
                    }
                    check[matrixValue] = true;
                }

                check = new boolean[N];
                for (int j = 0; j < N; j++) {
                    final int matrixValue = matrix[j][i] - 1;

                    if (check[matrixValue]) {
                        failedColumns++;
                        break;
                    }
                    check[matrixValue] = true;
                }
            }


            o.printf("Case #%d: ", testCaseIdx + 1);
            o.printf("%d %d %d", trace, failedRows, failedColumns);
            o.printf("%n");
        }
    }
}
