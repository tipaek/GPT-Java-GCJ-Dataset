import java.util.*;

public class Solution {

    static class TimeSlot implements Comparable<TimeSlot> {
        int start;
        int end;

        public TimeSlot(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(TimeSlot other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            TimeSlot[] timeSlots = new TimeSlot[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                timeSlots[i] = new TimeSlot(start, end);
            }

            Arrays.sort(timeSlots);

            TimeSlot cameron = new TimeSlot(0, 0);
            TimeSlot james = new TimeSlot(0, 0);
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;

            for (TimeSlot slot : timeSlots) {
                if (slot.start >= cameron.end) {
                    schedule.append("C");
                    cameron = slot;
                } else if (slot.start >= james.end) {
                    schedule.append("J");
                    james = slot;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + t + ": " + schedule);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}