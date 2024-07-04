import java.util.*;

public class Solution {

    public static void ref(int[][] ar, int n, int q) {
        int trace = 0, rowCount = 0, colCount = 0;
        
        for (int i = 0; i < n; i++) {
            trace += ar[i][i];
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                rowSet.add(ar[i][j]);
                colSet.add(ar[j][i]);
            }
            if (rowSet.size() < n) rowCount++;
            if (colSet.size() < n) colCount++;
        }

        System.out.format("Case #%d: %d %d %d\n", q, trace, rowCount, colCount);
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