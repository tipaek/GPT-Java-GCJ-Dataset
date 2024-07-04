import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            ArrayList<Schedule> schedules = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                schedules.add(new Schedule(scanner.nextInt(), scanner.nextInt(), i));
            }

            Collections.sort(schedules);
            boolean isImpossible = false;
            String previousPerson = "J";
            schedules.get(0).inCharge = previousPerson;

            for (int i = 1; i < schedules.size(); i++) {
                Schedule currentSchedule = schedules.get(i);
                String overlapping = findOverlapping(currentSchedule, schedules, i);

                if (overlapping.isEmpty()) {
                    currentSchedule.inCharge = previousPerson;
                } else if (overlapping.contains("J") && overlapping.contains("C")) {
                    isImpossible = true;
                    break;
                } else if (overlapping.contains("J")) {
                    previousPerson = "C";
                    currentSchedule.inCharge = previousPerson;
                } else {
                    previousPerson = "J";
                    currentSchedule.inCharge = previousPerson;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                String[] resultArray = new String[schedules.size()];
                for (Schedule schedule : schedules) {
                    resultArray[schedule.id] = schedule.inCharge;
                }
                String result = String.join("", resultArray);
                System.out.println("Case #" + t + ": " + result);
            }
        }
    }

    private static String findOverlapping(Schedule currentSchedule, ArrayList<Schedule> schedules, int boundary) {
        StringBuilder overlapping = new StringBuilder();

        for (int i = 0; i < boundary; i++) {
            if (schedules.get(i).overlaps(currentSchedule)) {
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

        boolean overlaps(Schedule other) {
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