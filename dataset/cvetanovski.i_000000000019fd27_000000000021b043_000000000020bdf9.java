import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public int compareTo(ScheduleEntry o) {
        return Integer.compare(getStart(), o.getStart());
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        String[] result = new String[t];

        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            List<ScheduleEntry> entries = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                entries.add(new ScheduleEntry(j + 1, input.nextInt(), input.nextInt()));
            }

            entries = entries.stream().sorted().collect(Collectors.toList());

            ScheduleEntry cSchedule = null;
            ScheduleEntry jSchedule = null;
            boolean impossible = false;

            List<ScheduleEntry> scheduleEntryList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (cSchedule == null) {
                    cSchedule = entries.get(j);
                    scheduleEntryList.add(entries.get(j));
                    scheduleEntryList.get(j).setName("C");
                } else if (jSchedule == null) {
                    jSchedule = entries.get(j);
                    scheduleEntryList.add(entries.get(j));
                    scheduleEntryList.get(j).setName("J");
                } else {
                    if (cSchedule.getEnd() <= entries.get(j).getStart()) {
                        cSchedule = entries.get(j);
                        scheduleEntryList.add(entries.get(j));
                        scheduleEntryList.get(j).setName("C");
                    } else if (jSchedule.getEnd() <= entries.get(j).getStart()) {
                        jSchedule = entries.get(j);
                        scheduleEntryList.add(entries.get(j));
                        scheduleEntryList.get(j).setName("J");
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }

            if (!impossible) {
                scheduleEntryList = scheduleEntryList.stream().sorted(Comparator.comparingInt(ScheduleEntry::getId)).collect(Collectors.toList());
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < scheduleEntryList.size(); j++) {
                    sb.append(scheduleEntryList.get(j).getName());
                }
                result[i] = sb.toString();
            } else {
                result[i] = "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println(String.format("Case #%d: %s", i+1, result[i]));
        }


    }
}
