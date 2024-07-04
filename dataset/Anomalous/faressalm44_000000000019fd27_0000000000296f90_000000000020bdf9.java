import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static class TimeSlot {
        int start;
        int end;
        String name;
    }

    public static void main(String[] args) {
        int T = scanner.nextInt();
        String[] results = new String[T];
        for (int i = 0; i < T; i++) {
            results[i] = processElevatorSchedule(i + 1);
        }
        for (int i = 0; i < T; i++) {
            System.out.print(results[i]);
            if (i != T - 1) {
                System.out.println();
            }
        }
    }

    public static String processElevatorSchedule(int testOrder) {
        int N = scanner.nextInt();
        TimeSlot[] timeSlots = new TimeSlot[N];
        for (int i = 0; i < N; i++) {
            timeSlots[i] = new TimeSlot();
        }

        StringBuilder result = new StringBuilder();
        result.append("Case #").append(testOrder).append(": ");

        for (int i = 0; i < N; i++) {
            timeSlots[i].start = scanner.nextInt();
            timeSlots[i].end = scanner.nextInt();
        }

        boolean possible = true;
        timeSlots[0].name = "C";

        for (int i = 1; i < N; i++) {
            boolean cConflict = false, jConflict = false;

            for (int k = 0; k < i; k++) {
                if (timeSlots[i].start < timeSlots[k].end && timeSlots[i].end > timeSlots[k].start) {
                    if ("C".equals(timeSlots[k].name)) {
                        cConflict = true;
                    } else {
                        jConflict = true;
                    }
                }
            }

            if (!jConflict && cConflict) {
                timeSlots[i].name = "J";
            } else if (jConflict && !cConflict) {
                timeSlots[i].name = "C";
            } else if (!jConflict && !cConflict) {
                timeSlots[i].name = timeSlots[i - 1].name;
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            for (int i = 0; i < N; i++) {
                result.append(timeSlots[i].name);
            }
        } else {
            result.append("IMPOSSIBLE");
        }

        return result.toString();
    }
}