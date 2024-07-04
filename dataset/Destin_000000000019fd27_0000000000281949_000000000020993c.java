import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            int[] res = new int[3];
            int n = s.nextInt();
            int[][] mat = new int[n][n];
            ArrayList<HashSet<Integer>> rows = new ArrayList<HashSet<Integer>>();
            ArrayList<HashSet<Integer>> cols = new ArrayList<HashSet<Integer>>();
            boolean[] rowRepeat = new boolean[n];
            boolean[] colRepeat = new boolean[n];
            for (int i = 0; i < n; i++) {HashSet<Integer> set = new HashSet<Integer>();
                HashSet<Integer> row = new HashSet<Integer>();
                rows.add(row);
                for (int j = 0; j < n; j++) {
                    if (i == 0) {
                        HashSet<Integer> col = new HashSet<Integer>();
                        cols.add(col);
                    }
                    mat[i][j] = s.nextInt();
                    if (i == j) {
                        res[0] += mat[i][j];
                    }
                    if (!rowRepeat[i]) {
                        if (rows.get(i).contains(mat[i][j])) {
                            res[1] += 1;
                            rowRepeat[i] = true;
                        } else {
                            rows.get(i).add(mat[i][j]);
                        }
                    }
                    if (!colRepeat[j]) {
                        if (cols.get(j).contains(mat[i][j])) {
                            res[2] += 1;
                            colRepeat[j] = true;
                        } else {
                            cols.get(j).add(mat[i][j]);
                        }
                    }
                }
            }
            String result = "Case #" + t + ": " 
                            + res[0] + " "
                            + res[1] + " "
                            + res[2] + " ";
            System.out.println(result);
        }
    }
}