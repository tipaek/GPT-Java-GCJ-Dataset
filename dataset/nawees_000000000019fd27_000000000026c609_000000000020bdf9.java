import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.valueOf(scanner.nextLine());
        int size = 0;
        String[] schedule = new String[2];
        List<Schedule> schedules;
        String result = "";
        Schedule previousC, previousJ;
        for (int i = 1; i <= total; i++) {
            result = "CJ";
            size = Integer.valueOf(scanner.nextLine());

            schedules = new ArrayList<>();
            for (int k = 0; k < size; k++) {
                if (size <= 2) {
                    break;
                }
                String line = scanner.nextLine();
                schedule = line.split(" ");
                schedules.add(new Schedule(Integer.valueOf(schedule[0]), Integer.valueOf(schedule[1])));
            }
            if (size > 2) {
                Collections.sort(schedules);
                boolean possible = true;
                int idx = 2;
                previousC = schedules.get(0);
                previousJ = schedules.get(1);
                Schedule cur;

                while (possible && (idx < size)) {
                    cur = schedules.get(idx);
                    if (previousC.isDuplicateWith(cur)) {
                        if (previousJ.isDuplicateWith(cur)) {
                            possible = false;
                            result = "IMPOSSIBLE";
                        } else {
                            previousJ = cur;
                            result += "J";
                        }
                    } else {
                        previousC = cur;
                        result += "C";
                    }
                    idx++;
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static class Schedule implements Comparable<Schedule> {
        public Integer start;
        public Integer end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Schedule s) {
            return this.start.compareTo(s.start);
        }

        public boolean isDuplicateWith(Schedule s) {
            return this.start > s.end || this.end > s.start;
        }
    }


}