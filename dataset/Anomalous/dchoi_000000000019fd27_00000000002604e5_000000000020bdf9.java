import java.io.*;
import java.util.*;

public class Solution {

    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activities = scanner.nextInt();
            List<Interval> cameronSchedule = new ArrayList<>();
            List<Interval> jamieSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < activities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (result.toString().equals("IMPOSSIBLE")) {
                    continue;
                }

                int cameronIndex = findAvailableSlot(cameronSchedule, start, end);
                int jamieIndex = findAvailableSlot(jamieSchedule, start, end);

                if (cameronIndex >= 0) {
                    result.append("C");
                    cameronSchedule.add(cameronIndex, new Interval(start, end));
                } else if (jamieIndex >= 0) {
                    result.append("J");
                    jamieSchedule.add(jamieIndex, new Interval(start, end));
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static int findAvailableSlot(List<Interval> schedule, int start, int end) {
        if (schedule.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < schedule.size(); i++) {
            Interval current = schedule.get(i);

            if (i == 0 && end <= current.start) {
                return i;
            }

            if (i == schedule.size() - 1 && start >= current.end) {
                return i + 1;
            }

            if (i > 0) {
                Interval previous = schedule.get(i - 1);
                if (start >= previous.end && end <= current.start) {
                    return i;
                }
            }
        }

        return -1;
    }
}