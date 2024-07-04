

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] mat = new int[n][n];

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    mat[x][y] = in.nextInt();
                }
            }
            int[] res = solve(mat);
            System.out.println("Case #" + i + ": " + res[0] + " " + res[1] + " " + res[2]);
        }
    }

    public static int[] solve(int[][] mat) {
        int[] res = new int[3];
        int n = mat.length;

        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    res[0] += mat[i][j];
                }

                Set<Integer> rowSet = rows.getOrDefault(i, new HashSet<>());
                Set<Integer> colSet = cols.getOrDefault(j, new HashSet<>());

                rowSet.add(mat[i][j]);
                colSet.add(mat[i][j]);

                rows.put(i, rowSet);
                cols.put(j, colSet);
            }
        }

        for (int i : rows.keySet()) {
            if (rows.get(i).size() != n) {
                res[1]++;
            }
            if (cols.get(i).size() != n) {
                res[2]++;
            }
        }
        return res;
    }
}
