import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] m = new int[n][n];
            int faultyColumns = 0;
            int faultyRows = 0;
            int diag = 0;
            for (int j = 0; j < n; j++) {
                for (int j2 = 0; j2 < n; j2++) {
                    m[j][j2] = in.nextInt();
                }
            }
            for (int j = 0; j < n; j++) {
                HashSet<Integer> rowitems = new HashSet<>();
                HashSet<Integer> colitems = new HashSet<>();
                boolean faultyrow = false;
                boolean faultycolumn = false;
                for (int j2 = 0; j2 < n; j2++) {
                    if (rowitems.contains(m[j][j2])) {
                        faultyrow = true;
                    } else {
                        rowitems.add(m[j][j2]);
                    }
                    if (colitems.contains(m[j2][j])) {
                        faultycolumn = true;
                    } else {
                        colitems.add(m[j2][j]);
                    }
                }
                diag += m[j][j];
                if (faultyrow) faultyRows++;
                if (faultycolumn) faultyColumns++;
            }
            System.out.println("Case #" + i + ": " + diag + " " + faultyRows + " " + faultyColumns);
        }
        in.close();
    }
}