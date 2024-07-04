import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void main(String[] args) throws IOException {
        class Event implements Comparable<Event> {
            boolean isStart;
            int time;
            int jobId;

            public Event(boolean isStart, int time, int jobId) {
                this.isStart = isStart;
                this.time = time;
                this.jobId = jobId;
            }

            @Override
            public int compareTo(Event other) {
                if (this.time != other.time) {
                    return Integer.compare(this.time, other.time);
                } else {
                    return Boolean.compare(other.isStart, this.isStart);
                }
            }
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            List<Event> events = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] times = reader.readLine().trim().split("\\s+");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                events.add(new Event(true, start, i));
                events.add(new Event(false, end, i));
            }
            Collections.sort(events);

            char[] schedule = new char[n];
            boolean isCFree = true;
            boolean isJFree = true;
            boolean possible = true;

            for (Event event : events) {
                if (event.isStart) {
                    if (isCFree) {
                        schedule[event.jobId] = 'C';
                        isCFree = false;
                    } else if (isJFree) {
                        schedule[event.jobId] = 'J';
                        isJFree = false;
                    } else {
                        System.out.println("Case #" + t + ": IMPOSSIBLE");
                        possible = false;
                        break;
                    }
                } else {
                    if (schedule[event.jobId] == 'C') {
                        isCFree = true;
                    } else {
                        isJFree = true;
                    }
                }
            }

            if (possible) {
                System.out.println("Case #" + t + ": " + new String(schedule));
            }
        }
    }
}