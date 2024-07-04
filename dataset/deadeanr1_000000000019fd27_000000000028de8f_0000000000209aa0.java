
import java.util.*;

class Solution {
    private static int[] N ;
    private static Scanner sc;
    static int tn = 1;
    static int M[][] = new int[55][55];
    static int n, k, t;

    static List<Set<Integer>> rows = new ArrayList<>();
    static List<Set<Integer>> columns = new ArrayList<>();
    private static boolean solved;

    static {
        for (int i = 0; i < 55; i++) {
            rows.add(new HashSet<>());
            columns.add(new HashSet<>());
        }
    }


    public static void main(String[] args) {
        sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        while (T-- > 0) {
            solved = false;
            for (int i = 0; i < 55; i++) {
                rows.get(i).clear();
                columns.get(i).clear();
            }
            n = sc.nextInt();
            k = sc.nextInt();
            N = new int[n];

            if (k % n == 0) {
                for (int j = 0; j < n; j++) N[j] = j + 1;
                int d = k / n - 1;
                System.out.println("Case #" + (tn++) + ": " + "POSSIBLE");
                for (int x = 0; x < n; x++) {
                    int temp = d + n - x;
                    for (int j = 0; j < n; j++) {
                        System.out.print(N[(temp + j) % n]);
                        if (j != n - 1) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }

            }
            else {

                result(1, 1, 0);
                if (!solved) {
                    System.out.println("Case #" + (tn++) + ": IMPOSSIBLE");
                }
            }
        }
    }


    private static void result(int row, int col, int m) {
        if (row == n && col == n + 1 && m == k && !solved) {
            solved = true;
            System.out.println("Case #" + (tn++) + ": POSSIBLE");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(M[i][j]);
                    if (j != n) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            return;
        } else if (row > n) {
            return;
        } else if (col > n) {
            result(row + 1, 1, m);
        }

        for (int q = 1; q <= n && !solved; q++) {
            if (!rows.get(row).contains(q) && !columns.get(col).contains(q)) {
                if (row == col && m+q+Math.min(n-row,n-col)>k) {
                    return;
                }
                rows.get(row).add(q);
                columns.get(col).add(q);
                if (row == col) {
                    m += q;
                }
                if (m <= k && !(m==k && (row<n || col<n))) {
                    M[row][col] = q;

                    result(row, col + 1, m);

                }
                rows.get(row).remove(q);
                columns.get(col).remove(q);
                if (row == col) {
                    m -= q;
                }
                M[row][col] = 0;
            }
        }
    }
}