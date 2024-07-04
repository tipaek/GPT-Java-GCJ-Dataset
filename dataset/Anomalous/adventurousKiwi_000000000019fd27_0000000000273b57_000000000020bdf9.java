import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static boolean isFree(boolean[] calendar, int start, int end) {
        for (int i = start; i < end; i++) {
            if (calendar[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activities = Integer.parseInt(scanner.nextLine());
            boolean[] jamieSchedule = new boolean[24 * 60 + 1];
            boolean[] cameronSchedule = new boolean[24 * 60 + 1];
            int[] daySchedule = new int[24 * 60 + 1];
            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();

            for (int activity = 0; activity < activities; activity++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                int startTime = Integer.parseInt(tokenizer.nextToken());
                int endTime = Integer.parseInt(tokenizer.nextToken());

                for (int time = startTime; time < endTime; time++) {
                    daySchedule[time]++;
                    if (daySchedule[time] > 2) {
                        isImpossible = true;
                    }
                }

                if (isFree(jamieSchedule, startTime, endTime)) {
                    for (int time = startTime; time < endTime; time++) {
                        jamieSchedule[time] = true;
                    }
                    schedule.append("J");
                } else {
                    for (int time = startTime; time < endTime; time++) {
                        cameronSchedule[time] = true;
                    }
                    schedule.append("C");
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            }
        }
        scanner.close();
    }
}