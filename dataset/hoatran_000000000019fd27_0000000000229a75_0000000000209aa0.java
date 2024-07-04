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
        int s = 0;
        if (k < n || k > n * n) {
            System.out.println("Case #" + index + ": " + "IMPOSSIBLE");
            return;
        }
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
                s = s + a[i][i];
            }
        } else {
            for (int j = 1; j <=n; j++) {
                a = new int[n][n];
                s = 0;
                List<Integer> q = new ArrayList<>();
                for (int i = 1; i <= n; i++) {
                    if (i != j) {
                        q.add(i);
                    }
                }
                int y = n - 1;
                for (int i = 0; i < n; i++) {
                    int x = y -i;
                    a[i][y-i] = j;

                    for (int r = n - 1; r > x; r--) {
                        a[i][r] = q.get(q.size() - 1 - (r - x - 1));
                    }
                    for (int l = x - 1; l >= 0; l--) {
                        a[i][l] = q.get(x - l - 1);
                    }
                    s = s + a[i][i];
                }
                if (s == k) {
                    break;
                }
            }
        }
        if (s != k) {
            System.out.println("Case #" + index + ": " + "IMPOSSIBLE");
            return;
        }
        System.out.println("Case #" + index + ": " + "POSSIBLE");
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
