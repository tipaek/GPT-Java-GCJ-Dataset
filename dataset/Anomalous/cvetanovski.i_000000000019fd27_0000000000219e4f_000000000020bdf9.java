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

    public int getEnd() {
        return end;
    }

    @Override
    public int compareTo(ScheduleEntry other) {
        return Integer.compare(this.start, other.start);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String[] results = new String[t];

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            List<ScheduleEntry> entries = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                entries.add(new ScheduleEntry(scanner.nextInt(), scanner.nextInt()));
            }

            Collections.sort(entries);

            ScheduleEntry cSchedule = null;
            ScheduleEntry jSchedule = null;
            StringBuilder scheduleBuilder = new StringBuilder();

            for (ScheduleEntry entry : entries) {
                if (cSchedule == null || cSchedule.getEnd() <= entry.getStart()) {
                    cSchedule = entry;
                    scheduleBuilder.append("C");
                } else if (jSchedule == null || jSchedule.getEnd() <= entry.getStart()) {
                    jSchedule = entry;
                    scheduleBuilder.append("J");
                } else {
                    scheduleBuilder = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            results[i] = scheduleBuilder.toString();
        }

        for (String result : results) {
            System.out.println(result);
        }

        scanner.close();
    }
}