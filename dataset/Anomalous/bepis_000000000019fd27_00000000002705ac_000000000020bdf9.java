import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void main(String[] args) throws IOException {
        class TimeSlot implements Comparable<TimeSlot> {
            boolean isStart;
            int time;
            int jobId;

            public TimeSlot(boolean isStart, int time, int jobId) {
                this.isStart = isStart;
                this.time = time;
                this.jobId = jobId;
            }

            @Override
            public int compareTo(TimeSlot other) {
                if (this.time != other.time) {
                    return this.time - other.time;
                }
                return this.isStart ? -1 : 1;
            }
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            List<TimeSlot> slots = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] times = reader.readLine().trim().split("\\s+");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                slots.add(new TimeSlot(true, start, i + 1));
                slots.add(new TimeSlot(false, end, i + 1));
            }

            Collections.sort(slots);
            char[] assignments = new char[n];
            boolean isCFree = true;
            boolean isJFree = true;
            boolean possible = true;

            for (TimeSlot slot : slots) {
                if (slot.isStart) {
                    if (isCFree) {
                        assignments[slot.jobId - 1] = 'C';
                        isCFree = false;
                    } else if (isJFree) {
                        assignments[slot.jobId - 1] = 'J';
                        isJFree = false;
                    } else {
                        result.append("Case #").append(t).append(": IMPOSSIBLE\n");
                        possible = false;
                        break;
                    }
                } else {
                    if (assignments[slot.jobId - 1] == 'C') {
                        isCFree = true;
                    } else {
                        isJFree = true;
                    }
                }
            }

            if (possible) {
                result.append("Case #").append(t).append(": ").append(new String(assignments)).append("\n");
            }
        }

        System.out.print(result);
    }
}