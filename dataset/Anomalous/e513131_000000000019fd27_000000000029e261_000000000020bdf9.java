import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            boolean isImpossible = false;
            int activityCount = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            List<Integer> cSchedule = new ArrayList<>();
            List<Integer> jSchedule = new ArrayList<>();

            for (int j = 0; j < activityCount; j++) {
                if (isImpossible) {
                    isImpossible = false;
                }
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isConflict(start, end, cSchedule) && isConflict(start, end, jSchedule)) {
                    isImpossible = true;
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    break;
                } else if (!isConflict(start, end, cSchedule) && !isConflict(start, end, jSchedule) && !isImpossible) {
                    addSchedule(start, end, jSchedule);
                    result.append("J");
                } else if (isConflict(start, end, cSchedule) && !isImpossible) {
                    addSchedule(start, end, jSchedule);
                    result.append("J");
                } else if (isConflict(start, end, jSchedule) && !isImpossible) {
                    addSchedule(start, end, cSchedule);
                    result.append("C");
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + (i + 1) + ": " + result.toString());
            }
        }

        scanner.close();
    }

    static void addSchedule(int start, int end, List<Integer> schedule) {
        for (int i = start; i <= end; i++) {
            schedule.add(i);
        }
    }

    static boolean isConflict(int start, int end, List<Integer> schedule) {
        if (schedule.contains(start) && schedule.contains(end)) {
            return true;
        }
        for (int i = start + 1; i < end; i++) {
            if (schedule.contains(i)) {
                return true;
            }
        }
        return false;
    }
}