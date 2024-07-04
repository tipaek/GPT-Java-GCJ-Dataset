import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            ArrayList<TimeSlot> timeSlots = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().trim().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                timeSlots.add(new TimeSlot(start, end, i));
            }

            Collections.sort(timeSlots);

            int endJ = 0;
            int endC = 0;
            boolean impossible = false;

            for (TimeSlot timeSlot : timeSlots) {
                if (endJ <= timeSlot.start) {
                    timeSlot.assignedTo = 'J';
                    endJ = timeSlot.end;
                } else if (endC <= timeSlot.start) {
                    timeSlot.assignedTo = 'C';
                    endC = timeSlot.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                char[] result = new char[n];
                for (TimeSlot timeSlot : timeSlots) {
                    result[timeSlot.originalIndex] = timeSlot.assignedTo;
                }
                System.out.println("Case #" + caseNum + ": " + new String(result));
            }
        }

        scanner.close();
    }

    private static class TimeSlot implements Comparable<TimeSlot> {
        int start;
        int end;
        int originalIndex;
        char assignedTo = 'u';

        TimeSlot(int start, int end, int originalIndex) {
            this.start = start;
            this.end = end;
            this.originalIndex = originalIndex;
        }

        @Override
        public int compareTo(TimeSlot other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }
}