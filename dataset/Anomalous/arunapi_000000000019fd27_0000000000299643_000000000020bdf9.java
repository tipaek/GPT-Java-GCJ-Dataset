import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int activitiesCount = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            int[][] cDiary = new int[activitiesCount][2];
            int[][] jDiary = new int[activitiesCount][2];

            for (int j = 0; j < activitiesCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (!isOccupied(start, end, cDiary, j)) {
                    schedule.append("C");
                    cDiary[j][0] = start;
                    cDiary[j][1] = end;
                    jDiary[j][0] = -1;
                    jDiary[j][1] = -1;
                } else if (!isOccupied(start, end, jDiary, j)) {
                    schedule.append("J");
                    jDiary[j][0] = start;
                    jDiary[j][1] = end;
                    cDiary[j][0] = -1;
                    cDiary[j][1] = -1;
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + schedule);
        }
    }

    private static boolean isOccupied(int start, int end, int[][] diary, int activityCount) {
        for (int i = 0; i < activityCount; i++) {
            int startTime = diary[i][0];
            int endTime = diary[i][1];
            if (!(start < startTime && end <= startTime || start >= endTime)) {
                return true;
            }
        }
        return false;
    }
}