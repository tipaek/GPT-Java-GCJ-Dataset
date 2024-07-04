
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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
        Map<Integer, Integer> reverseLookup = new HashMap<>(); // key is the end, value is the start, this is used later to populate the correct C/J value

        for (int i = 0; i < row; i++) {
            points.add(new Point(schedule[i][0], true));
            points.add(new Point(schedule[i][1], false));
            reverseLookup.put(schedule[i][1], schedule[i][0]); // TODO: could be dup end time
        }

        Collections.sort(points);

        int overlapCount = 0;
        StringBuilder sb = new StringBuilder();
        int[] availableCJs = new int[2];  // first is C, second is J, value is the start index

        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            if (p.isStart) {
                overlapCount++;
            } else {
                overlapCount--;
                int startIndex = reverseLookup.get(p.val);
                if (availableCJs[0] == startIndex) {
                    availableCJs[0] = 0;
                }
                if (availableCJs[1] == startIndex) {
                    availableCJs[1] = 0;
                }
            }

            if (overlapCount == 0) {
                continue;
            }  else if (overlapCount == 1) {
                if (p.isStart) {
                    if (availableCJs[0] == 0) {
                        sb.append("C");
                        availableCJs[0] = p.val;
                    } else if (availableCJs[1] == 0) {
                        sb.append("J");
                        availableCJs[1] = p.val;
                    }
                }
            }
            else if (overlapCount == 2) {
                if (p.isStart) {
                    if (availableCJs[0] == 0) {
                        sb.append("C");
                        availableCJs[0] = p.val;
                    } else if (availableCJs[1] == 0) {
                        sb.append("J");
                        availableCJs[1] = p.val;
                    }
                }
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

        public int compareTo(Object o) {
            Point p = (Point)o;

            int diff = this.val - p.val;
            if (diff != 0) {
                return diff;
            } else {
                if (this.isStart) {  // I want the start point to show later, because the overlap doesn't count as conflict
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
}
