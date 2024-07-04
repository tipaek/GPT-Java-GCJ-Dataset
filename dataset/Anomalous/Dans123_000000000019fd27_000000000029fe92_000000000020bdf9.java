import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        ArrayList<TimeSlot> schedule = new ArrayList<>();

        for (int i = 0; i < numberOfTestCases; i++) {
            int numberOfSlots = scanner.nextInt();
            for (int j = 0; j < numberOfSlots; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                schedule.add(new TimeSlot(start, end));
            }
            Calendar calendar = new Calendar();
            calendar.solve(schedule, testCaseNumber++);
            schedule.clear();
        }
    }
}

class TimeSlot {
    int start;
    int end;

    TimeSlot(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Calendar {
    private static final String CASEY = "C";
    private static final String JAMIE = "J";

    public void solve(ArrayList<TimeSlot> schedule, int testCaseNumber) {
        StringBuilder assignments = new StringBuilder();
        ArrayList<TimeSlot> caseySchedule = new ArrayList<>();
        ArrayList<TimeSlot> jamieSchedule = new ArrayList<>();

        for (TimeSlot slot : schedule) {
            if (isFree(caseySchedule, slot)) {
                assignments.append(CASEY);
                caseySchedule.add(new TimeSlot(slot.start, slot.end));
            } else if (isFree(jamieSchedule, slot)) {
                assignments.append(JAMIE);
                jamieSchedule.add(new TimeSlot(slot.start, slot.end));
            } else {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
        }
        System.out.println("Case #" + testCaseNumber + ": " + assignments.toString());
    }

    private boolean isFree(ArrayList<TimeSlot> schedule, TimeSlot slot) {
        for (TimeSlot existingSlot : schedule) {
            if ((slot.start < existingSlot.end && slot.start >= existingSlot.start) ||
                (slot.end <= existingSlot.end && slot.end > existingSlot.start)) {
                return false;
            }
        }
        return true;
    }
}