import java.io.*;
import java.util.*;

class Solution {
    
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
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.clear();
                for (int j = 0; j < n; j++) {
                    set.add(a[i][j]);
                    if (i == j) {
                        trace += a[i][j];
                    }
                }
                if (set.size() < n) {
                    rCount += 1;
                }
            }
            for (int i = 0; i < n; i++) {
                set.clear();
                for (int j = 0; j < n; j++) {
                    set.add(a[j][i]);
                }
                if (set.size() < n) {
                    cCount += 1;
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", t, trace, rCount, cCount);
        }
    }
}