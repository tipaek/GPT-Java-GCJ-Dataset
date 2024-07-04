import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class ScheduleEntry implements Comparable<ScheduleEntry> {
    private int id;
    private int start;
    private int end;
    private String name;

    public ScheduleEntry(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                entries.add(new ScheduleEntry(j + 1, scanner.nextInt(), scanner.nextInt()));
            }

            entries.sort(Comparator.naturalOrder());

            ScheduleEntry cSchedule = null;
            ScheduleEntry jSchedule = null;
            boolean isImpossible = false;
            List<ScheduleEntry> scheduleList = new ArrayList<>();

            for (ScheduleEntry entry : entries) {
                if (cSchedule == null) {
                    cSchedule = entry;
                    entry.setName("C");
                } else if (jSchedule == null) {
                    jSchedule = entry;
                    entry.setName("J");
                } else if (cSchedule.getEnd() <= entry.getStart()) {
                    cSchedule = entry;
                    entry.setName("C");
                } else if (jSchedule.getEnd() <= entry.getStart()) {
                    jSchedule = entry;
                    entry.setName("J");
                } else {
                    isImpossible = true;
                    break;
                }
                scheduleList.add(entry);
            }

            if (!isImpossible) {
                scheduleList.sort(Comparator.comparingInt(ScheduleEntry::getId));
                StringBuilder scheduleBuilder = new StringBuilder();
                for (ScheduleEntry entry : scheduleList) {
                    scheduleBuilder.append(entry.getName());
                }
                results[i] = scheduleBuilder.toString();
            } else {
                results[i] = "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println(String.format("Case #%d: %s", i + 1, results[i]));
        }

        scanner.close();
    }
}