import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n + 1][n + 1];
            HashSet<Integer> rowSet[] = new HashSet[n + 1];
            HashSet<Integer> colSet[] = new HashSet[n + 1];
            for (int j = 1; j <= n; j++) {
                rowSet[j] = new HashSet<Integer>();
            }

            for (int j = 1; j <= n; j++) {
                colSet[j] = new HashSet<>();
            }
            int trace = 0;

            int rcnt = 0;
            int ccnt = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = sc.nextInt();
                    if (!rowSet[j].contains(arr[j][k])) {
                        rowSet[j].add(arr[j][k]);
                    }
                    if (!colSet[k].contains(arr[j][k])) {
                        colSet[k].add(arr[j][k]);
                    }

                    if (j == k) {
                        trace += arr[j][k];
                    }

                }
                if (rowSet[j].size() != n) {
                    rcnt++;
                }
            }

            for (int j = 1; j <= n; j++) {
                if (colSet[j].size() != n) {
                    ccnt++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rcnt + " " + ccnt);
        }
    }
}