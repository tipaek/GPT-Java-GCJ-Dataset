import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int times = scanner.nextInt();
        for (int t = 1; t <= times; t++) {
            int k = 0, r = 0, c = 0;
            int n = scanner.nextInt();
            int[][] m = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = scanner.nextInt();
                }
            }

            Map<Integer, Set<Integer>> row = new HashMap<>();
            Map<Integer, Set<Integer>> col = new HashMap<>();
            for (int i = 0; i < n; i++) {
                row.put(i, new HashSet<>());
                col.put(i, new HashSet<>());
            }

            boolean[] row_repeat = new boolean[n];
            boolean[] col_repeat = new boolean[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        k += m[i][j];
                    if (!row_repeat[i]) {
                        if (!row.get(i).add(m[i][j])) {
                            row_repeat[i] = true;
                            r++;
                        }
                    }
                    if (!col_repeat[j]) {
                        if (!col.get(j).add(m[i][j])) {
                            col_repeat[j] = true;
                            c++;
                        }
                    }
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", t, k, r, c));
        }
    }

}