import java.util.Scanner;
import java.util.HashMap;

public class Solution {
    public static int n = 0;
    public static int m = 0;
    public static boolean isFalse = false;
    public static int p = 0;

    static void helper(int[][] arr, int k, HashMap<Integer, HashMap<Integer, Boolean>> row, HashMap<Integer, HashMap<Integer, Boolean>> col, int i, int j) {
        if (i == n) {
            return;
        }
        if (i == n - 1 && j == n && m == k && !isFalse) {
            isFalse = true;
            System.out.println("Case #" + p + ": POSSIBLE");
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    System.out.print(arr[x][y] + " ");
                }
                System.out.println();
            }
            return;
        }
        if (i == n - 1 && j == n) {
            return;
        }
        if (j == n) {
            helper(arr, k, row, col, i + 1, 0);
            return;
        }
        if (isFalse) {
            return;
        }
        for (int w = 1; w <= n; w++) {
            if (!row.get(i).containsKey(w) && !col.get(j).containsKey(w)) {
                if (isFalse) {
                    return;
                }
                arr[i][j] = w;
                if (i == j) {
                    m += w;
                }
                row.get(i).put(w, true);
                col.get(j).put(w, true);
                helper(arr, k, row, col, i, j + 1);
                row.get(i).remove(w);
                col.get(j).remove(w);
                if (i == j) {
                    m -= w;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        p = 1;
        while (p <= t) {
            isFalse = false;
            m = 0;
            n = s.nextInt();
            int k = s.nextInt();
            int[][] arr = new int[n][n];
            HashMap<Integer, HashMap<Integer, Boolean>> row = new HashMap<>();
            HashMap<Integer, HashMap<Integer, Boolean>> col = new HashMap<>();
            for (int w = 0; w < n; w++) {
                row.put(w, new HashMap<>());
                col.put(w, new HashMap<>());
            }
            helper(arr, k, row, col, 0, 0);
            if (!isFalse) {
                System.out.println("Case #" + p + ": IMPOSSIBLE");
            }
            p++;
        }
        s.close();
    }
}