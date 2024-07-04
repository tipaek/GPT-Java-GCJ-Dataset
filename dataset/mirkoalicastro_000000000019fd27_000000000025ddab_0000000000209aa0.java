import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE\n";
    private static final String POSSIBLE = "POSSIBLE\n";

    public static void main(String...args) {
        final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final StringBuilder out = new StringBuilder();
        final int testCases = scanner.nextInt();
        for (int t=1; t<=testCases; t++) {
            final int n = scanner.nextInt();
            final int k = scanner.nextInt();
            int[][] matrix = null;
            Integer trace = getTrace(n, k);
            if (trace != null) {
                matrix = new int[n][n];
                List<Integer> vals = new LinkedList<>();
                for (int i=1; i<=n; i++) {
                    if (i != trace)
                        vals.add(i);
                }
                for (int i = 0; i < matrix.length; i++) {
                    int cur = (vals.size()-1) * i;
                    for (int j = 0; j < matrix.length; j++) {
                        if (i == j)
                            matrix[i][j] = trace;
                        else {
                            int index = cur % (n-1);
                            int val = vals.get(index);
                            matrix[i][j] = val;
                            cur++;
                        }
                    }
                }
            } else {
                matrix = fallback(n, k);
            }
            out.append("Case #").append(t).append(": ")
                .append(human(matrix));
        }
        System.out.print(out.toString());
    }

    private static int[][] fallback(int n, int k) {
        int sum = (n*(n+1))/2;
        int[][] matrix = null;
        if (sum == k) {
            if (n == 4)
                return new int[][]{
                    new int[]{1, 3, 4, 2},
                    new int[]{2, 4, 3, 1},
                    new int[]{3, 1, 2, 4},
                    new int[]{4, 2, 1, 3}
                };
        }
        return matrix;
    }

    private static Integer getTrace(int n, int k) {
        if (k < 1)
            return null;
        for (int i=1; i<=n; i++) {
            if (i * n == k)
                return i;
        }
        return null;
    }

    private static String human(int[][] matrix) {
        if (matrix == null) {
            return IMPOSSIBLE;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(POSSIBLE);
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length-1; j++) {
                sb.append(matrix[i][j]).append(' ');
            }
            sb.append(matrix[i][matrix.length-1]).append('\n');
        }
        return sb.toString();
    }
}