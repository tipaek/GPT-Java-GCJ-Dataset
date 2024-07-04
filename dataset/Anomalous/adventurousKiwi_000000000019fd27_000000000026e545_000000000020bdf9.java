import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static boolean isTimeSlotFree(boolean[] calendar, int start, int end) {
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

        for (int t = 0; t < testCases; t++) {

            int activities = Integer.parseInt(scanner.nextLine());

            boolean[] jamieCalendar = new boolean[24 * 60];
            boolean[] cameronCalendar = new boolean[24 * 60];
            int[] activityOverlap = new int[24 * 60];

            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            for (int a = 0; a < activities; a++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());

                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());

                for (int k = start; k < end; k++) {
                    activityOverlap[k]++;
                    if (activityOverlap[k] > 2) {
                        isImpossible = true;
                        break;
                    }
                }

                if (isImpossible) break;

                if (isTimeSlotFree(jamieCalendar, start, end)) {
                    for (int k = start; k < end; k++) {
                        jamieCalendar[k] = true;
                    }
                    result.append("J");
                } else if (isTimeSlotFree(cameronCalendar, start, end)) {
                    for (int k = start; k < end; k++) {
                        cameronCalendar[k] = true;
                    }
                    result.append("C");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (t + 1) + ": " + result.toString());
            }
        }

        scanner.close();
    }
}