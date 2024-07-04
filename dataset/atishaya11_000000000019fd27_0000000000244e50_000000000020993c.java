import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for (int t = 1; t <= count; t++) {
            int n = in.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            int trace = 0;
            int rCount = 0, cCount = 0;
            for (int i = 0; i < n; i++) {
                int temp = 0;
                int c  = 1;
                for (int j = 0; j < n; j++) {
                    temp ^= (a[i][j] ^ c++);
                    if (i == j) {
                        trace += a[i][j];
                    }
                }
                if (temp == 0) {
                    rCount += 1;
                }
            }
            for (int i = 0; i < n; i++) {
                int temp = 0;
                int c = 1;
                for (int j = 0; j < n; j++) {
                    temp ^= (a[j][i] ^ c++);
                }
                if (temp == 0) {
                    cCount += 1;
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", t, trace, n - rCount, n - cCount);
        }
    }
}