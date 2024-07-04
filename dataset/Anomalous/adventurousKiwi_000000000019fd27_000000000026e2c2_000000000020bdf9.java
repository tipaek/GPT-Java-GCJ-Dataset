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

        for (int testCase = 0; testCase < testCases; testCase++) {
            int activitiesCount = Integer.parseInt(scanner.nextLine());
            boolean[] jamieCalendar = new boolean[24 * 60 + 1];
            boolean[] cameronCalendar = new boolean[24 * 60 + 1];
            int[] overlapTracker = new int[24 * 60 + 1];

            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();

            for (int activity = 0; activity < activitiesCount; activity++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());

                for (int time = start; time < end; time++) {
                    overlapTracker[time]++;
                    if (overlapTracker[time] > 2) {
                        isImpossible = true;
                        break;
                    }
                }
                if (isImpossible) break;

                if (isFree(jamieCalendar, start, end)) {
                    for (int time = start; time < end; time++) {
                        jamieCalendar[time] = true;
                    }
                    schedule.append("J");
                } else if (isFree(cameronCalendar, start, end)) {
                    for (int time = start; time < end; time++) {
                        cameronCalendar[time] = true;
                    }
                    schedule.append("C");
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (testCase + 1) + ": " + schedule.toString());
            }
        }
        scanner.close();
    }
}