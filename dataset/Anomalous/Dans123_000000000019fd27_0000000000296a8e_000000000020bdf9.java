import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        Scanner scanner = createScanner();
        int numberOfTestCases = scanner.nextInt();
        ArrayList<TimeSlot> schedule = new ArrayList<>();

        for (int i = 0; i < numberOfTestCases; ++i) {
            int numSlots = scanner.nextInt();
            for (int j = 0; j < numSlots; ++j) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                schedule.add(new TimeSlot(start, end));
            }
            Calendar calendar = new Calendar();
            calendar.solve(schedule, testCaseNumber++);
            schedule.clear();
        }
    }

    private static Scanner createScanner() {
        return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
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
    private static final String C = "C";
    private static final String J = "J";

    public void solve(ArrayList<TimeSlot> schedule, int testCase) {
        StringBuilder assignments = new StringBuilder();
        ArrayList<TimeSlot> cSchedule = new ArrayList<>();
        ArrayList<TimeSlot> jSchedule = new ArrayList<>();

        for (TimeSlot slot : schedule) {
            if (isFree(cSchedule, slot)) {
                assignments.append(C);
                cSchedule.add(new TimeSlot(slot.start, slot.end));
            } else if (isFree(jSchedule, slot)) {
                assignments.append(J);
                jSchedule.add(new TimeSlot(slot.start, slot.end));
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                return;
            }
        }
        System.out.println("Case #" + testCase + ": " + assignments.toString());
    }

    private boolean isFree(ArrayList<TimeSlot> schedule, TimeSlot slot) {
        for (TimeSlot s : schedule) {
            if ((slot.start < s.end && slot.start > s.start) || (slot.end < s.end && slot.end > s.start)) {
                return false;
            }
        }
        return true;
    }
}