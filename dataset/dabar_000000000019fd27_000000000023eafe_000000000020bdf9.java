import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System. in);
        String input = scanner.nextLine();
        int numOfCases = Integer.parseInt(input);
        for(int i=0;i<numOfCases;i++) {
            input = scanner.nextLine();
            int size = Integer.parseInt(input);
            List<String> data = new ArrayList<>();
            for (int j =0;j<size;j++) {
                data.add(scanner.nextLine());
            }
            TestCase tc = new TestCase(size, data);
            String result = tc.getResult();
            System.out.println("Case #"+(i+1)+": "+result);
        }

    }

    public static class Schedule {
        final int order;
        final int start;
        final int end;
        
        public Schedule(int order, int start, int end) {
            this.order = order;
            this.start = start;
            this.end = end;
        }
    }

    public static class ScheduleByTimeComparer implements Comparator<Schedule> {
        @Override
        public int compare(Schedule a, Schedule b) {
            int startComparison = compare(a.start, b.start);
            return startComparison != 0 ? startComparison
                    : compare(a.end, b.end);
        }
        private static int compare(int a, int b) {
            return a < b ? -1
                    : a > b ? 1
                    : 0;
        }
    }
    
    public static class TestCase {
        private final int size;
        private final List<String> data;
        private static ScheduleByTimeComparer scheduleByTimeComparer = new ScheduleByTimeComparer();
        public TestCase(int size, List<String> data) {
            this.size = size;
            this.data = data;
        }

        private String getResult() {
            List<Schedule> schedules = new ArrayList<>();
            for (int i=0;i<size;i++) {
                String[] row = data.get(i).split(" ");
                schedules.add(new Schedule(i, Integer.parseInt(row[0]), Integer.parseInt(row[1])));
            }
            //sort by start time
            Collections.sort(schedules, scheduleByTimeComparer);
            char[] result = new char[size];
            int cEnd=0;
            int jEnd=0;
            for (int i=0;i<size;i++) {
                Schedule schedule = schedules.get(i);
                if (cEnd<=schedule.start) {
                    cEnd=schedule.end;
                    result[schedule.order] = 'C';
                } else if (jEnd<=schedule.start) {
                    jEnd=schedule.end;
                    result[schedule.order] = 'J';
                } else {
                    return "IMPOSSIBLE";
                }
            }


            return new String(result);
        }
    }
}