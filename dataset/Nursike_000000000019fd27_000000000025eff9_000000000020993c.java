import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tn = in.nextInt();
        for (int t = 0; t < tn; t++) {
            solve(in, t + 1);
        }
    }

    private static void solve(Scanner in, int t) {
        int n = in.nextInt();
        int[][] a = new int[n][n];
        int trace = 0;
        int rows = 0;
        int cols = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet();
            boolean found = false;
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
                if (!set.add(a[i][j])) found = true;
                if (i == j) {
                    trace += a[i][j];
                }
            }
            if (found) rows++;
        }
        for (int j = 0; j < n; j++) {
            Set<Integer> set = new HashSet();
            boolean found = false;
            for (int i = 0; i < n; i++) {
                if (!set.add(a[i][j])) found = true;
            }
            if (found) cols++;
        }
        System.out.println("Case #" + t + ": " + trace + " " + rows + " " + cols);
    }
}