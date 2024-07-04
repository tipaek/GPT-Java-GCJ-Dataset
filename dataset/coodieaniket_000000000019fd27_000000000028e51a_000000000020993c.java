import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            int k = 0, c = 0, r = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                    if (i == j)
                        k += a[i][j];
                }
            }

            HashSet<Integer> row = new HashSet<>(), col = new HashSet<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    row.add(a[i][j]);
                }
                if (row.size() != n)
                    r++;
                row.clear();

            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    col.add(a[j][i]);
                }
                if (col.size() != n)
                    c++;
                col.clear();
            }

            System.out.println("Case #" + t + ": " + k + " " + r + " " + c);

        }
        sc.close();

    }
}