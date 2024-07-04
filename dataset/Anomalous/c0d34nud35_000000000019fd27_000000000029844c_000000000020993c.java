import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int N = scanner.nextInt();
            int[][] cSchedule = new int[N][2];
            int[][] jSchedule = new int[N][2];
            int cCount = 0, jCount = 0;
            StringBuilder order = new StringBuilder();
            boolean isPossible = true;

            for (int n = 0; n < N; n++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (hasTime(start, end, cSchedule, cCount)) {
                    cSchedule[cCount][0] = start;
                    cSchedule[cCount][1] = end;
                    cCount++;
                    order.append('C');
                } else if (hasTime(start, end, jSchedule, jCount)) {
                    jSchedule[jCount][0] = start;
                    jSchedule[jCount][1] = end;
                    jCount++;
                    order.append('J');
                } else {
                    System.out.println("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println(order.toString());
            }
        }

        scanner.close();
    }

    private static boolean hasTime(int start, int end, int[][] schedule, int count) {
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