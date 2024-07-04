import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = 0;
            long r = 0, c;

            HashSet<Integer>[] colSets = new HashSet[n];

            for (int i1 = 0; i1 < n; i1++) {
                colSets[i1] = new HashSet<>();
            }

            for (int i1 = 0; i1 < n; i1++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int i2 = 0; i2 < n; i2++) {
                    int m_ij = in.nextInt();

                    if (i1 == i2) {
                        k += m_ij;
                    }

                    rowSet.add(m_ij);
                    colSets[i2].add(m_ij);
                }
                if (rowSet.size() < n) r++;
            }

            c = Arrays.stream(colSets).filter(s -> s.size() < n).count();

            System.out.println(String.format("Case #%d: %d %d %d", i, k, r, c));
        }
    }
}