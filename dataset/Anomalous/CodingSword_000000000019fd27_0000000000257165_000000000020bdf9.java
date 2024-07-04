import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            TimeSlot[] timeSlots = new TimeSlot[n];

            for (int i = 0; i < n; i++) {
                timeSlots[i] = new TimeSlot(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(timeSlots);

            String[] result = new String[n];
            String schedule = findSchedule(0, timeSlots, -1, -1, result);

            System.out.print("Case #" + t + ": ");
            if (schedule == null) {
                System.out.print("IMPOSSIBLE");
            } else {
                for (String res : result) {
                    System.out.print(res);
                }
            }
            System.out.println();
        }
        scanner.close();
    }

    private static String findSchedule(int i, TimeSlot[] timeSlots, int c, int j, String[] result) {
        if (i >= timeSlots.length) {
            return "";
        }

        if (c == -1) {
            String temp = findSchedule(i + 1, timeSlots, i, j, result);
            if (temp != null) {
                result[timeSlots[i].index] = "C";
                return "C" + temp;
            }
        } else if (j == -1) {
            String temp = findSchedule(i + 1, timeSlots, c, i, result);
            if (temp != null) {
                result[timeSlots[i].index] = "J";
                return "J" + temp;
            }
        } else {
            if (timeSlots[i].start >= timeSlots[c].end) {
                String temp = findSchedule(i + 1, timeSlots, i, j, result);
                if (temp != null) {
                    result[timeSlots[i].index] = "C";
                    return "C" + temp;
                }
            } else if (timeSlots[i].start >= timeSlots[j].end) {
                String temp = findSchedule(i + 1, timeSlots, c, i, result);
                if (temp != null) {
                    result[timeSlots[i].index] = "J";
                    return "J" + temp;
                }
            }
        }
        return null;
    }

    static class TimeSlot implements Comparable<TimeSlot> {
        int start, end, index;

        TimeSlot(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(TimeSlot other) {
            if (this.start == other.start) {
                return this.end - other.end;
            } else {
                return this.start - other.start;
            }
        }
    }
}