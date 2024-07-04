import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int x = 1;x <= t;x ++) {
            int n = scanner.nextInt(), k = 0, r = 0, c = 0;
            int[][] m = new int[n][n];
            for(int i = 0;i < n;i ++)
                for(int j = 0;j < n;j ++)
                    m[i][j] = scanner.nextInt();
            for(int i = 0;i < n;i ++)
                k += m[i][i];
            for(int i = 0;i < n;i ++) {
                boolean[] existed = new boolean[n];
                for(int j = 0;j < n;j ++) {
                    if(existed[m[i][j] - 1]) {
                        r ++;
                        break;
                    }
                    else {
                        existed[m[i][j] - 1] = true;
                    }
                }
            }
            for(int i = 0;i < n;i ++) {
                boolean[] existed = new boolean[n];
                for(int j = 0;j < n;j ++) {
                    if(existed[m[j][i] - 1]) {
                        c ++;
                        break;
                    }
                    else {
                        existed[m[j][i] - 1] = true;
                    }
                }
            }
            System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
        }
    }
}