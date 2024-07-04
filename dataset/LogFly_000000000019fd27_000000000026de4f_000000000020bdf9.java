  
    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        List<Schedule> jSchedules = new ArrayList<>();
        List<Schedule> cSchedules = new ArrayList<>();
        StringBuilder result;
        int start;
        int end;
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            jSchedules.clear();
            cSchedules.clear();
            result = new StringBuilder();
            for (int j = 0; j < n; j++) {
                start = in.nextInt();
                end = in.nextInt();
                if (isAvailable(jSchedules, start, end)) {
                    jSchedules.add(new Schedule(start, end));
                    result.append("J");
                } else if (isAvailable(cSchedules, start, end)) {
                    cSchedules.add(new Schedule(start, end));
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
        for (int i = 0; i < schedules.size(); i++) {
            Schedule schedule = schedules.get(i);
            if (start < schedule.end && end > schedule.start) {
                result = false;
                break;
            }
        }
        return result;
    }
    }