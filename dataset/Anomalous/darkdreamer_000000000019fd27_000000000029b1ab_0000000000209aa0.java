import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    static boolean solved = false;
    static int n = 0;
    static int m = 0;
    static int p = 0;

    static void solve(int[][] arr, int k, HashMap<Integer, HashMap<Integer, Boolean>> row, HashMap<Integer, HashMap<Integer, Boolean>> col, int i, int j) {
        if (i == n) {
            return;
        }

        if (i == n - 1 && j == n && m == k && !solved) {
            solved = true;
            System.out.println("Case #" + p + ": POSSIBLE");
            for (int[] ints : arr) {
                for (int y = 0; y < n; y++) {
                    System.out.print(ints[y] + " ");
                }
                System.out.println();
            }
            return;
        }

        if (i == n - 1 && j == n) {
            return;
        }

        if (j == n) {
            solve(arr, k, row, col, i + 1, 0);
            return;
        }

        if (solved) {
            return;
        }

        for (int w = 1; w <= n; w++) {
            if (!row.get(i).containsKey(w) && !col.get(j).containsKey(w)) {
                if (solved) {
                    return;
                }
                arr[i][j] = w;
                if (i == j) {
                    m += w;
                }
                row.get(i).put(w, true);
                col.get(j).put(w, true);
                solve(arr, k, row, col, i, j + 1);
                row.get(i).remove(w);
                col.get(j).remove(w);
                if (i == j) {
                    m -= w;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        p = 1;

        while (p <= t) {
            solved = false;
            m = 0;
            n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] arr = new int[n][n];
            HashMap<Integer, HashMap<Integer, Boolean>> row = new HashMap<>();
            HashMap<Integer, HashMap<Integer, Boolean>> col = new HashMap<>();

            for (int w = 0; w < n; w++) {
                row.put(w, new HashMap<>());
                col.put(w, new HashMap<>());
            }

            solve(arr, k, row, col, 0, 0);

            if (!solved) {
                System.out.println("Case #" + p + ": IMPOSSIBLE");
            }
            p++;
        }
    }
}