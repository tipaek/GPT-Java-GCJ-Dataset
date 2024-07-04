import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            HashSet<Integer> set = new HashSet<Integer>();
            int i1 = 0;
            int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
            for ( i1 = 1; i1 <= t; ++i1) {
                int k = 0, r = 0, c = 0;
                int n = in.nextInt();
                int[][] a = new int[n + 1][n + 1];
                for (int i = 1; i <= n; i++)
                    for (int j = 1; j <= n; j++)
                        a[i][j] = in.nextInt();
                for (int i = 1; i <= n; i++)
                    k += a[i][i];

                for(int i = 1; i <= n; i++) {
                    set.clear();
                    for (int j = 1; j <= n; j++) {
                        set.add(a[i][j]);
                    }
                    if(set.size() != n)
                        r++;
                }
                for(int i = 1; i <= n; i++) {
                    set.clear();
                    for (int j = 1; j <= n; j++) {
                        set.add(a[j][i]);
                    }
                    if(set.size() != n)
                        c++;
                }
                System.out.println("Case #" + i1 + ": " + (k) + " " + (r) + " " + (c));

            }

        }
        catch (Exception e) {
            ;
        }
    }
}

