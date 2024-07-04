import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();

            List<TimeSlot> cameron = new ArrayList<>();
            List<TimeSlot> jamie = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (result.toString().equals("IMPOSSIBLE")) {
                    continue;
                }

                int cameronIndex = findAvailableSlot(cameron, start, end);
                int jamieIndex = findAvailableSlot(jamie, start, end);

                if (cameronIndex >= 0) {
                    result.append("C");
                    cameron.add(cameronIndex, new TimeSlot(start, end));
                } else if (jamieIndex >= 0) {
                    result.append("J");
                    jamie.add(jamieIndex, new TimeSlot(start, end));
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static int findAvailableSlot(List<TimeSlot> slots, int start, int end) {
        if (slots.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < slots.size(); i++) {
            TimeSlot current = slots.get(i);

            if (i == 0 && end <= current.start) {
                return i;
            }

            if (i == slots.size() - 1 && start >= current.end) {
                return i + 1;
            }

            if (i > 0) {
                TimeSlot previous = slots.get(i - 1);
                if (start >= previous.end && end <= current.start) {
                    return i;
                }
            }
        }

        return -1;
    }
}