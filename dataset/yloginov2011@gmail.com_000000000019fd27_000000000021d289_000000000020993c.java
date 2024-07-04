import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();

            int[][] matrix = new int[N][];
            int j = 0;
            while (j < N) {
                int k = 0;
                matrix[j] = new int[N];
                while (k < N) {
                    matrix[j][k] = in.nextInt();
                    k++;
                }
                j++;
            }
            int[] res = solve(matrix);
            System.out.println("Case #" + i + ": " + res[0] + " " + res[1] + " " + res[2]);
        }
    }

    private static int[] solve(int[][] matrix) {
        Map<Integer, Set<Integer>> row = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            row.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
        }

        int dup_row = 0;
        int dup_col = 0;
        int diag = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int num = matrix[i][j];
                if (i == j) {
                    diag += num;
                }
                if (row.containsKey(i)) {
                    Set<Integer> rs = row.get(i);
                    if (rs.contains(num)) {
                        dup_row++;
                        row.remove(i);
                    } else {
                        rs.add(num);
                    }
                }
                if (cols.containsKey(j)) {
                    Set<Integer> cs = cols.get(j);
                    if (cs.contains(num)) {
                        dup_col++;
                        cols.remove(j);
                    } else {
                        cs.add(num);
                    }
                }
            }
        }

        return new int[]{diag, dup_row, dup_col};
    }
}