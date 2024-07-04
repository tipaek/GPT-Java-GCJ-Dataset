import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int activities = scanner.nextInt();
            int[][] cSchedule = new int[activities][2];
            int[][] jSchedule = new int[activities][2];
            int cCount = 0, jCount = 0;
            StringBuilder scheduleOrder = new StringBuilder();
            boolean isPossible = true;

            for (int n = 0; n < activities; n++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isTimeAvailable(start, end, cSchedule, cCount)) {
                    cSchedule[cCount][0] = start;
                    cSchedule[cCount][1] = end;
                    cCount++;
                    scheduleOrder.append('C');
                } else if (isTimeAvailable(start, end, jSchedule, jCount)) {
                    jSchedule[jCount][0] = start;
                    jSchedule[jCount][1] = end;
                    jCount++;
                    scheduleOrder.append('J');
                } else {
                    System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + (t + 1) + ": " + scheduleOrder.toString());
            }
        }
        scanner.close();
    }

    private static boolean isTimeAvailable(int start, int end, int[][] schedule, int count) {
        for (int i = 0; i < count; i++) {
            if ((start >= schedule[i][0] && start < schedule[i][1]) || 
                (end > schedule[i][0] && end <= schedule[i][1]) || 
                (start <= schedule[i][0] && end >= schedule[i][1])) {
                return false;
            }
        }
        return true;
    }
}