import java.util.*;

class TimeSlot implements Comparable<TimeSlot> {
    int id;
    int start;
    int end;

    TimeSlot(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(TimeSlot other) {
        return Integer.compare(this.start, other.start);
    }
}

public class Scheduler {

    public static String allocateSchedules(TimeSlot[] timeSlots) {
        char[] assignments = new char[timeSlots.length];
        Arrays.sort(timeSlots);
        int cameronEnd = 0;
        int jamieEnd = 0;

        for (TimeSlot slot : timeSlots) {
            if (cameronEnd <= slot.start) {
                assignments[slot.id] = 'C';
                cameronEnd = slot.end;
            } else if (jamieEnd <= slot.start) {
                assignments[slot.id] = 'J';
                jamieEnd = slot.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(assignments);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(scanner.nextLine());
            TimeSlot[] timeSlots = new TimeSlot[n];

            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                timeSlots[i] = new TimeSlot(i, start, end);
            }

            String result = allocateSchedules(timeSlots);
            System.out.println("Case #" + t + ": " + result);
        }
    }
}