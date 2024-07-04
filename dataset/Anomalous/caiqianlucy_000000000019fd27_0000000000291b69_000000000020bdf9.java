import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(scanner.nextLine());
            List<int[]> cSchedule = new ArrayList<>();
            List<int[]> jSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split("\\s");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                int[] timeSlot = new int[]{start, end};

                if (canInsert(cSchedule, timeSlot)) {
                    result.append('C');
                } else if (canInsert(jSchedule, timeSlot)) {
                    result.append('J');
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }

    private static boolean canInsert(List<int[]> schedule, int[] newSlot) {
        int start = newSlot[0], end = newSlot[1];

        for (int i = 0; i < schedule.size(); i++) {
            int[] currentSlot = schedule.get(i);

            if (start < currentSlot[0]) {
                if (end <= currentSlot[0]) {
                    schedule.add(i, newSlot);
                    return true;
                } else if (end == currentSlot[0]) {
                    schedule.set(i, new int[]{start, currentSlot[1]});
                    return true;
                } else {
                    return false;
                }
            } else if (start < currentSlot[1]) {
                return false;
            }
        }

        if (!schedule.isEmpty() && schedule.get(schedule.size() - 1)[1] == start) {
            schedule.set(schedule.size() - 1, new int[]{schedule.get(schedule.size() - 1)[0], end});
        } else {
            schedule.add(newSlot);
        }

        return true;
    }
}