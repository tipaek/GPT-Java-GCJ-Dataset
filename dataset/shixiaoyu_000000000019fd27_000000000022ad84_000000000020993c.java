

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int testCases = s.nextInt();
        int caseNum = 1;
        Solution vestigium = new Solution();

        while (caseNum <= testCases) {
            int n = s.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    a[i][j] = s.nextInt();
            }

            Result r = vestigium.cal(a);
            System.out.println(String.format("Case #%d: %d %d %d", caseNum, r.diagnalSum, r.dupRowCount, r.dupColCount));

            caseNum++;
        }
    }

    private Result cal(int[][] a) {
        if (a == null || a.length == 0 || a[0].length == 0) {
            return null;
        }

        int row = a.length;
        int col = a[0].length;

        List<Set> colList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            colList.add(new HashSet<Integer>());
        }


        Set<Integer> rowSet = new HashSet<>();
        int diagnolSum = 0;
        int dupRow = 0;
        int dupCol = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == j) {
                    diagnolSum += a[i][j];
                }
                rowSet.add(a[i][j]);
                colList.get(j).add(a[i][j]);
            }
            if (rowSet.size() != row) {
                dupRow++;
            }
            rowSet.clear();
        }

        for (Set<Integer> s : colList) {
            if (s.size() != row) {
                dupCol++;
            }
        }

        return new Result(diagnolSum, dupRow, dupCol);
    }

    private class Result {
        int diagnalSum = 0;
        int dupRowCount = 0;
        int dupColCount = 0;

        public Result(int ds, int drc, int dcc) {
            this.diagnalSum = ds;
            this.dupRowCount = drc;
            this.dupColCount = dcc;
        }
    }
}
