import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int t1 = 0; t1 < t; t1++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    rowSet.add(arr[i][j]);
                    if (i == j) {
                        trace += arr[i][j];
                    }
                }
                if (rowSet.size() != n) {
                    rowRepeats++;
                }
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    colSet.add(arr[j][i]);
                }
                if (colSet.size() != n) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + (t1 + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}