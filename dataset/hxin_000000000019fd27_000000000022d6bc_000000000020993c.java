import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int n = in.nextInt();
            int k = 0;
            int r = 0;
            int c = 0;
            Set<Integer>[] colSet;
            colSet = new HashSet[n];
            for (int i = 0; i < n; i ++)
                colSet[i] = new HashSet();
            boolean[] colDup = new boolean[n];

            for (int i = 0; i < n; i ++) {
                Set<Integer> rowSet = new HashSet();
                boolean rowDup = false;
                for (int j = 0; j < n; j ++) {
                    int v = in.nextInt();
                    if (i == j) k += v;
                    if (!rowDup) {
                        if(rowSet.contains(v)) {
                            rowDup = true;
                            r++;
                        }
                        else
                            rowSet.add(v);
                    }
                    if(!colDup[j]) {
                        if(colSet[j].contains(v)) {
                            colDup[j] = true;
                            c++;
                        }
                        else {
                            colSet[j].add(v);
                        }

                    }
                }
            }

            System.out.println("Case #" + t + ": " +k + " " + r + " "+c);
        }
    }
}