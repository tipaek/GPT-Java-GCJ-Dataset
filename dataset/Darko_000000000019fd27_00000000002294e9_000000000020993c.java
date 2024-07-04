import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private void work() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = sc.nextInt();
        for (int tc = 1; tc <= nc; tc++) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            int trace = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
                trace += a[i][i];
            }

            int r = 0, c = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> s1 = new HashSet<>();
                Set<Integer> s2 = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    s1.add(a[i][j]);
                    s2.add(a[j][i]);
                }
                if (s1.size() < n) r++;
                if (s2.size() < n) c++;
            }

            System.out.printf("Case #%d: %d %d %d\n", tc, trace, r, c);
        }
        sc.close();
    }

    public static void main(String[] args) {
        new Solution().work();
    }
}
