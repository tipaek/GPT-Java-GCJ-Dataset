  
    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] mij = new int[n][n];
            for (int mi = 0; mi < n; mi++) {
                for (int mj = 0; mj < n; mj++) {
                    mij[mi][mj] = in.nextInt();
                }
            }

            int traces = 0;
            int r = 0;
            int c = 0;
            for (int mi = 0; mi < n; mi++) {
                Set<Integer> rows = new HashSet<>();
                Set<Integer> columns = new HashSet<>();
                for (int mj = 0; mj < n; mj++) {
                    if (rows != null) {
                        if (rows.contains(mij[mi][mj])) {
                            r++;
                            rows = null;
                        } else {
                            rows.add(mij[mi][mj]);
                        }
                    }
                    if (columns != null) {
                        if (columns.contains(mij[mj][mi])) {
                            c++;
                            columns = null;
                        } else {
                            columns.add(mij[mj][mi]);
                        }
                    }
                    if (mi == mj) {
                        traces += mij[mi][mj];
                    }
                }
            }

            System.out.println("Case #" + i + ": " + (traces) + " " + (r) + " " + (c));
        }
      }
    }