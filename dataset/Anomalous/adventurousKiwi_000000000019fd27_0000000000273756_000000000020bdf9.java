import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    private static boolean isFree(boolean[] calendar, int start, int end) {
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

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = Integer.parseInt(scanner.nextLine());

            boolean[] jamieCalendar = new boolean[24 * 60 + 5];
            boolean[] cameronCalendar = new boolean[24 * 60 + 5];
            int[] daySchedule = new int[24 * 60 + 5];

            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();

            for (int activity = 0; activity < numActivities; activity++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());

                int startTime = Integer.parseInt(tokenizer.nextToken());
                int endTime = Integer.parseInt(tokenizer.nextToken());

                for (int time = startTime; time < endTime; time++) {
                    daySchedule[time]++;
                    if (daySchedule[time] > 2) {
                        isImpossible = true;
                    }
                }

                if (isFree(jamieCalendar, startTime, endTime)) {
                    for (int time = startTime; time < endTime; time++) {
                        jamieCalendar[time] = true;
                    }
                    schedule.append("J");
                } else if (isFree(cameronCalendar, startTime, endTime)) {
                    for (int time = startTime; time < endTime; time++) {
                        cameronCalendar[time] = true;
                    }
                    schedule.append("C");
                } else {
                    isImpossible = true;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNum + ": " + schedule.toString());
            }
        }

        scanner.close();
    }
}