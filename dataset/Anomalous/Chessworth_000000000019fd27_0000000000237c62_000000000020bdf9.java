import java.util.*;
import java.io.*;

class Solution {

    public static int getPriority(List<Integer> schedule, int start, int end) {
        if (schedule.isEmpty()) {
            return 0;
        }

        int priority = 0;
        for (int i = 0; i < schedule.size(); i += 2) {
            int taskStart = schedule.get(i);
            int taskEnd = schedule.get(i + 1);

            if (i == 0 && end <= taskStart) {
                priority = taskStart - end;
                break;
            } else if (start >= taskEnd) {
                if (i == schedule.size() - 2) {
                    priority = start - taskEnd;
                    break;
                } else if (end <= schedule.get(i + 2)) {
                    priority = (schedule.get(i + 2) - end) + (start - taskEnd);
                    break;
                }
            } else {
                priority = 24 * 60 + 1; // A large value to indicate conflict
            }
        }

        return priority;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            List<Integer> jamieSchedule = new ArrayList<>();
            List<Integer> cameronSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (j == 0) {
                    jamieSchedule.add(start);
                    jamieSchedule.add(end);
                    result.append('J');
                } else {
                    int jamiePriority = getPriority(jamieSchedule, start, end);
                    int cameronPriority = getPriority(cameronSchedule, start, end);

                    if (jamiePriority <= cameronPriority && jamiePriority != 24 * 60 + 1) {
                        jamieSchedule.add(start);
                        jamieSchedule.add(end);
                        Collections.sort(jamieSchedule);
                        result.append('J');
                    } else if (jamiePriority == 24 * 60 + 1 && cameronPriority == 24 * 60 + 1) {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        continue;
                    } else {
                        cameronSchedule.add(start);
                        cameronSchedule.add(end);
                        Collections.sort(cameronSchedule);
                        result.append('C');
                    }
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }
}