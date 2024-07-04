import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;
            List<Set<Integer>> columnSets = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicates = false;
                for (int j = 0; j < n; j++) {
                    int value = sc.nextInt();
                    if (i == j) {
                        trace += value;
                    }
                    mat[i][j] = value;
                    if (!rowSet.add(value)) {
                        rowHasDuplicates = true;
                    }
                    if (i == 0) {
                        columnSets.add(new HashSet<>());
                    }
                    columnSets.get(j).add(value);
                }
                if (rowHasDuplicates) {
                    duplicateRows++;
                }
            }

            for (Set<Integer> colSet : columnSets) {
                if (colSet.size() != n) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        sc.close();
    }
}