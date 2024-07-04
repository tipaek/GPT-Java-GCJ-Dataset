
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
            points.add(new Point(schedule[i][0], true, i));
            points.add(new Point(schedule[i][1], false, i));
            boolean isDup = reverseLookup.containsKey(schedule[i][1]);
            assert isDup == false;
            reverseLookup.put(schedule[i][1], schedule[i][0]); // TODO: could be dup end time
        }

        Collections.sort(points);

        int overlapCount = 0;
        int[] availableCJs = new int[2];  // first is C, second is J, value is the start index
        List<Result> res = new ArrayList<>();

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
                        res.add(new Result("C", p.originalInputIndex));
                        availableCJs[0] = p.val;
                    } else if (availableCJs[1] == 0) {
                        availableCJs[1] = p.val;
                        res.add(new Result("J", p.originalInputIndex));
                    }
                }
            }
            else if (overlapCount == 2) {
                if (p.isStart) {
                    if (availableCJs[0] == 0) {
                        availableCJs[0] = p.val;
                        res.add(new Result("C", p.originalInputIndex));
                    } else if (availableCJs[1] == 0) {
                        availableCJs[1] = p.val;
                        res.add(new Result("J", p.originalInputIndex));
                    }
                }
            } else {
                return "IMPOSSIBLE";
            }

        }
        Collections.sort(res);

        StringBuilder sb = new StringBuilder();
        for (Result r : res) {
            sb.append(r.val);
        }
        return sb.toString();
    }

    private class Result implements Comparable {
        public String val;
        public int index;

        public Result(String val, int index) {
            this.val = val;
            this.index = index;
        }


        @Override
        public int compareTo(Object o) {
            return this.index - ((Result)o).index;
        }
    }

    private class Point implements Comparable {
        public int val;
        public boolean isStart;
        public int originalInputIndex;

        public Point(int val, boolean isStart, int index) {
            this.val = val;
            this.isStart = isStart;
            this.originalInputIndex = index;
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
