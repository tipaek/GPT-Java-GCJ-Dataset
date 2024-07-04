/*
https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020993c

in:
3
4
1 2 3 4
2 1 4 3
3 4 1 2
4 3 2 1
4
2 2 2 2
2 3 2 3
2 2 2 3
2 2 2 2
3
2 1 3
1 3 2
1 2 3

out:
Case #1: 4 0 0
Case #2: 9 4 4
Case #3: 8 0 2
*/

import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int a0 = 1; a0 <= t; a0++) {
            int n = in.nextInt();
            int res_rows = 0;
            int res_cols = 0;
            int trace = 0;
            
            BitSet[] columns = new BitSet[n];
            for (int i = 0; i < n; i++) columns[i] = new BitSet(n);
            
            for (int i = 0; i < n; i++) {
                BitSet row = new BitSet(n);
                for (int j = 0; j < n; j++) {
                    int a = in.nextInt();
                    row.set(a-1);
                    columns[j].set(a-1);
                    if (i == j) trace += a;
                }
                if (row.cardinality() != n) res_rows++;
            }

            for (BitSet i : columns) if (i.cardinality() != n) res_cols++;

            System.out.println("Case #" + a0 + ": " + trace + " " + res_rows + " " + res_cols);
        }
    }
}
