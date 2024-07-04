import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        String[] res = new String[tests];
        for (int t = 0; t < tests; t++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            in.nextLine();
            for (int i = 0; i < n; i++) {
                String line = in.nextLine();
                String[] s = line.split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(s[j]);
                }
            }
            int k = trace(matrix);
            int r = rowCount(matrix);
            int c = colCount(matrix);
            String result = String.format("Case #%1$d: %2$d %3$d %4$d", t + 1, k, r, c);
            res[t] = result;
        }
        for (String s : res) {
            System.out.println(s);
        }
    }

    private static int trace(int[][] matrix) {
        int res = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            res += matrix[i][i];
        }
        return res;
    }

    private static int rowCount(int[][] matrix) {
        int res = 0;
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            Set<Integer> row = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!row.add(matrix[i][j])) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    private static int colCount(int[][] matrix) {
        int res = 0;
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            Set<Integer> row = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!row.add(matrix[j][i])) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
