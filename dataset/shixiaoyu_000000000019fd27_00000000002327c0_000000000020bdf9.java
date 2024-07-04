

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int testCases = s.nextInt();
        int caseNum = 1;
        Solution p = new Solution();

        while (caseNum <= testCases) {
            int n = s.nextInt();
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++)
                    a[i][j] = s.nextInt();
            }

            System.out.println(String.format("Case #%d: %s", caseNum, p.calShift(a)));

            caseNum++;
        }
    }

    private String calShift(int[][] schedule) {
        if (schedule == null || schedule.length == 0 || schedule[0].length == 0) {
            return null;
        }

        int row = schedule.length;
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            points.add(new Point(schedule[i][0], true));
            points.add(new Point(schedule[i][1], false));
        }

        Collections.sort(points);

        int overlapCount = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            if (p.isStart) {
                overlapCount++;
            } else {
                overlapCount--;
            }

            if (overlapCount == 1) {
                if (p.isStart) {
                    sb.append("C");
                }
            } else if (overlapCount == 2) {
                if (p.isStart) {
                    sb.append("J");
                }
            } else if (overlapCount == 0){
                continue;
            } else {
                return "IMPOSSIBLE";
            }
        }


        return sb.toString();
    }

    private class Point implements Comparable{
        public int val;
        public boolean isStart;

        public Point(int val, boolean isStart) {
            this.val = val;
            this.isStart = isStart;
        }

        // sort ascending, even start and end have the same value, doesn't matter
        public int compareTo(Object o) {
            return this.val - ((Point)o).val;
        }
    }
}
