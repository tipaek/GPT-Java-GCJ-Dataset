import java.util.*;

public class Solution {

    public static void ref(int[][] ar, int n, int q) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;
        for (int i = 0; i < n; i++) {
            trace += ar[i][i];
        }

        for (int i = 0; i < n; i++) {
            if (hasDuplicates(ar[i])) {
                rowDuplicates++;
            }

            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = ar[j][i];
            }
            if (hasDuplicates(col)) {
                colDuplicates++;
            }
        }

        System.out.format("Case #%d: %d %d %d%n", q, trace, rowDuplicates, colDuplicates);
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    arr[row][col] = sc.nextInt();
                }
            }
            ref(arr, n, i);
        }
        sc.close();
    }
}