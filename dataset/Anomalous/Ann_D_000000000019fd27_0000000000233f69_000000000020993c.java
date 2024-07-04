import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace += arr[j][j];
            }

            int r = 0, c = 0;

            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    rowSet.add(arr[j][k]);
                }
                if (rowSet.size() != n) {
                    r++;
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    colSet.add(arr[k][j]);
                }
                if (colSet.size() != n) {
                    c++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + r + " " + c);
        }
    }
}