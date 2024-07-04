import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
                entries.add(new ScheduleEntry(input.nextInt(), input.nextInt()));
            }

            entries = entries.stream().sorted().collect(Collectors.toList());

            ScheduleEntry cSchedule = null;
            ScheduleEntry jSchedule = null;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (cSchedule == null) {
                    cSchedule = entries.get(j);
                    sb.append("C");
                } else if (jSchedule == null) {
                    jSchedule = entries.get(j);
                    sb.append("J");
                } else {
                    if (cSchedule.getEnd() <= entries.get(j).getStart()) {
                        cSchedule = entries.get(j);
                        sb.append("C");
                    } else if (jSchedule.getEnd() <= entries.get(j).getStart()) {
                        jSchedule = entries.get(j);
                        sb.append("J");
                    } else {
                        sb = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }

            result[i] = sb.toString();
        }

        for (int i = 0; i < t; i++) {
            System.out.println(result[i]);
        }


    }
}
