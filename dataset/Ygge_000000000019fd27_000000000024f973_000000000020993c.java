import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        for (int cs = 1; cs <= cases; ++cs) {
            int n = Integer.parseInt(in.readLine());
            int[][] mat = new int[n][n];
            int score = 0;
            int r = 0;
            for (int i = 0; i < n; ++i) {
                Set<Integer> seen = new HashSet<>();
                String[] row = in.readLine().split(" ");
                for (int j = 0; j < n; ++j) {
                    mat[i][j] = Integer.parseInt(row[j]);
                    if (seen != null && !seen.add(mat[i][j])) {
                        ++r;
                        seen = null;
                    }
                }
                score += mat[i][i];
            }
            int c = 0;
            for (int i = 0; i < n; ++i) {
                Set<Integer> seen = new HashSet<>();
                for (int j = 0; j < n; ++j) {
                    if (!seen.add(mat[j][i])) {
                        ++c;
                        break;
                    }
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", cs, score, r, c);
        }
    }
}
