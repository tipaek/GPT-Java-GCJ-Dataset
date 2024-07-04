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
        List<Owner> owners;
        String result = "";
        Schedule previousC, previousJ;
        for (int i = 1; i <= total; i++) {
            size = Integer.valueOf(scanner.nextLine());
            owners = new ArrayList<>();
            result = "";
            schedules = new ArrayList<>();
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
                Collections.sort(schedules);
                int idx = 2;
                previousC = schedules.get(0);
                owners.add(new Owner(previousC.index, "C"));
                previousJ = schedules.get(1);
                owners.add(new Owner(previousJ.index, "J"));

                Schedule cur;

                while (possible && (idx < size)) {
                    cur = schedules.get(idx);
                    if (previousC.isDuplicateWith(cur)) {
                        if (previousJ.isDuplicateWith(cur)) {
                            possible = false;
                            result = "IMPOSSIBLE";
                        } else {
                            previousJ = cur;
                            owners.add(new Owner(previousJ.index, "J"));
                        }
                    } else {
                        previousC = cur;
                        owners.add(new Owner(previousC.index, "C"));
                    }
                    idx++;
                }
            }

            if (!owners.isEmpty() && possible) {
                Collections.sort(owners);
                for (int k = 0; k < owners.size(); k++) {
                    result += owners.get(k).owner;
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
    static class Owner implements Comparable<Owner> {
        public Integer index;
        public String owner;

        public Owner(int index, String owner) {
            this.index = index;
            this.owner = owner;
        }

        @Override
        public int compareTo(Owner o) {
            return this.index.compareTo(o.index);
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