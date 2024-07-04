import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.valueOf(scanner.nextLine());
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] m = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    m[j][k] = scanner.nextInt();;
                }
            }
            int[] res = solve(m);
            System.out.println("Case #" + i + ": " + res[0] + " " + res[1] + " " + res[2]);
        }
        scanner.close();
    }


    private static int[] solve(int[][] m) throws IOException {
        int k = 0;
        int r = 0;
        int c = 0;
        for (int i = 0; i < m.length; i++) {
            Set<Integer> rset = new HashSet<>();
            Set<Integer> cset = new HashSet<>();
            for (int j = 0; j < m[0].length; j++) {
                if (i == j) {
                    k += m[i][j];
                }
                rset.add(m[i][j]);
                cset.add(m[j][i]);
            }
            if (rset.size() != m.length) {
                r++;
            }
            if (cset.size() != m[0].length) {
                c++;
            }
        }
        return new int[]{k, r, c};
    }
}
