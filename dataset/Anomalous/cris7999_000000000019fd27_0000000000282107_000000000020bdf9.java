import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();

        for (int test = 1; test <= numTests; test++) {
            int numActivities = scanner.nextInt();
            List<int[]> cameronSchedule = new ArrayList<>();
            List<int[]> jaimeSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (canPerformActivity(cameronSchedule, start, end)) {
                    cameronSchedule.add(new int[]{start, end});
                    result.append('C');
                } else if (canPerformActivity(jaimeSchedule, start, end)) {
                    jaimeSchedule.add(new int[]{start, end});
                    result.append('J');
                } else {
                    isImpossible = true;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + test + ": " + result.toString());
            }
        }
    }

    private static boolean canPerformActivity(List<int[]> schedule, int start, int end) {
        for (int[] activity : schedule) {
            if (start < activity[1] && end > activity[0]) {
                return false;
            }
        }
        return true;
    }
}