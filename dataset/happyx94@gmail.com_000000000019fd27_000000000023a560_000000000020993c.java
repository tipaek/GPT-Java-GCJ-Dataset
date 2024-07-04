import java.util.*;
import java.io.*;

public class Solution {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int caseNumber = 1; caseNumber <= t; ++caseNumber) {
            final int n = in.nextInt();
            final ArrayList<Set<Integer>> cols = new ArrayList<>();
            for (int i = 0; i < n; i++) cols.add(new HashSet<>());

            int k = 0, r = 0, c = 0;

            for (int i = 0; i < n; i++) {
                final Set<Integer> row = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int num = in.nextInt();
                    if (i == j) k += num;
                    row.add(num);
                    cols.get(j).add(num);
                }
                if (row.size() != n) r++;
            }

            for (Set<Integer> col: cols) {
                if (col.size() != n) c++;
            }
            System.out.println("Case #" + caseNumber + ": " + k + " " + r + " " + c);
        }
    }
}