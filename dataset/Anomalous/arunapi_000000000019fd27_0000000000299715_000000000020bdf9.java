import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            int[][] cDiary = new int[numActivities][2];
            int[][] jDiary = new int[numActivities][2];

            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (!isOccupied(start, end, cDiary, i)) {
                    schedule.append("C");
                    cDiary[i][0] = start;
                    cDiary[i][1] = end;
                    jDiary[i][0] = -1;
                    jDiary[i][1] = -1;
                } else if (!isOccupied(start, end, jDiary, i)) {
                    schedule.append("J");
                    jDiary[i][0] = start;
                    jDiary[i][1] = end;
                    cDiary[i][0] = -1;
                    cDiary[i][1] = -1;
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + caseNum + ": " + schedule.toString());
        }
    }

    private static boolean isOccupied(int start, int end, int[][] diary, int activityCount) {
        for (int i = 0; i < activityCount; i++) {
            int diaryStart = diary[i][0];
            int diaryEnd = diary[i][1];
            if (!((start < diaryStart && end <= diaryStart) || start >= diaryEnd)) {
                return true;
            }
        }
        return false;
    }
}