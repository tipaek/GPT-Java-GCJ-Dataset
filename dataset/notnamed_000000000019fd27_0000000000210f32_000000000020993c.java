import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = in.nextInt();
            long s = 0;
            int rc = 0, cc = 0;
            Set<Integer>[] cols = new HashSet[n];
            for (int i = 0; i < n; i++) {
                cols[i] = new HashSet<>();
            }
            for (int i = 0; i < n; i++) {
                HashSet<Integer> row = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int x = in.nextInt();
                    row.add(x);
                    cols[j].add(x);
                    if (i == j) {
                        s += x;
                    }
                }
                if (row.size() < n) {
                    ++rc;
                }
            }
            for (int i = 0; i < n; i++) {
                if (cols[i].size() < n) {
                    ++cc;
                }
            }
            System.out.println("Case #" + t + ": " + s + " " + rc + " " + cc);
        }
    }
}
