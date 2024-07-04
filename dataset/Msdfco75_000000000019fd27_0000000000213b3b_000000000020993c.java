
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int tr = 0, r = 0, c = 0;
            int[][] d = new int[n][n];
            for (int j = 0; j < n; j++) {
                TreeSet<Integer> m = new TreeSet<>();
                for (int j2 = 0; j2 < n; j2++) {
                    d[j][j2] = in.nextInt();
                    if (j == j2)
                        tr += d[j][j2];
                    m.add(d[j][j2]);
                }
                if (m.size() != n)
                    r++;
            }
            for (int j = 0; j < d.length; j++) {
                TreeSet<Integer> m = new TreeSet<>();
                for (int j2 = 0; j2 < d.length; j2++) {
                    m.add(d[j2][j]);
                }
                if (m.size() != n)
                    c++;
            }

            System.out.println("Case #" + (i + 1) + ": " + tr + " " + r + " " + c);
        }
    }

}
