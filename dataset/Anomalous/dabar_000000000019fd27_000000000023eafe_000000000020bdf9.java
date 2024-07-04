import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfCases; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            List<String> data = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                data.add(scanner.nextLine());
            }

            TestCase testCase = new TestCase(size, data);
            String result = testCase.getResult();
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    static class Schedule {
        final int order;
        final int start;
        final int end;

        Schedule(int order, int start, int end) {
            this.order = order;
            this.start = start;
            this.end = end;
        }
    }

    static class ScheduleByTimeComparer implements Comparator<Schedule> {
        @Override
        public int compare(Schedule a, Schedule b) {
            int startComparison = Integer.compare(a.start, b.start);
            return startComparison != 0 ? startComparison : Integer.compare(a.end, b.end);
        }
    }

    static class TestCase {
        private final int size;
        private final List<String> data;
        private static final ScheduleByTimeComparer scheduleByTimeComparer = new ScheduleByTimeComparer();

        TestCase(int size, List<String> data) {
            this.size = size;
            this.data = data;
        }

        String getResult() {
            List<Schedule> schedules = new ArrayList<>();
            for (String row : data) {
                String[] parts = row.split(" ");
                schedules.add(new Schedule(schedules.size(), Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
            }

            Collections.sort(schedules, scheduleByTimeComparer);

            char[] result = new char[size];
            int cEnd = 0;
            int jEnd = 0;

            for (Schedule schedule : schedules) {
                if (cEnd <= schedule.start) {
                    cEnd = schedule.end;
                    result[schedule.order] = 'C';
                } else if (jEnd <= schedule.start) {
                    jEnd = schedule.end;
                    result[schedule.order] = 'J';
                } else {
                    return "IMPOSSIBLE";
                }
            }

            return new String(result);
        }
    }
}