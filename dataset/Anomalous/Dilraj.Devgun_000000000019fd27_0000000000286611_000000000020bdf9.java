import java.util.*;

public class Solution {

    static class TimeSlot {
        int end;
        int index;

        public TimeSlot(int end, int index) {
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            processTestCase(scanner, i);
        }
    }

    public static void processTestCase(Scanner scanner, int caseNumber) {
        int numActivities = scanner.nextInt();
        Map<Integer, TimeSlot> activities = new TreeMap<>();
        char[] schedule = new char[numActivities];
        String result = "";

        for (int i = 0; i < numActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.put(start, new TimeSlot(end, i));
        }

        int cEnd = 0, jEnd = 0;
        for (Map.Entry<Integer, TimeSlot> entry : activities.entrySet()) {
            int start = entry.getKey();
            TimeSlot slot = entry.getValue();

            if (start >= cEnd) {
                schedule[slot.index] = 'C';
                cEnd = slot.end;
            } else if (start >= jEnd) {
                schedule[slot.index] = 'J';
                jEnd = slot.end;
            } else {
                result = "IMPOSSIBLE";
                break;
            }
        }

        if (result.isEmpty()) {
            result = new String(schedule);
        }

        System.out.println("Case #" + caseNumber + ": " + result);
    }
}