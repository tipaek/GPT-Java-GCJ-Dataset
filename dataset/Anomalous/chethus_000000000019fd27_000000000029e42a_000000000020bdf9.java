import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numTasks = Integer.parseInt(reader.readLine());
            PriorityQueue<Event> events = new PriorityQueue<>();

            for (int task = 0; task < numTasks; task++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int startTime = Integer.parseInt(tokenizer.nextToken());
                int endTime = Integer.parseInt(tokenizer.nextToken());
                events.offer(new Event(startTime, true, task));
                events.offer(new Event(endTime, false, task));
            }

            boolean cAvailable = true;
            boolean jAvailable = true;
            char[] assignments = new char[numTasks];
            boolean possible = true;

            while (!events.isEmpty() && possible) {
                Event currentEvent = events.poll();
                if (!currentEvent.isStart) {
                    if (assignments[currentEvent.index] == 'C') {
                        cAvailable = true;
                    } else {
                        jAvailable = true;
                    }
                } else {
                    if (!cAvailable && !jAvailable) {
                        possible = false;
                    } else {
                        if (cAvailable) {
                            assignments[currentEvent.index] = 'C';
                            cAvailable = false;
                        } else {
                            assignments[currentEvent.index] = 'J';
                            jAvailable = false;
                        }
                    }
                }
            }

            String result = possible ? new String(assignments) : "IMPOSSIBLE";
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    static class Event implements Comparable<Event> {
        int time;
        boolean isStart;
        int index;

        Event(int time, boolean isStart, int index) {
            this.time = time;
            this.isStart = isStart;
            this.index = index;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time != other.time) {
                return Integer.compare(this.time, other.time);
            } else {
                return Boolean.compare(!this.isStart, !other.isStart);
            }
        }
    }
}