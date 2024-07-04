import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    public static class TimeRange {
        private int startTime;
        private int endTime;

        public TimeRange(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public boolean overlapsWith(TimeRange other) {
            return (other.startTime < this.endTime && other.startTime >= this.startTime) ||
                   (other.endTime > this.startTime && other.endTime <= this.endTime) ||
                   (other.startTime <= this.startTime && other.endTime >= this.endTime);
        }
    }

    public static class Schedule {
        private List<TimeRange> bookedSlots = new ArrayList<>();

        public boolean addSlot(TimeRange newSlot) {
            for (TimeRange slot : bookedSlots) {
                if (slot.overlapsWith(newSlot)) {
                    return false;
                }
            }
            bookedSlots.add(newSlot);
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            Schedule cameronSchedule = new Schedule();
            Schedule jamieSchedule = new Schedule();

            int activities = scanner.nextInt();
            StringBuilder result = new StringBuilder();

            for (int activity = 0; activity < activities; activity++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                TimeRange newActivity = new TimeRange(startTime, endTime);

                if (result.toString().equals("IMPOSSIBLE")) {
                    continue;
                }

                if (cameronSchedule.addSlot(newActivity)) {
                    result.append("C");
                } else if (jamieSchedule.addSlot(newActivity)) {
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}