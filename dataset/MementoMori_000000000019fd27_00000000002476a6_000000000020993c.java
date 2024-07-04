import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int k = 1; k <= t; ++k) {
            int n = in.nextInt();
            int trace = 0;
            Map<Integer, List<Integer>> rowValues = new HashMap<>();
            Map<Integer, List<Integer>> columnValues = new HashMap<>();
            List<Integer> ignoredRows = new ArrayList<>();
            List<Integer> ignoredColumns = new ArrayList<>();
            int repeatableRows = 0;
            int repeatableColumns = 0;
            int[][] maxtrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                rowValues.computeIfAbsent(i, k1 -> new ArrayList<>());
                for (int j = 0; j < n; j++) {
                    columnValues.computeIfAbsent(j, k1 -> new ArrayList<>());
                    maxtrix[i][j] = in.nextInt();
                    if (i == j) {
                        trace += maxtrix[i][j];
                    }
                    if (!ignoredRows.contains(i)) {
                        final List<Integer> rowI = rowValues.get(i);
                        if (rowI.contains(maxtrix[i][j])) {
                            repeatableRows++;
                            ignoredRows.add(i);
                        } else {
                            rowI.add(maxtrix[i][j]);
                        }
                    }
                    if (!ignoredColumns.contains(j)) {
                        final List<Integer> columnJ = columnValues.get(j);
                        if (columnJ.contains(maxtrix[i][j])) {
                            repeatableColumns++;
                            ignoredColumns.add(j);
                        } else {
                            columnJ.add(maxtrix[i][j]);
                        }
                    }
                }
            }
            System.out.println(String.format("Case #%d: %d %d %d", k, trace, repeatableRows, repeatableColumns));
        }
    }
}