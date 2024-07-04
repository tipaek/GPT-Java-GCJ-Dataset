package cj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//       int n = in.nextInt();
//       int m = in.nextInt();
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();
            int sum = 0;
            int r = 0;
            int c = 0;
            List<Set<Integer>> columnSets = new ArrayList();
            Set<Integer> rowSet;
            Set<Integer> columnSet;
            rowSet = new HashSet<>();
            boolean rb = false;
            boolean[] cb = new boolean[N];
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (columnSets.size()>j) {
                        columnSet = columnSets.get(j);
                    } else {
                        columnSet = new HashSet<>();
                        columnSets.add(columnSet);
                    }
                    int n = in.nextInt();
                    if (i == j) sum += n;
                    if (rowSet.contains(n)&&rb==false) {
                        ++r;
                        rb = true;
                    }
                    rowSet.add(n);
                    if (columnSet.contains(n) && cb[j]==false) {
                        ++c;
                        cb[j] = true;
                    }
                    columnSet.add(n);
                }
                rb = false;
                rowSet.clear();
            }
            System.out.println("Case #"+t+": "+sum+" "+r+" "+c);
        }
    }
}
