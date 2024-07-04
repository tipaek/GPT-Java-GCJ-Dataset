import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder resultBuilder = new StringBuilder();
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            Map<Integer, Integer> cSchedule = new HashMap<>();
            Map<Integer, Integer> jSchedule = new HashMap<>();
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            for (int a = 0; a < n; a++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (a == 0) {
                    cSchedule.put(start, end);
                    schedule.append("C");
                } else {
                    boolean canAssignToC = canAssign(schedule, cSchedule, start, end);
                    boolean canAssignToJ = canAssign(schedule, jSchedule, start, end);

                    if (canAssignToC) {
                        schedule.append("C");
                        cSchedule.put(start, end);
                    } else if (canAssignToJ) {
                        schedule.append("J");
                        jSchedule.put(start, end);
                    } else {
                        isImpossible = true;
                    }
                }
            }

            if (isImpossible) {
                resultBuilder.append("Case #").append(i).append(": IMPOSSIBLE\n");
            } else {
                resultBuilder.append("Case #").append(i).append(": ").append(schedule).append("\n");
            }
        }

        System.out.println(resultBuilder);
    }

    private static boolean canAssign(StringBuilder schedule, Map<Integer, Integer> scheduleMap, int start, int end) {
        for (Map.Entry<Integer, Integer> entry : scheduleMap.entrySet()) {
            int existingStart = entry.getKey();
            int existingEnd = entry.getValue();

            if (!(end <= existingStart || start >= existingEnd)) {
                return false;
            }
        }
        return true;
    }
}