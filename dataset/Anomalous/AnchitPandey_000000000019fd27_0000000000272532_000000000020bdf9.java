import java.io.*;
import java.util.*;

class Time {
    int startTime, endTime, index;

    Time(int startTime, int endTime, int index) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.index = index;
    }
}

class TimeComparator implements Comparator<Time> {
    public int compare(Time t1, Time t2) {
        if (t1.endTime != t2.endTime) {
            return Integer.compare(t1.endTime, t2.endTime);
        }
        return Integer.compare(t1.startTime, t2.startTime);
    }
}

class Solution {
    public static int maxOverlapIntervalCount(int[] start, int[] end) {
        int maxOverlap = 0;
        int currentOverlap = 0;
        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0, j = 0;
        int m = start.length, n = end.length;

        while (i < m && j < n) {
            if (start[i] < end[j]) {
                currentOverlap++;
                maxOverlap = Math.max(maxOverlap, currentOverlap);
                i++;
            } else {
                currentOverlap--;
                j++;
            }
        }
        return maxOverlap;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(buff.readLine());

        for (int test = 1; test <= testcase; test++) {
            int n = Integer.parseInt(buff.readLine());
            Time[] intervals = new Time[n];
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int j = 0; j < n; j++) {
                String[] input = buff.readLine().split("\\s+");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                startTimes[j] = start;
                endTimes[j] = end;
                intervals[j] = new Time(start, end, j);
            }

            int maxOverlap = maxOverlapIntervalCount(startTimes, endTimes);
            if (maxOverlap > 2) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            } else {
                Arrays.sort(intervals, new TimeComparator());
                char[] assignments = new char[n];
                Map<Integer, Character> endTimeToCharMap = new HashMap<>();
                endTimeToCharMap.put(intervals[0].endTime, 'C');
                assignments[intervals[0].index] = 'C';

                for (int i = 1; i < n; i++) {
                    int startTime = intervals[i].startTime;
                    int endTime = intervals[i].endTime;
                    int index = intervals[i].index;

                    int pos = Collections.binarySearch(Arrays.asList(intervals).subList(0, i), new Time(startTime, 0, 0), Comparator.comparingInt(t -> t.endTime));
                    if (pos < 0) {
                        pos = -pos - 1;
                    }

                    char assignedChar = 'C';
                    if (pos < i && endTimeToCharMap.get(intervals[pos].endTime) == 'C') {
                        assignedChar = 'J';
                    }

                    assignments[index] = assignedChar;
                    endTimeToCharMap.put(endTime, assignedChar);
                }

                StringBuilder result = new StringBuilder();
                for (char c : assignments) {
                    result.append(c);
                }
                System.out.println("Case #" + test + ": " + result.toString());
            }
        }
    }
}