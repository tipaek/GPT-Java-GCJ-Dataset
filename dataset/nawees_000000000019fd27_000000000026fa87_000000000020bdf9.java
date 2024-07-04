
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.valueOf(scanner.nextLine());
        int size = 0;
        String[] schedule;
        Queue<Schedule> schedules;
        String[] owners;
        String result;
        Schedule previousC, previousJ;
        for (int i = 1; i <= total; i++) {
            size = Integer.valueOf(scanner.nextLine());
            owners = new String[size];
            result = "";
            schedules = new PriorityQueue<>();
            for (int k = 0; k < size; k++) {
                if (size <= 2) {
                    result = "CJ";
                    break;
                }
                String line = scanner.nextLine();
                schedule = line.split(" ");
                schedules.add(new Schedule(Integer.valueOf(schedule[0]), Integer.valueOf(schedule[1]), k));
            }
            boolean possible = true;

            if (size > 2) {
                int idx = 2;
                previousC = schedules.poll();
                owners[previousC.index] = "C";
                previousJ = schedules.poll();
                owners[previousJ.index] = "J";
                Schedule cur;

                while (possible && (idx < size)) {
                    cur = schedules.poll();
                    if (previousC.isDuplicateWith(cur)) {
                        if (previousJ.isDuplicateWith(cur)) {
                            possible = false;
                            result = "IMPOSSIBLE";
                        } else {
                            previousJ = cur;
                            owners[previousJ.index] = "J";

                        }
                    } else {
                        previousC = cur;
                        owners[previousC.index] = "C";
                    }
                    idx++;
                }

                if(possible) {
                    for (int l = 0; l < size; l++) {
                        result += owners[l];
                    }
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static class Schedule implements Comparable<Schedule> {
        public Integer start;
        public Integer end;
        public Integer index;

        public Schedule(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
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
