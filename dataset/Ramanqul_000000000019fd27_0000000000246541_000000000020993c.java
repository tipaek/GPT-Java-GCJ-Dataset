import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();

            int tr = 0, r = 0, c = 0;

            int[][] cols = new int[n+1][n+1];

            for (int j=0;j<n;j++) {
                int rows[] = new int[n+1];


                for (int k=0;k<n;k++) {
                    int x = in.nextInt();

                    if (j == k) {
                        tr += x;
                    }

                    if (cols[k] != null) {
                        if (cols[k][x] > 0) {
                            c++;
                            cols[k] = null;
                        } else {
                            cols[k][x]++;
                        }
                    }

                    if (rows != null) {
                        if (rows[x] > 0) {
                            r++;
                            rows = null;
                        } else {
                            rows[x]++;
                        }
                    }

                }
            }

            System.out.printf("Case #%d: %d %d %d\n", i, tr, r, c);
        }
    }
}