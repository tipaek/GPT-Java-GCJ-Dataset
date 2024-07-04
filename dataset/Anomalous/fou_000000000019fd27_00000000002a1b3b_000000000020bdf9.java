import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int scheduleCount = scanner.nextInt();
            ArrayList<Schedule> schedules = new ArrayList<>(scheduleCount);

            for (int i = 0; i < scheduleCount; i++) {
                schedules.add(new Schedule(scanner.nextInt(), scanner.nextInt(), i));
            }

            Collections.sort(schedules);

            boolean isImpossible = false;
            String lastAssigned = "J";
            schedules.get(0).inCharge = lastAssigned;

            for (int i = 1; i < schedules.size(); i++) {
                Schedule currentSchedule = schedules.get(i);
                String overlappingAssignments = getOverlappingAssignments(currentSchedule, schedules, i);

                if (overlappingAssignments.isEmpty()) {
                    currentSchedule.inCharge = lastAssigned;
                } else if (overlappingAssignments.contains("J") && overlappingAssignments.contains("C")) {
                    isImpossible = true;
                    break;
                } else if (overlappingAssignments.contains("J")) {
                    lastAssigned = "C";
                    currentSchedule.inCharge = lastAssigned;
                } else {
                    lastAssigned = "J";
                    currentSchedule.inCharge = lastAssigned;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                String[] output = new String[schedules.size()];

                for (Schedule schedule : schedules) {
                    output[schedule.id] = schedule.inCharge;
                }

                for (String s : output) {
                    result.append(s);
                }

                System.out.println("Case #" + testCase + ": " + result.toString());
            }
        }
    }

    private static String getOverlappingAssignments(Schedule schedule, ArrayList<Schedule> schedules, int boundary) {
        StringBuilder overlapping = new StringBuilder();

        for (int i = 0; i < boundary; i++) {
            if (schedules.get(i).overlapsWith(schedule)) {
                overlapping.append(schedules.get(i).inCharge);
            }
        }

        return overlapping.toString();
    }

    private static class Schedule implements Comparable<Schedule> {
        int start, end, id;
        String inCharge = "";

        public Schedule(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        boolean overlapsWith(Schedule other) {
            return (other.start < this.end && other.end > this.start);
        }

        @Override
        public int compareTo(Schedule other) {
            return Integer.compare(this.start, other.start);
        }

        @Override
        public String toString() {
            return start + " - " + end + " = " + id + " - " + inCharge;
        }
    }
}