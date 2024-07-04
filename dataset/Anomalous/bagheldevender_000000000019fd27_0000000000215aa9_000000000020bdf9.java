import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        StringBuilder resultBuilder = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            int n = scn.nextInt();
            resultBuilder.append("Case #").append(t + 1).append(": ");
            int[][] intervals = new int[n][2];
            Interval[] intervalArr = new Interval[n];
            int[] arrivals = new int[n];
            int[] departures = new int[n];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scn.nextInt();
                intervals[i][1] = scn.nextInt();
                arrivals[i] = intervals[i][0];
                departures[i] = intervals[i][1];
                intervalArr[i] = new Interval(intervals[i][0], intervals[i][1], i);
            }

            Arrays.sort(intervalArr);
            int minPlatformsRequired = calculateMinPlatforms(arrivals, departures);

            if (minPlatformsRequired > 2) {
                resultBuilder.append("IMPOSSIBLE");
            } else if (minPlatformsRequired == 1) {
                for (int i = 0; i < n; i++) {
                    resultBuilder.append("C");
                }
            } else {
                int previousEnd = intervalArr[0].end;
                int currentAssignment = 0;
                HashMap<Integer, Integer> assignmentMap = new HashMap<>();
                assignmentMap.put(intervalArr[0].index, 0);

                for (int i = 1; i < intervalArr.length; i++) {
                    int start = intervalArr[i].start;
                    int end = intervalArr[i].end;

                    if (start >= previousEnd) {
                        assignmentMap.put(intervalArr[i].index, currentAssignment);
                    } else {
                        currentAssignment = 1 - currentAssignment;
                        assignmentMap.put(intervalArr[i].index, currentAssignment);
                    }
                    previousEnd = end;
                }

                for (int i = 0; i < n; i++) {
                    resultBuilder.append(assignmentMap.get(i) == 0 ? "C" : "J");
                }
            }
            resultBuilder.append("\n");
        }

        System.out.println(resultBuilder);
    }

    public static int calculateMinPlatforms(int[] arrivals, int[] departures) {
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int platformCount = 0;
        int maxPlatforms = 0;
        int i = 0, j = 0;

        while (i < arrivals.length) {
            if (arrivals[i] < departures[j]) {
                platformCount++;
                maxPlatforms = Math.max(maxPlatforms, platformCount);
                i++;
            } else {
                platformCount--;
                j++;
            }
        }

        return maxPlatforms;
    }

    public static class Interval implements Comparable<Interval> {
        int start;
        int end;
        int index;

        public Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Interval other) {
            if (this.start != other.start) {
                return this.start - other.start;
            } else {
                return this.end - other.end;
            }
        }
    }
}