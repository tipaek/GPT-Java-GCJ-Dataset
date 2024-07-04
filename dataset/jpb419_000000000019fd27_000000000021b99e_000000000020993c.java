import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int casenum = 1; casenum <= T; casenum++) {
            int n = in.nextInt(), trace = 0, r = 0, c = 0;
            int[][] mat = new int[n][n];
            for (int i = 0; i < n; i++) {
                HashSet<Integer> row = new HashSet<>();
                boolean add = false;
                for (int j = 0; j < n; j++) {
                    mat[i][j] = in.nextInt();
                    if (i == j) trace += mat[i][j];
                    add |= row.contains(mat[i][j]);
                    row.add(mat[i][j]);
                }
                if (add) r++;
            }
            for (int i = 0; i < n; i++) {
                HashSet<Integer> col = new HashSet<>();
                boolean add = false;
                for (int j = 0; j < n; j++) {
                    add |= col.contains(mat[j][i]);
                    col.add(mat[j][i]);
                }
                if (add) c++;
            }
            System.out.printf("Case #%d: %d %d %d\n", casenum, trace, r, c);
        }
    }
}