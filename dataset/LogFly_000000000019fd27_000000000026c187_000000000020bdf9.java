  
    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Schedule> jSchedules = new ArrayList<>();
            List<Schedule> cSchedules = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                if (isAvailable(jSchedules, start, end)) {
                    jSchedules.add(new Schedule(start, end));
                    jSchedules.sort(Comparator.comparing(schedule -> schedule.start));
                    result.append("J");
                } else if (isAvailable(cSchedules, start, end)) {
                    cSchedules.add(new Schedule(start, end));
                    cSchedules.sort(Comparator.comparing(schedule -> schedule.start));
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }

    static class Schedule {
        public int start;
        public int end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static boolean isAvailable(List<Schedule> schedules, int start, int end) {
        boolean result = true;
        for (Schedule schedule : schedules) {
            if (start < schedule.end && end > schedule.start) {
                result = false;
                break;
            } else if (end < schedule.start) {
                break;
            }
        }
        return result;
    }
    }