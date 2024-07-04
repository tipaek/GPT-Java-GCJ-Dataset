import java.io.*;
import java.util.*;

public class Solution {

    static class TimeSlot {
        int start;
        int end;

        TimeSlot(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start + "," + end + ")";
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activities = scanner.nextInt();

            List<TimeSlot> cameron = new ArrayList<>();
            List<TimeSlot> jamie = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < activities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (schedule.toString().equals("IMPOSSIBLE")) {
                    continue;
                }

                int cameronIndex = findAvailableSlot(cameron, start, end);
                int jamieIndex = findAvailableSlot(jamie, start, end);

                if (cameronIndex >= 0) {
                    schedule.append("C");
                    cameron.add(cameronIndex, new TimeSlot(start, end));
                } else if (jamieIndex >= 0) {
                    schedule.append("J");
                    jamie.add(jamieIndex, new TimeSlot(start, end));
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + testCase + ": " + schedule);
        }
    }

    private static int findAvailableSlot(List<TimeSlot> schedule, int start, int end) {
        if (schedule.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < schedule.size(); i++) {
            TimeSlot current = schedule.get(i);

            if (i == 0 && end <= current.start) {
                return i;
            }

            if (i == schedule.size() - 1 && start >= current.end) {
                return i + 1;
            }

            if (i > 0) {
                TimeSlot previous = schedule.get(i - 1);
                if (start >= previous.end && end <= current.start) {
                    return i;
                }
            }

            if (i < schedule.size() - 1) {
                TimeSlot next = schedule.get(i + 1);
                if (start >= current.end && end <= next.start) {
                    return i;
                }
            }
        }

        return -1;
    }
}