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
        } else {
            return Integer.compare(t1.startTime, t2.startTime);
        }
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
                Arrays.fill(assignments, 'J');

                TreeMap<Integer, Integer> endTimeToStartTime = new TreeMap<>();
                TreeMap<Integer, Integer> endTimeToIndex = new TreeMap<>();

                for (Time interval : intervals) {
                    if (endTimeToStartTime.containsKey(interval.endTime)) {
                        if (interval.startTime > endTimeToStartTime.get(interval.endTime)) {
                            endTimeToStartTime.put(interval.endTime, interval.startTime);
                            endTimeToIndex.put(interval.endTime, interval.index);
                        }
                    } else {
                        endTimeToStartTime.put(interval.endTime, interval.startTime);
                        endTimeToIndex.put(interval.endTime, interval.index);
                    }
                }

                List<Integer> endTimesList = new ArrayList<>(endTimeToStartTime.keySet());
                assignments[endTimeToIndex.get(endTimesList.get(0))] = 'C';

                int currentIndex = 0;
                for (int i = 1; i < endTimesList.size(); i++) {
                    int endTime = endTimesList.get(i);
                    if (endTimeToStartTime.get(endTime) >= endTimesList.get(currentIndex)) {
                        currentIndex = i;
                        assignments[endTimeToIndex.get(endTime)] = 'C';
                    }
                }

                StringBuilder result = new StringBuilder();
                for (char assignment : assignments) {
                    result.append(assignment);
                }

                System.out.println("Case #" + test + ": " + result.toString());
            }
        }
    }
}