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
            Time[] times = new Time[n];
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int j = 0; j < n; j++) {
                String[] input = buff.readLine().split("\\s+");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                startTimes[j] = start;
                endTimes[j] = end;
                times[j] = new Time(start, end, j);
            }

            int maxOverlap = maxOverlapIntervalCount(startTimes, endTimes);
            if (maxOverlap > 2) {
                System.out.println("Case #" + test + ": Impossible");
            } else {
                Arrays.sort(times, new TimeComparator());
                ArrayList<Integer> startList = new ArrayList<>();
                ArrayList<Integer> endList = new ArrayList<>();
                ArrayList<Integer> indexList = new ArrayList<>();

                for (Time time : times) {
                    startList.add(time.startTime);
                    endList.add(time.endTime);
                    indexList.add(time.index);
                }

                HashMap<Integer, Character> mapper = new HashMap<>();
                mapper.put(endList.get(0), 'C');
                char[] result = new char[n];
                result[indexList.get(0)] = 'C';

                for (int i = 1; i < endList.size(); i++) {
                    int index = Collections.binarySearch(endList, startList.get(i));

                    if (index < 0) {
                        index = -index - 1;
                        char assignedChar = mapper.getOrDefault(endList.get(index), 'C');
                        char newChar = (assignedChar == 'C') ? 'J' : 'C';
                        result[indexList.get(i)] = newChar;
                        mapper.put(endList.get(i), newChar);
                    } else {
                        char assignedChar = mapper.get(endList.get(index));
                        char newChar = (assignedChar == 'C') ? 'J' : 'C';
                        result[indexList.get(i)] = newChar;
                        mapper.put(endList.get(i), newChar);
                    }
                }

                StringBuilder sb = new StringBuilder();
                for (char c : result) {
                    sb.append(c);
                }
                System.out.println("Case #" + test + ": " + sb.toString());
            }
        }
    }
}