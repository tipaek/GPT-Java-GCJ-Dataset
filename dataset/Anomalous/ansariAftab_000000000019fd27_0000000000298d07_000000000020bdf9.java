import java.util.*;

class Schedule {
    int start;
    int end;

    Schedule(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int numSchedules = scanner.nextInt();
            List<Schedule> schedules = new ArrayList<>();
            Map<Integer, Character> assignments = new TreeMap<>();
            Map<Schedule, Integer> scheduleIndexMap = new HashMap<>();

            for (int i = 0; i < numSchedules; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Schedule schedule = new Schedule(start, end);
                schedules.add(schedule);
                scheduleIndexMap.put(schedule, i);
            }

            schedules.sort(Comparator.comparingInt(s -> s.end));

            int camEndTime = 0;
            int jamEndTime = 0;
            boolean isPossible = true;

            for (Schedule schedule : schedules) {
                int index = scheduleIndexMap.get(schedule);
                if (schedule.start >= camEndTime) {
                    camEndTime = schedule.end;
                    assignments.put(index, 'C');
                } else if (schedule.start >= jamEndTime) {
                    jamEndTime = schedule.end;
                    assignments.put(index, 'J');
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (char assignment : assignments.values()) {
                    result.append(assignment);
                }
                System.out.println("Case #" + t + ": " + result.toString());
            }
        }

        scanner.close();
    }
}