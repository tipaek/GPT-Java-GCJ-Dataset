import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class ScheduleEntry implements Comparable<ScheduleEntry> {
    private int start;
    private int end;

    public ScheduleEntry(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public int compareTo(ScheduleEntry other) {
        return Integer.compare(this.start, other.start);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            List<ScheduleEntry> scheduleEntries = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                scheduleEntries.add(new ScheduleEntry(start, end));
            }

            Collections.sort(scheduleEntries);

            ScheduleEntry cSchedule = null;
            ScheduleEntry jSchedule = null;
            StringBuilder schedule = new StringBuilder();

            for (ScheduleEntry entry : scheduleEntries) {
                if (cSchedule == null || cSchedule.getEnd() <= entry.getStart()) {
                    cSchedule = entry;
                    schedule.append("C");
                } else if (jSchedule == null || jSchedule.getEnd() <= entry.getStart()) {
                    jSchedule = entry;
                    schedule.append("J");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            results[i] = schedule.toString();
        }

        for (int i = 0; i < testCases; i++) {
            System.out.printf("Case #%d: %s%n", i + 1, results[i]);
        }
    }
}