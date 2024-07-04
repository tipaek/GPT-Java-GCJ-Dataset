import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int q = 1; q <= t; q++) {
            int n =sc.nextInt();
            int k = 0;
            int R = 0, C = 0;
            int[][] arr = new int[n + 1][n + 1];
            for (int r= 0 ; r < n; r++) {
                int[] row = new int[n + 1];
                for (int c =0 ; c < n; c++) {
                    int num = sc.nextInt();
                    if (r == c)
                        k+=num;
                    row[num]++;
                    arr[num][c]++;
                }
                for (int x =0 ; x < row.length; x++)
                    if (row[x] > 1) {
                        R++;
                        break;
                    }
            }
            for (int c=0; c < arr.length; c++) {
                for (int r = 0; r < arr.length; r++) {
                    if (arr[r][c] > 1) {
                        C++;
                        break;
                    }
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", q, k, R, C);
        }
    }
}