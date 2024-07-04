import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static class TimeSlot {
        int start;
        int end;
    }

    public static void main(String[] args) {
        int T = scanner.nextInt();
        String[] results = new String[T];
        
        for (int i = 0; i < T; i++) {
            results[i] = processTestCase(i + 1);
        }
        
        for (String result : results) {
            System.out.println(result);
        }
    }

    public static String processTestCase(int testOrder) {
        int N = scanner.nextInt();
        TimeSlot[] timeSlots = new TimeSlot[N];
        
        for (int i = 0; i < N; i++) {
            timeSlots[i] = new TimeSlot();
            timeSlots[i].start = scanner.nextInt();
            timeSlots[i].end = scanner.nextInt();
        }

        StringBuilder result = new StringBuilder("Case #" + testOrder + ": ");
        List<TimeSlot> assignedToC = new ArrayList<>();
        List<TimeSlot> assignedToJ = new ArrayList<>();
        
        char[] assignments = new char[N];
        assignments[0] = 'C';
        assignedToC.add(timeSlots[0]);

        boolean possible = true;

        for (int i = 1; i < N; i++) {
            TimeSlot current = timeSlots[i];
            if (canAssign(current, assignedToC)) {
                assignedToC.add(current);
                assignments[i] = 'C';
            } else if (canAssign(current, assignedToJ)) {
                assignedToJ.add(current);
                assignments[i] = 'J';
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            for (char assignment : assignments) {
                result.append(assignment);
            }
        } else {
            result.append("IMPOSSIBLE");
        }

        return result.toString();
    }

    private static boolean canAssign(TimeSlot current, List<TimeSlot> assigned) {
        for (TimeSlot slot : assigned) {
            if (current.start < slot.end && current.end > slot.start) {
                return false;
            }
        }
        return true;
    }
}