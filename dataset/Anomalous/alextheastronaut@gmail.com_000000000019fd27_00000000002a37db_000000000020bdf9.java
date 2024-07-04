import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter(System.out)) {

            int numCases = Integer.parseInt(br.readLine());
            for (int i = 1; i <= numCases; i++) {
                int numTimes = Integer.parseInt(br.readLine());
                Time[] times = new Time[numTimes];
                for (int j = 0; j < numTimes; j++) {
                    String[] timeInput = br.readLine().split(" ");
                    times[j] = new Time(Integer.parseInt(timeInput[0]), Integer.parseInt(timeInput[1]));
                }

                Time[] sortedTimes = Arrays.copyOf(times, times.length);
                Arrays.sort(sortedTimes);
                pw.println("Case #" + i + ": " + assignTasks(sortedTimes, times));
            }
        }
    }

    static String assignTasks(Time[] sortedTimes, Time[] originalTimes) {
        StringBuilder result = new StringBuilder();
        Time c = null, j = null;

        for (Time t : sortedTimes) {
            if (c == null || c.end <= t.start) {
                c = t;
                t.owner = 'C';
            } else if (j == null || j.end <= t.start) {
                j = t;
                t.owner = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (Time t : originalTimes) {
            result.append(t.owner);
        }

        return result.toString();
    }

    static class Time implements Comparable<Time> {
        int start, end;
        char owner = 'b';

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time other) {
            return Integer.compare(this.start, other.start);
        }
    }
}