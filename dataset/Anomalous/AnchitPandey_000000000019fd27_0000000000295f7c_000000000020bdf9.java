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
    @Override
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());

        for (int test = 1; test <= testCaseCount; test++) {
            int n = Integer.parseInt(reader.readLine());
            Time[] intervals = new Time[n];
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split("\\s+");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                startTimes[i] = start;
                endTimes[i] = end;
                intervals[i] = new Time(start, end, i);
            }

            int maxOverlap = maxOverlapIntervalCount(startTimes, endTimes);
            if (maxOverlap > 2) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            } else {
                Arrays.sort(intervals, new TimeComparator());
                char[] assignments = new char[n];
                Arrays.fill(assignments, 'J');

                TreeMap<Integer, Integer> endToStartMap = new TreeMap<>();
                TreeMap<Integer, Integer> endToIndexMap = new TreeMap<>();

                for (Time interval : intervals) {
                    if (endToStartMap.containsKey(interval.endTime)) {
                        if (interval.startTime > endToStartMap.get(interval.endTime)) {
                            endToStartMap.put(interval.endTime, interval.startTime);
                            endToIndexMap.put(interval.endTime, interval.index);
                        }
                    } else {
                        endToStartMap.put(interval.endTime, interval.startTime);
                        endToIndexMap.put(interval.endTime, interval.index);
                    }
                }

                List<Integer> endTimesList = new ArrayList<>(endToStartMap.keySet());
                List<Integer> startTimesList = new ArrayList<>(endToStartMap.values());

                assignments[endToIndexMap.get(endTimesList.get(0))] = 'C';
                int current = 0;

                for (int i = 1; i < endTimesList.size(); i++) {
                    int endTime = endTimesList.get(i);
                    if (endToStartMap.get(endTime) >= endTimesList.get(current)) {
                        current = i;
                        assignments[endToIndexMap.get(endTime)] = 'C';
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