import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int k = 0;
            int r = 0;
            int c = 0;

            int[][] cc = new int[n][];
            for (int j=0; j < n; j++)
                cc[j] = new int[n];

            for (int row=0; row < n; row++) {
                int[] rc = new int[n];

                for (int col=0; col < n; col++) {
                    int val = in.nextInt();

                    if (rc != null) {
                        if (rc[val - 1]++ >= 1) {
                            rc = null;
                            r++;
                        }
                    }
                    if (cc[col] != null) {
                        if (cc[col][val - 1]++ >= 1) {
                            cc[col] = null;
                            c++;
                        }
                    }

                    if (row == col) {
                        k +=val;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", i, k, r, c);
        }
    }
}

