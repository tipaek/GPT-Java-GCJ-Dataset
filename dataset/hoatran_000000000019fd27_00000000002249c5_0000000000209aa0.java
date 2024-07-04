import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            findSolution(i, n, k);
        }
    }

    public static void findSolution(int index, int n, int k) {
        Set<Integer> set = new HashSet<>();
        int t = 0;
        for (int i = 1; i <=n; i++) {
            set.add(i * n);
            t = t + i;
        }
        if (n % 2 != 0) {
            set.add(t);
        }
        if (!set.contains(k)) {
            System.out.println("Case #" + index + ": " + "IMPOSSIBLE");
            return;
        }
        System.out.println("Case #" + index + ": " + "POSSIBLE");
        int[][] a = new int[n][n];

        if (k % n == 0) {
            int j = k / n;
            List<Integer> q = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i != j) {
                    q.add(i);
                }
            }
            for (int i = 0; i < n; i++) {
                a[i][i] = j;

                for (int l = 0; l < i; l++) {
                    a[i][l] = q.get(q.size() - i + l);
                }
                for (int r = i + 1; r < n; r++) {
                    a[i][r] = q.get(r - i - 1);
                }

            }
        } else if (t == k) {
            int j = k / n;
            List<Integer> q = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i != j) {
                    q.add(i);
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                a[i][i] = j;

                for (int r = n - 1; r > i; r--) {
                    a[i][r] = q.get(q.size() - 1 - (r - i - 1));
                }
                for (int l = i - 1; l >= 0; l++) {
                    a[i][l] = q.get(i - l - 1);
                }

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]);
                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
