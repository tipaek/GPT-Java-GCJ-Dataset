import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int activitiesCount = scanner.nextInt();
            int[][] cameronSchedule = new int[activitiesCount][2];
            int[][] jamieSchedule = new int[activitiesCount][2];
            int cameronCount = 0;
            int jamieCount = 0;
            StringBuilder scheduleOrder = new StringBuilder();
            boolean isPossible = true;

            for (int n = 0; n < activitiesCount; n++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isTimeAvailable(start, end, cameronSchedule, cameronCount)) {
                    cameronSchedule[cameronCount][0] = start;
                    cameronSchedule[cameronCount][1] = end;
                    cameronCount++;
                    scheduleOrder.append('C');
                } else if (isTimeAvailable(start, end, jamieSchedule, jamieCount)) {
                    jamieSchedule[jamieCount][0] = start;
                    jamieSchedule[jamieCount][1] = end;
                    jamieCount++;
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
    }

    static boolean isTimeAvailable(int start, int end, int[][] schedule, int count) {
        for (int i = 0; i < count; i++) {
            if ((start >= schedule[i][0] && start < schedule[i][1]) || (end > schedule[i][0] && end <= schedule[i][1])) {
                return false;
            }
        }
        return true;
    }
}