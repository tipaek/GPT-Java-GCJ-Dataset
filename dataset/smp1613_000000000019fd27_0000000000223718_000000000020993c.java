import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n + 1][n + 1];
            int[] rowsum = new int[n + 1];
            int[] colsum = new int[n + 1];
            int trace = 0;
            int rsum = 0;
            for (int j = 1; j <= n; j++) {
                rsum = rsum ^ j;
            }
            int rcnt = 0;
            int ccnt = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = sc.nextInt();
                    if (j == k) {
                        trace += arr[j][k];
                    }
                    rowsum[j] ^= arr[j][k];
                    colsum[k] ^= arr[j][k];
                }
                if (rowsum[j] != rsum) {
                    rcnt++;
                }
            }

            for (int j = 1; j <= n; j++) {
                if (colsum[j] != rsum) {
                    ccnt++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rcnt + " " + ccnt);
        }
    }
}